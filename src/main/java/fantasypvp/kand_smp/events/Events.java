package fantasypvp.kand_smp.events;

import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Listener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import org.bukkit.potion.PotionEffect;

import static org.bukkit.Bukkit.*;

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

            if (player.getInventory().getItemInMainHand().getItemMeta().getLore().toString().contains("§7All who oppose shall be smitten")) {
                player.getWorld().strikeLightning(event.getEntity().getLocation());
            }

            else if (player.getInventory().getItemInMainHand().getItemMeta().getLore().toString().contains("§f[T5+] Witherite Sword")) {
                // if affected entity is wearing witherite gear
                if (event.getEntity() instanceof Player) {
                    Player entity = (Player) event.getEntity();
                    if (entity.getInventory().getHelmet().getItemMeta().getLore().toString().contains("§f[T5+] Witherite Helmet")
                            && entity.getInventory().getChestplate().getItemMeta().getLore().toString().contains("§f[T5+] Witherite Chestplate")
                            && entity.getInventory().getLeggings().getItemMeta().getLore().toString().contains("§f[T5+] Witherite Leggings")
                            && entity.getInventory().getBoots().getItemMeta().getLore().toString().contains("§f[T5+] Witherite Boots")) {
                        ;
                    } else {
                        PotionEffect effect = new PotionEffect(
                                org.bukkit.potion.PotionEffectType.WITHER,
                                20 * 5,
                                2
                        );
                        effect.apply((LivingEntity) event.getEntity());
                    }
                } else {
                    PotionEffect effect = new PotionEffect(
                            org.bukkit.potion.PotionEffectType.WITHER,
                            20 * 5,
                            2
                    );
                    effect.apply((LivingEntity) event.getEntity());
                }
            }
        }
    }
}
