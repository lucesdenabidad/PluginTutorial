package datta.cfd.pluginTutorial.comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HelloWorldCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender,
                             @NotNull Command cmd,
                             @NotNull String alias,
                             @NotNull String[] args) {

        if (!(commandSender instanceof Player)) { // --> Solo los jugadores podran ejecutar este comando.
            commandSender.sendMessage("Solo los jugadores pueden ejecutar este comando.");
            return false;
        }

        Player player = (Player) commandSender;
        player.sendMessage("Hola mundo!"); // --> Enviamos un mensaje al jugador

        return true;
    }
}
