package fantasypvp.kand.items;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class DashItem extends ItemStack implements CommandExecutor, Listener {

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

    public ItemStack createDashItem(){
        ItemStack item = new ItemStack(Material.STICK,1);
        ItemMeta meta = item.getItemMeta();
        List<String>stickLore = new ArrayList<>();
        stickLore.add("Click this stick and you'll be there in a jiffy.");
        stickLore.add("About this, don't get sniffy.");
        meta.setLore(stickLore);
        meta.setDisplayName(ChatColor.AQUA+"[Dash"+ChatColor.BLUE+" Stick]");
        item.setItemMeta(meta);
        return item;
    }
}
