package datta.cfd.pluginTutorial;

import datta.cfd.pluginTutorial.comandos.HelloWorldCommand;
import datta.cfd.pluginTutorial.eventos.BlockBreakListener;
import datta.cfd.pluginTutorial.eventos.BlockPlaceListener;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class PluginTutorial extends JavaPlugin implements Listener {

    public static final List<Material> BLOQUES_BLOQUEADOS = new ArrayList<>(List.of( // --> Estamos haciendo una lista publica estatica para obtenerla desde otra clase.
            Material.STONE,
            Material.COBBLESTONE,
            Material.DIRT
    ));

    @Override
    public void onEnable() {

        // # Eventos
        Bukkit.getPluginManager().registerEvents(new BlockBreakListener(), this); // --> Estamos registrando lo eventos de romper y colocar bloques.
        Bukkit.getPluginManager().registerEvents(new BlockPlaceListener(), this);

        // # Comandos
        getCommand("helloworld").setExecutor(new HelloWorldCommand()); // --> Estamos registrando el comando 'helloworld' --> ¡Revisa plugin.yml!

        // # Log
        getLogger().info("El plugin a cargado con éxito.");
    }

    @Override
    public void onDisable() {

        // # Log
        getLogger().info("El plugin fue desactivado con éxito.");
    }

}