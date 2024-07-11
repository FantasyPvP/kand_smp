package fantasypvp.kand.commands;

import fantasypvp.kand.items.LightningGear;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;

public class CmdLightningSword implements CommandExecutor {

    @Override
    public boolean onCommand(org.bukkit.command.CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command");
            return true;
        }

        Player player = (Player) sender;

        if(player.hasPermission("kand.lightning_sword")) {
            if (command.getName().equalsIgnoreCase("lightning_sword")) {
                player.getInventory().addItem(LightningGear.lightning_sword);
            }

        } else {
            player.sendMessage(ChatColor.RED+"You don't have permission to run this command.");
        }

        return true;
    }
}

