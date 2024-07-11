package fantasypvp.kand.commands;

import fantasypvp.kand.items.KandCoin;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import static org.bukkit.Bukkit.broadcastMessage;

public class KandCoinCmd implements CommandExecutor, Listener {
    @Override
    public boolean onCommand(org.bukkit.command.CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command");
            return true;
        }

        broadcastMessage("Kand Coin: ");

        Player player = (Player) sender;


        if (player.hasPermission("kand.economy.admin")) {
            if (command.getName().equalsIgnoreCase("get_currency")) {

                ItemStack k = KandCoin.kandCoin;

                int quantity;
                try {
                   quantity = Integer.parseInt(args[0]);

                } catch (NumberFormatException e) {
                    player.sendMessage(ChatColor.RED + "Invalid quantity");
                    return true;
                }

                broadcastMessage(quantity + " " + k.getItemMeta().getDisplayName() + " added to your inventory.");

                k.setAmount(quantity);
                player.getInventory().addItem(KandCoin.kandCoin);
            }

        } else {
            player.sendMessage(ChatColor.RED + "You don't have permission to run this command.");
        }

        return true;
    }

    @EventHandler
    public boolean onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (!p.hasPlayedBefore()) {
            ItemStack k = KandCoin.kandCoin;
            int quantity = 16;
            k.setAmount(quantity);
            p.sendMessage(quantity + " " + k.getItemMeta().getDisplayName() + " welcome to KandSMP\n you have received 16 Kand coins to get you started!");
            p.getInventory().addItem(k);
        }
        return true;
    }
}



















