package fantasypvp.kand.items;

import fantasypvp.kand.util.gear_templates.TierV;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

import java.util.ArrayList;
import java.util.List;

import static org.bukkit.Bukkit.getServer;

public class Witherite implements Listener {
    private static RecipeChoice netherite_upgrade = new RecipeChoice.MaterialChoice(Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE);
    private static RecipeChoice wither_skull = new RecipeChoice.MaterialChoice(Material.WITHER_SKELETON_SKULL);


    @EventHandler
    public void onEntityDamageByEntity(org.bukkit.event.entity.EntityDamageByEntityEvent event) {

        // checks that it is a player that is performing the attack.
        if (!(event.getDamager() instanceof org.bukkit.entity.Player player)) {
            return;
        }

        try {
            if (!player.getInventory().getItemInMainHand().getItemMeta().getLore().toString().contains("Blade Of The Wither")) {
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        PotionEffect effect = new PotionEffect(
                org.bukkit.potion.PotionEffectType.WITHER,
                20 * 5,
                1
        );
        effect.apply((LivingEntity) event.getEntity());

    }

    @EventHandler
    public void onEntityPotionEffectEvent(org.bukkit.event.entity.EntityPotionEffectEvent event) {
        if (event.getEntity() instanceof Player player) {
            try {
                if (player.getInventory().getHelmet().getItemMeta().getLore().toString().contains("Helm Of The Wither")
                        && player.getInventory().getChestplate().getItemMeta().getLore().toString().contains("Chestplate Of The Wither")
                        && player.getInventory().getLeggings().getItemMeta().getLore().toString().contains("Leggings Of The Wither")
                        && player.getInventory().getBoots().getItemMeta().getLore().toString().contains("Boots Of The Wither")) {
                    event.setCancelled(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static ItemStack sword;
    private static ItemStack helmet;
    private static ItemStack chestplate;
    private static ItemStack leggings;
    private static ItemStack boots;

    public static void init() {
        ItemStack item = TierV.sword();

        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "Blade Of The Wither");
        meta.setLore(lore);
        meta.setDisplayName(ChatColor.WHITE + "Witherite Sword");
        item.setItemMeta(meta);

        NamespacedKey key = new NamespacedKey("fantasypvp.kand_smp.items", "witherite_sword");
        RecipeChoice netherite_sword = new RecipeChoice.MaterialChoice(Material.NETHERITE_SWORD);
        SmithingTransformRecipe recipe = new SmithingTransformRecipe(key, item, netherite_upgrade, wither_skull, netherite_sword);
        getServer().addRecipe(recipe);
        sword = item;

        // Initialize Witherite Helmet
        ItemStack helmetItem = TierV.helmet();
        ItemMeta helmetMeta = helmetItem.getItemMeta();
        List<String> helmetLore = new ArrayList<>();
        helmetLore.add(ChatColor.GRAY + "Helm Of The Wither");
        helmetMeta.setLore(helmetLore);
        helmetMeta.setDisplayName(ChatColor.WHITE + "Witherite Helmet");
        helmetItem.setItemMeta(helmetMeta);

        NamespacedKey helmetKey = new NamespacedKey("fantasypvp.kand_smp.items", "witherite_helmet");
        RecipeChoice netheriteHelmet = new RecipeChoice.MaterialChoice(Material.NETHERITE_HELMET);
        SmithingTransformRecipe helmetRecipe = new SmithingTransformRecipe(helmetKey, helmetItem, netherite_upgrade, wither_skull, netheriteHelmet);
        getServer().addRecipe(helmetRecipe);
        helmet = helmetItem;

        // Initialize Witherite Chestplate
        ItemStack chestplateItem = TierV.chestplate();
        ItemMeta chestplateMeta = chestplateItem.getItemMeta();
        List<String> chestplateLore = new ArrayList<>();
        chestplateLore.add(ChatColor.GRAY + "Chestplate Of The Wither");
        chestplateMeta.setLore(chestplateLore);
        chestplateMeta.setDisplayName(ChatColor.WHITE + "Witherite Chestplate");
        chestplateItem.setItemMeta(chestplateMeta);

        NamespacedKey chestplateKey = new NamespacedKey("fantasypvp.kand_smp.items", "witherite_chestplate");
        RecipeChoice netheriteChestplate = new RecipeChoice.MaterialChoice(Material.NETHERITE_CHESTPLATE);
        SmithingTransformRecipe chestplateRecipe = new SmithingTransformRecipe(chestplateKey, chestplateItem, netherite_upgrade, wither_skull, netheriteChestplate);
        getServer().addRecipe(chestplateRecipe);
        chestplate = chestplateItem;

        // Initialize Witherite Leggings
        ItemStack leggingsItem = TierV.leggings();
        ItemMeta leggingsMeta = leggingsItem.getItemMeta();
        List<String> leggingsLore = new ArrayList<>();
        leggingsLore.add(ChatColor.GRAY + "Leggings Of The Wither");
        leggingsMeta.setLore(leggingsLore);
        leggingsMeta.setDisplayName(ChatColor.WHITE + "Witherite Leggings");
        leggingsItem.setItemMeta(leggingsMeta);

        NamespacedKey leggingsKey = new NamespacedKey("fantasypvp.kand_smp.items", "witherite_leggings");
        RecipeChoice netheriteLeggings = new RecipeChoice.MaterialChoice(Material.NETHERITE_LEGGINGS);
        SmithingTransformRecipe leggingsRecipe = new SmithingTransformRecipe(leggingsKey, leggingsItem, netherite_upgrade, wither_skull, netheriteLeggings);
        getServer().addRecipe(leggingsRecipe);
        leggings = leggingsItem;

        // Initialize Witherite Boots
        ItemStack bootsItem = TierV.boots();
        ItemMeta bootsMeta = bootsItem.getItemMeta();
        List<String> bootsLore = new ArrayList<>();
        bootsLore.add(ChatColor.GRAY + "Boots Of The Wither");
        bootsMeta.setLore(bootsLore);
        bootsMeta.setDisplayName(ChatColor.WHITE + "Witherite Boots");
        bootsItem.setItemMeta(bootsMeta);

        NamespacedKey bootsKey = new NamespacedKey("fantasypvp.kand_smp.items", "witherite_boots");
        RecipeChoice netheriteBoots = new RecipeChoice.MaterialChoice(Material.NETHERITE_BOOTS);
        SmithingTransformRecipe bootsRecipe = new SmithingTransformRecipe(bootsKey, bootsItem, netherite_upgrade, wither_skull, netheriteBoots);
        getServer().addRecipe(bootsRecipe);
        boots = bootsItem;
    }

    public static ItemStack sword() {
        return sword;
    }

    public static ItemStack helmet() {
        return helmet;
    }

    public static ItemStack chestplate() {
        return chestplate;
    }

    public static ItemStack leggings() {
        return leggings;
    }

    public static ItemStack boots() {
        return boots;
    }
}