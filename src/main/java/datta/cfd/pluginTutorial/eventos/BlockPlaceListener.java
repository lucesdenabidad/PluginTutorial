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
        Block block = event.getBlock();
        Material type = block.getType();

        if (PluginTutorial.BLOQUES_BLOQUEADOS.contains(type)) {
            player.sendMessage("Este bloque no se puede colocar porque " + type + " esta bloqueado.");
            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, SoundCategory.MASTER, 1, 1);
            player.sendTitle("¡Error!", "Este bloque esta bloqueado.", 5, 60, 5);

            event.setCancelled(true);
        }
    }
}
