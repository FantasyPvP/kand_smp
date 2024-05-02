package fantasypvp.kand_smp.items;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

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
        meta.addAttributeModifier(
                Attribute.GENERIC_ATTACK_DAMAGE,
                new AttributeModifier(
                        "generic.attackDamage",
                        12,
                        AttributeModifier.Operation.ADD_NUMBER
                )
        );
        item.setItemMeta(meta);
        lightning_sword = item;

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        // shaped recipe
        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("lightning_sword"), item);
        recipe.shape(
                "  X",
                " X ",
                "H  "
        );
        recipe.setIngredient('X', Material.NETHER_STAR);
        recipe.setIngredient('H', Material.LIGHTNING_ROD);

        getServer().addRecipe(recipe);
    }
}
























