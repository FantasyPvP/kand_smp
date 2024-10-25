package fantasypvp.kand.items;

import fantasypvp.kand.util.gear_templates.TierIV;
import fantasypvp.kand.util.gear_templates.TierV;
import org.bukkit.*;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.bukkit.Bukkit.getServer;

public class BlessedSet implements Listener, CommandExecutor {
    private ArrayList<Player> cooldown = new ArrayList<>();

    public static ItemStack sword() {
        ItemStack item = TierV.sword();

        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        lore.add("§fA sword blessed by Steven");
        meta.setLore(lore);
        meta.setDisplayName("§bBlessed Sword");
        item.setItemMeta(meta);

        return item;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem(); // Get the item the player interacted with

        if (!(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
            return;
        }

        if (item == null || event.getHand() != EquipmentSlot.HAND) {
            return;
        }

        try {
            ItemMeta meta = item.getItemMeta();
            List<String> lore = meta.getLore();
            if (!lore.toString().contains("§fA sword blessed by Steven")) {
                return;
            }
        } catch (Exception e) {
            return;
        }

        if (cooldown.contains(player)) {
            return;
        }

        Egg egg = event.getPlayer().launchProjectile(Egg.class);
        // set some custom hidden data for the egg that allows us to distinguish it
        egg.setCustomName("blessed egg");

        Location location = player.getLocation();
        player.playSound(location, Sound.ENTITY_GENERIC_EXPLODE, 1.0f, 1.0f);
        World world = player.getWorld();
        world.spawnParticle(Particle.EXPLOSION_NORMAL, location, 1);

        cooldown.add(player);
        Bukkit.getScheduler().scheduleSyncDelayedTask(
                Objects.requireNonNull(Bukkit.getPluginManager().getPlugin("kand")),
                () -> cooldown.remove(player),
                5
        );
    }

    @EventHandler
    public void onProjectileHit(org.bukkit.event.entity.ProjectileHitEvent event) {
        if (event.getEntity() instanceof Egg && ((Egg) event.getEntity()).getCustomName().equals("blessed egg")) {
            ((LivingEntity) event.getHitEntity()).damage(8);
            event.getEntity().getWorld().spawnParticle(Particle.EXPLOSION_NORMAL, event.getEntity().getLocation(), 1);
        }
    }

    @Override
    public boolean onCommand(org.bukkit.command.CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command");
            return true;
        }

        Player player = (Player) sender;

        if(player.hasPermission("kand.lightning_sword")) {
            if (command.getName().equalsIgnoreCase("steven_gear")) {
//                player.getInventory().addItem(DragonSet.helmet);
//                player.getInventory().addItem(DragonSet.chestplate);
//                player.getInventory().addItem(DragonSet.leggings);
//                player.getInventory().addItem(DragonSet.boots);
                player.getInventory().addItem(sword());
            }

        } else {
            player.sendMessage(ChatColor.RED+"You don't have permission to run this command.");
        }

        return true;
    }
}
