package fantasypvp.kand.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class CustomFoods {
    public static ItemStack steak_burger;

    public static void init() {
        steakBurger();
    }

    private static void steakBurger() {
        ItemStack item = new ItemStack(Material.COOKED_BEEF, 1);
        steak_burger = item;
    }
}

