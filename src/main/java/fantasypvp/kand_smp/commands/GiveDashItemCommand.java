package fantasypvp.kand_smp.commands;

import fantasypvp.kand_smp.items.DashItem;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GiveDashItemCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(!(sender instanceof Player)){
            sender.sendMessage("You must be a player to execute this command");
            return true;
        }

        Player player = (Player) sender;

        if(!(player.hasPermission("giveDashItem"))){
            player.sendMessage(ChatColor.RED+"You don't have permission to run this command.");
            return true;
        }

        ItemStack dashItem = new DashItem().createDashItem();

        player.getInventory().addItem(dashItem);


        return true;
    }
}
