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

public class Items  {
    public static ItemStack true_netherite_sword;
    public static ItemStack true_netherite_helmet;
    public static ItemStack true_netherite_chestplate;
    public static ItemStack true_netherite_leggings;
    public static ItemStack true_netherite_boots;


    public static void init() {
        trueNetheriteSword();
        trueNetheriteHelmet();
        trueNetheriteChestplate();
        trueNetheriteLeggings();
        trueNetheriteBoots();
    }


    private static void trueNetheriteSword() {
        ItemStack item = new ItemStack(Material.NETHERITE_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§bTrue Netherite Sword");

        meta.addAttributeModifier(
                org.bukkit.attribute.Attribute.GENERIC_ATTACK_DAMAGE,
                new AttributeModifier(
                        "generic.attackDamage",
                        10.0,
                        AttributeModifier.Operation.ADD_NUMBER
                )
        );

        List<String> lore = new ArrayList<>();
        lore.add("§fThe true sword of the Nether");
        meta.setLore(lore);
        item.setItemMeta(meta);

        true_netherite_sword = item;

        RecipeChoice netherite_upgrade = new RecipeChoice.MaterialChoice(Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE);
        RecipeChoice nether_star = new RecipeChoice.MaterialChoice(Material.NETHER_STAR);
        RecipeChoice netherite_sword = new RecipeChoice.MaterialChoice(Material.NETHERITE_SWORD);
        NamespacedKey key = new NamespacedKey("fantasypvp.kand_smp.items", "true_netherite_sword");

        SmithingTransformRecipe recipe = new SmithingTransformRecipe(key, item, netherite_upgrade, nether_star, netherite_sword);
        getServer().addRecipe(recipe);
    }

    private static void trueNetheriteHelmet() {
        ItemStack item = new ItemStack(Material.NETHERITE_HELMET, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§bTrue Netherite Helmet");

        meta.addAttributeModifier(
                Attribute.GENERIC_MAX_HEALTH,
                new AttributeModifier(
                        "generic.maxHealth",
                        5.0,
                        AttributeModifier.Operation.ADD_NUMBER
                )
        );
        item.setItemMeta(meta);
        true_netherite_helmet = item;

        RecipeChoice netherite_upgrade = new RecipeChoice.MaterialChoice(Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE);
        RecipeChoice nether_star = new RecipeChoice.MaterialChoice(Material.NETHER_STAR);
        RecipeChoice netherite_helmet = new RecipeChoice.MaterialChoice(Material.NETHERITE_HELMET);
        NamespacedKey key = new NamespacedKey("fantasypvp.kand_smp.items", "true_netherite_helmet");

        SmithingTransformRecipe recipe = new SmithingTransformRecipe(key, item, netherite_upgrade, nether_star, netherite_helmet);
        getServer().addRecipe(recipe);
    }

    private static void trueNetheriteChestplate() {
        ItemStack item = new ItemStack(Material.NETHERITE_CHESTPLATE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§bTrue Netherite Chestplate");

        meta.addAttributeModifier(
                Attribute.GENERIC_MAX_HEALTH,
                new AttributeModifier(
                        "generic.maxHealth",
                        5.0,
                        AttributeModifier.Operation.ADD_NUMBER
                )
        );
        item.setItemMeta(meta);
        true_netherite_chestplate = item;

        RecipeChoice netherite_upgrade = new RecipeChoice.MaterialChoice(Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE);
        RecipeChoice nether_star = new RecipeChoice.MaterialChoice(Material.NETHER_STAR);
        RecipeChoice netherite_chestplate = new RecipeChoice.MaterialChoice(Material.NETHERITE_CHESTPLATE);
        NamespacedKey key = new NamespacedKey("fantasypvp.kand_smp.items", "true_netherite_chestplate");

        SmithingTransformRecipe recipe = new SmithingTransformRecipe(key, item, netherite_upgrade, nether_star, netherite_chestplate);
        getServer().addRecipe(recipe);
    }

    private static void trueNetheriteLeggings() {
        ItemStack item = new ItemStack(Material.NETHERITE_LEGGINGS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§bTrue Netherite Leggings");

        meta.addAttributeModifier(
                Attribute.GENERIC_MAX_HEALTH,
                new AttributeModifier(
                        "generic.maxHealth",
                        5.0,
                        AttributeModifier.Operation.ADD_NUMBER
                )
        );
        item.setItemMeta(meta);
        true_netherite_leggings = item;

        RecipeChoice netherite_upgrade = new RecipeChoice.MaterialChoice(Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE);
        RecipeChoice nether_star = new RecipeChoice.MaterialChoice(Material.NETHER_STAR);
        RecipeChoice netherite_leggings = new RecipeChoice.MaterialChoice(Material.NETHERITE_LEGGINGS);
        NamespacedKey key = new NamespacedKey("fantasypvp.kand_smp.items", "true_netherite_leggings");

        SmithingTransformRecipe recipe = new SmithingTransformRecipe(key, item, netherite_upgrade, nether_star, netherite_leggings);
        getServer().addRecipe(recipe);
    }

    private static void trueNetheriteBoots() {
        ItemStack item = new ItemStack(Material.NETHERITE_BOOTS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§bTrue Netherite Boots");

        meta.addAttributeModifier(
                Attribute.GENERIC_MAX_HEALTH,
                new AttributeModifier(
                        "generic.maxHealth",
                        5.0,
                        AttributeModifier.Operation.ADD_NUMBER
                )
        );
        item.setItemMeta(meta);
        true_netherite_boots = item;

        RecipeChoice netherite_upgrade = new RecipeChoice.MaterialChoice(Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE);
        RecipeChoice nether_star = new RecipeChoice.MaterialChoice(Material.NETHER_STAR);
        RecipeChoice netherite_boots = new RecipeChoice.MaterialChoice(Material.NETHERITE_BOOTS);
        NamespacedKey key = new NamespacedKey("fantasypvp.kand_smp.items", "true_netherite_boots");

        SmithingTransformRecipe recipe = new SmithingTransformRecipe(key, item, netherite_upgrade, nether_star, netherite_boots);
        getServer().addRecipe(recipe);
    }
}
























