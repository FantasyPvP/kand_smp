package fantasypvp.kand.items;

import fantasypvp.kand.util.attribute_gear.TierV;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareSmithingEvent;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

import static org.bukkit.Bukkit.getServer;

public class Witherite {
    public static ItemStack sword;
    public static ItemStack helmet;
    public static ItemStack chestplate;
    public static ItemStack leggings;
    public static ItemStack boots;

    private static RecipeChoice netherite_upgrade;
    private static RecipeChoice wither_skull;

    public static void init() {
        netherite_upgrade = new RecipeChoice.MaterialChoice(Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE);
        wither_skull = new RecipeChoice.MaterialChoice(Material.WITHER_SKELETON_SKULL);

        sword();
        helmet();
        chestplate();
        leggings();
        boots();
    }

    private static void sword() {
        ItemStack item = TierV.sword();

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§bWitherite Sword");

        List<String> lore = new ArrayList<>();
        lore.add("§f[T5+] Witherite Sword");
        meta.setLore(lore);
        item.setItemMeta(meta);
        sword = item;

        NamespacedKey key = new NamespacedKey("fantasypvp.kand_smp.items", "witherite_sword");
        RecipeChoice netherite_sword = new RecipeChoice.MaterialChoice(Material.NETHERITE_SWORD);
        SmithingTransformRecipe recipe = new SmithingTransformRecipe(key, item, netherite_upgrade, wither_skull, netherite_sword);
        getServer().addRecipe(recipe);
    }

    private static void helmet() {
        ItemStack item = TierV.helmet();

        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        lore.add("§f[T5+] Witherite Helmet");
        meta.setLore(lore);
        meta.setDisplayName("§bWitherite Helmet");
        item.setItemMeta(meta);
        helmet = item;

        NamespacedKey key = new NamespacedKey("fantasypvp.kand_smp.items", "witherite_helmet");
        RecipeChoice netherite_helmet = new RecipeChoice.MaterialChoice(Material.NETHERITE_HELMET);
        SmithingTransformRecipe recipe = new SmithingTransformRecipe(key, item, netherite_upgrade, wither_skull, netherite_helmet);
        getServer().addRecipe(recipe);
    }

    private static void chestplate() {
        ItemStack item = TierV.chestplate();

        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        lore.add("§f[T5+] Witherite Chestplate");
        meta.setLore(lore);
        meta.setDisplayName("§bWitherite Chestplate");
        item.setItemMeta(meta);
        helmet = item;

        NamespacedKey key = new NamespacedKey("fantasypvp.kand_smp.items", "witherite_chestplate");
        RecipeChoice netherite_chestplate = new RecipeChoice.MaterialChoice(Material.NETHERITE_CHESTPLATE);
        SmithingTransformRecipe recipe = new SmithingTransformRecipe(key, item, netherite_upgrade, wither_skull, netherite_chestplate);
        getServer().addRecipe(recipe);
    }

    private static void leggings() {
        ItemStack item = TierV.leggings();

        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        lore.add("§f[T5+] Witherite Leggings");
        meta.setLore(lore);
        meta.setDisplayName("§bWitherite Leggings");
        item.setItemMeta(meta);
        helmet = item;

        NamespacedKey key = new NamespacedKey("fantasypvp.kand_smp.items", "witherite_leggings");
        RecipeChoice netherite_leggings = new RecipeChoice.MaterialChoice(Material.NETHERITE_LEGGINGS);
        SmithingTransformRecipe recipe = new SmithingTransformRecipe(key, item, netherite_upgrade, wither_skull, netherite_leggings);
        getServer().addRecipe(recipe);
    }

    private static void boots() {
        ItemStack item = TierV.boots();

        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        lore.add("§f[T5+] Witherite Boots");
        meta.setLore(lore);
        meta.setDisplayName("§bWitherite Boots");
        item.setItemMeta(meta);
        helmet = item;

        NamespacedKey key = new NamespacedKey("fantasypvp.kand_smp.items", "witherite_boots");
        RecipeChoice netherite_boots = new RecipeChoice.MaterialChoice(Material.NETHERITE_BOOTS);
        SmithingTransformRecipe recipe = new SmithingTransformRecipe(key, item, netherite_upgrade, wither_skull, netherite_boots);
        getServer().addRecipe(recipe);
    }
}