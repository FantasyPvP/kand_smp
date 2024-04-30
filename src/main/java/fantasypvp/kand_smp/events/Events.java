package fantasypvp.kand_smp.events;

import org.bukkit.event.Listener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import static org.bukkit.Bukkit.getServer;

public class Events implements Listener {
    @EventHandler
    public static void onPlayerJoin(org.bukkit.event.player.PlayerJoinEvent event) {
        getServer().broadcastMessage("§a" + event.getPlayer().getName() + " has joined the server!");
    }

    @EventHandler
    public static void onEntityDamageByEntity(org.bukkit.event.entity.EntityDamageByEntityEvent event) {

        if (event.getDamager() instanceof org.bukkit.entity.Player) {
            Player player = (Player) event.getDamager();
            // check if the player is using the lightning sword
            if (player.getInventory().getItemInMainHand().getType() == org.bukkit.Material.NETHERITE_SWORD && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("Lightning Sword")) {
                player.getWorld().strikeLightning(event.getEntity().getLocation());
            }
        }
    }
}
