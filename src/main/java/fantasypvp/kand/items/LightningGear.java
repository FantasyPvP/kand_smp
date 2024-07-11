package fantasypvp.kand.items;

import fantasypvp.kand.util.attribute_gear.TierVI;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.bukkit.Bukkit.getServer;

public class LightningGear {
    public static ItemStack lightning_sword;

    public static void init() {
        lightningSword();
    }

    private static void lightningSword() {
        ItemStack item = new ItemStack(Material.NETHERITE_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Lightning Sword");
        List<String> lore = new ArrayList<>();
        lore.add("§7All who oppose shall be smitten");
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
        lightning_sword = item;

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
    }
}
























