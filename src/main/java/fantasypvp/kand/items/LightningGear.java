package fantasypvp.kand.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;
import java.util.UUID;

import static org.bukkit.Bukkit.getServer;

public class LightningGear implements Listener, CommandExecutor {

    @EventHandler
    public static void onEntityDamageByEntity(org.bukkit.event.entity.EntityDamageByEntityEvent event) {

        if (event.getDamager() instanceof org.bukkit.entity.Player) {
            Player player = (Player) event.getDamager();
            // check if the player is using the lightning sword

            try {
                player.getInventory().getItemInMainHand().getItemMeta().getLore().toString();
            } catch (NullPointerException e) {
                return;
            }

            if (player.getInventory().getItemInMainHand().getItemMeta().getLore().toString().contains(ChatColor.YELLOW + "All Who Oppose Shall Be SMITTEN!")) {
                // check if hit is critical
                if (player.getFallDistance() > 0.0F && !player.isInsideVehicle() && !player.isGliding() && !player.isSwimming() && !player.isClimbing() && player.getAttackCooldown() == 1.0F) {
                    player.getWorld().strikeLightningEffect(event.getEntity().getLocation());
                }
            }
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
            if (command.getName().equalsIgnoreCase("lightning_sword")) {
                player.getInventory().addItem(lightningSword());
            }

        } else {
            player.sendMessage(ChatColor.RED+"You don't have permission to run this command.");
        }

        return true;
    }

    public static ItemStack lightningSword() {
        ItemStack item = new ItemStack(Material.NETHERITE_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Lightning Sword");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.YELLOW + "All Who Oppose Shall Be SMITTEN!");
        meta.setLore(lore);
        // set damage to 12 when in main hand
        UUID uuid = UUID.randomUUID();

        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(
                uuid,
                "generic.attackDamage",
                8,
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlot.HAND
        ));
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(
                UUID.randomUUID(),
                "generic.attackSpeed",
                -2.4,
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlot.HAND
        ));
        item.setItemMeta(meta);

        // shaped recipe
        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("lightning_sword"), item);
        recipe.shape(
                " X ",
                " X ",
                " H "
        );
        recipe.setIngredient('X', Material.NETHER_STAR);
        recipe.setIngredient('H', Material.LIGHTNING_ROD);

        getServer().addRecipe(recipe);
        return item;
    }
}
























