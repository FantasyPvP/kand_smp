package fantasypvp.kand_smp.events;

import fantasypvp.kand_smp.items.DashItem;

import org.bukkit.Location;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class DashItemListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        ItemStack item = event.getItem(); // Get the item the player interacted with
        if (item != null && item.isSimilar(new DashItem().createDashItem())) {

            Player player = event.getPlayer();

            Location location = player.getLocation();

            Vector direction = location.getDirection();

            player.setVelocity(direction.multiply(2.0));

            player.playSound(location, Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 1.0f, 1.0f);

            World world = player.getWorld();

            world.spawnParticle(Particle.EXPLOSION_LARGE,location,1);

        }
    }

    @EventHandler
    public void OnEntityDamage(EntityDamageEvent event){
        if(event.getEntity() instanceof Player){

            Player player = (Player) event.getEntity();

            ItemStack itemInMainHand = player.getInventory().getItemInMainHand();

            if (itemInMainHand.isSimilar(new DashItem().createDashItem())) {

                event.setCancelled(true);

            }

        }
    }
}
