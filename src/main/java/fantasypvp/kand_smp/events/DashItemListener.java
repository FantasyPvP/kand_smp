package fantasypvp.kand_smp.events;

import fantasypvp.kand_smp.items.DashItem;

import org.bukkit.Location;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class DashItemListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem(); // Get the item the player interacted with

        // Check if the interaction was a right-click and the item is in the main hand
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (item != null && item.isSimilar(new DashItem().createDashItem()) && event.getHand() == EquipmentSlot.HAND) {
                Location location = player.getLocation();
                Vector direction = location.getDirection();
                player.setVelocity(direction.multiply(5.0));
                player.playSound(location, Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 1.0f, 1.0f);
                World world = player.getWorld();
                world.spawnParticle(Particle.EXPLOSION_HUGE, location, 1);
            }
        }
    }

    @EventHandler
    public void OnEntityDamage(EntityDamageEvent event){
        if(event.getEntity() instanceof Player){

            Player player = (Player) event.getEntity();

            ItemStack itemInMainHand = player.getInventory().getItemInMainHand();

            if (itemInMainHand.isSimilar(new DashItem().createDashItem()) && event.getCause() == EntityDamageEvent.DamageCause.FALL) {

                event.setCancelled(true);

            }

        }
    }
}
