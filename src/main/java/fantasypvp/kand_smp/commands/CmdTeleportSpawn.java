package fantasypvp.kand_smp.commands;

import org.bukkit.Location;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;


public class CmdTeleportSpawn implements CommandExecutor {
    public boolean onCommand(org.bukkit.command.CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("spawn")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("Only players can use this command");
                return true;
            }
        }
        Player player = (Player) sender;
        Location location = player.getWorld().getSpawnLocation();

        player.teleport(location);
        return true;
    }
}
