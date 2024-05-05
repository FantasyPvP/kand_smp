package fantasypvp.kand_smp.util.attribute_gear;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public abstract class TierBase {
    public static ItemStack sword() {
        return new ItemStack(Material.WOODEN_SWORD);
    }

    public static ItemStack helmet() {
        return new ItemStack(Material.LEATHER_HELMET);
    }

    public static ItemStack chestplate() {
        return new ItemStack(Material.LEATHER_CHESTPLATE);
    }

    public static ItemStack leggings() {
        return new ItemStack(Material.LEATHER_LEGGINGS);
    }

    public static ItemStack boots() {
        return new ItemStack(Material.LEATHER_BOOTS);
    }
}
