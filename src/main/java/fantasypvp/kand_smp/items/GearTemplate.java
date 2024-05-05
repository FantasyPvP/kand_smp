package fantasypvp.kand_smp.items;

import fantasypvp.kand_smp.util.attribute_gear.TierV;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

import static org.bukkit.Bukkit.getServer;

public class GearTemplate  {
    public static ItemStack sword;
    public static ItemStack helmet;
    public static ItemStack chestplate;
    public static ItemStack leggings;
    public static ItemStack boots;

    private static RecipeChoice netherite_upgrade;
    private static RecipeChoice upgrade_ingredient;

    public static void init() {
        netherite_upgrade = new RecipeChoice.MaterialChoice(Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE);

        // THIS MUST BE CHANGED
        upgrade_ingredient = new RecipeChoice.MaterialChoice(Material.BARRIER);

        sword();
        helmet();
        chestplate();
        leggings();
        boots();
    }

    private static void sword() {
        ItemStack item = TierV.sword();

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§bPLACEHOLDER");
        List<String> lore = new ArrayList<>();
        lore.add("§f<PLACEHOLDER>");
        meta.setLore(lore);
        item.setItemMeta(meta);
        sword = item;

        NamespacedKey key = new NamespacedKey("fantasypvp.kand_smp.items", "PLACEHOLDER_SWORD");
        RecipeChoice sword = new RecipeChoice.MaterialChoice(Material.NETHERITE_SWORD);
        SmithingTransformRecipe recipe = new SmithingTransformRecipe(key, item, netherite_upgrade, upgrade_ingredient, sword);
        getServer().addRecipe(recipe);
    }

    private static void helmet() {
        ItemStack item = TierV.helmet();

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§bPLACEHOLDER");
        item.setItemMeta(meta);
        helmet = item;

        NamespacedKey key = new NamespacedKey("fantasypvp.kand_smp.items", "PLACEHOLDER_HELMET");
        RecipeChoice helmet = new RecipeChoice.MaterialChoice(Material.NETHERITE_HELMET);
        SmithingTransformRecipe recipe = new SmithingTransformRecipe(key, item, netherite_upgrade, upgrade_ingredient, helmet);
        getServer().addRecipe(recipe);
    }

    private static void chestplate() {
        ItemStack item = TierV.chestplate();

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§bPLACEHOLDER");
        item.setItemMeta(meta);
        helmet = item;

        NamespacedKey key = new NamespacedKey("fantasypvp.kand_smp.items", "PLACEHOLDER_CHESTPLATE");
        RecipeChoice chestplate = new RecipeChoice.MaterialChoice(Material.NETHERITE_CHESTPLATE);
        SmithingTransformRecipe recipe = new SmithingTransformRecipe(key, item, netherite_upgrade, upgrade_ingredient, chestplate);
        getServer().addRecipe(recipe);
    }

    private static void leggings() {
        ItemStack item = TierV.leggings();

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§bPLACEHOLDER");
        item.setItemMeta(meta);
        helmet = item;

        NamespacedKey key = new NamespacedKey("fantasypvp.kand_smp.items", "PLACEHOLDER_LEGGINGS");
        RecipeChoice leggings = new RecipeChoice.MaterialChoice(Material.NETHERITE_LEGGINGS);
        SmithingTransformRecipe recipe = new SmithingTransformRecipe(key, item, netherite_upgrade, upgrade_ingredient, leggings);
        getServer().addRecipe(recipe);
    }

    private static void boots() {
        ItemStack item = TierV.boots();

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§bPLACEHOLDER");
        item.setItemMeta(meta);
        helmet = item;

        NamespacedKey key = new NamespacedKey("fantasypvp.kand_smp.items", "PLACEHOLDER_BOOTS");
        RecipeChoice boots = new RecipeChoice.MaterialChoice(Material.NETHERITE_BOOTS);
        SmithingTransformRecipe recipe = new SmithingTransformRecipe(key, item, netherite_upgrade, upgrade_ingredient, boots);
        getServer().addRecipe(recipe);
    }
}