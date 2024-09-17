package datta.cfd.pluginTutorial.eventos;

import datta.cfd.pluginTutorial.PluginTutorial;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements Listener {

    @EventHandler
    public void colocarBloque(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock(); // --> Estamos obteniendo el bloque del evento
        Material type = block.getType(); // --> Estamos obteniendo el material del bloque

        if (PluginTutorial.BLOQUES_BLOQUEADOS.contains(type)) {
            player.sendMessage("Este bloque no se puede colocar porque " + type + " esta bloqueado."); // --> Estamos enviendo un mensaje al jugador.
            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, SoundCategory.MASTER, 1, 1); // --> Estamos reproduciendo un sonido al jugador.
            player.sendTitle("¡Error!", "Este bloque esta bloqueado.", 5, 60, 5); // --> Estamos enviandole un titulo y subtitulo al jugador.

            event.setCancelled(true); // --> Estamos cancelando el evento, es decir no se rompe el bloque.

        }
    }
}
