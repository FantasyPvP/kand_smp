package fantasypvp.kand_smp.items;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.Arrays;

public class BlazingHalo extends ItemStack {

    public static ItemStack createBlazingHalo(){
        ItemStack item = new ItemStack(Material.LEATHER_HELMET);
        ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
        LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
        assert leatherArmorMeta != null;
        leatherArmorMeta.setColor(Color.ORANGE);
        leatherArmorMeta.setDisplayName(ChatColor.GOLD + "Blazing Halo");
        leatherArmorMeta.setLore(Arrays.asList(ChatColor.RED + "A mystical helmet", ChatColor.RED + "imbued with blazing power."));

        item.setItemMeta(leatherArmorMeta);

        return item;
    }

}
