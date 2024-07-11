package fantasypvp.kand.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.bukkit.Bukkit.broadcastMessage;
import static org.bukkit.Bukkit.getServer;

public class CustomDrinks implements Listener {
    public static ItemStack apple_juice;
    public static ItemStack cider;


    public static void init() {
        appleJuice();
        cider();
    }

    private static void appleJuice() {
        ItemStack item = new ItemStack(Material.POTION, 1);

        PotionMeta pm = (PotionMeta) item.getItemMeta();
        pm.setBasePotionData(new org.bukkit.potion.PotionData(org.bukkit.potion.PotionType.WATER));


        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.YELLOW + "Just plain ordinary  Apple Juice");

        pm.setDisplayName("Apple Juice");

        // set food value

        pm.addCustomEffect(
                new org.bukkit.potion.PotionEffect(
                        PotionEffectType.SATURATION,
                        1,
                        4
                ),
                true
        );

        item.setItemMeta(pm);
        apple_juice = item;

        NamespacedKey key = new NamespacedKey("fantasypvp.kand_smp.items", "apple_juice");
        ShapelessRecipe recipe = new ShapelessRecipe(key, apple_juice);
        recipe.addIngredient(Material.APPLE);
        recipe.addIngredient(1, Material.POTION, (byte)0);
        getServer().addRecipe(recipe);
    }

    @EventHandler
    public void ciderCrafting(org.bukkit.event.inventory.PrepareItemCraftEvent event) {

        int i = 0;
        for (ItemStack item : event.getInventory().getMatrix()) {
            if (item != null) {
                i += item.getAmount();
            }
        }

        if (event.getInventory().contains(apple_juice, 1)
                && event.getInventory().contains(Material.SUGAR, 2)
                && i == 3
        ) {
            event.getInventory().setResult(cider);
        }
    }

    private static void cider() {
        ItemStack item = new ItemStack(Material.POTION, 1);

        PotionMeta pm = (PotionMeta) item.getItemMeta();
        pm.setBasePotionData(new org.bukkit.potion.PotionData(org.bukkit.potion.PotionType.WATER));


        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.YELLOW + "A bottle of cider.");

        pm.setDisplayName("Cider");

        // set food value

        pm.addCustomEffect(
                new org.bukkit.potion.PotionEffect(
                        PotionEffectType.SATURATION,
                        1,
                        5
                ),
                true
        );
        pm.addCustomEffect(
                new org.bukkit.potion.PotionEffect(
                        PotionEffectType.SPEED,
                        5,
                        1
                ),
                true
        );

        item.setItemMeta(pm);
        cider = item;
    }
}
