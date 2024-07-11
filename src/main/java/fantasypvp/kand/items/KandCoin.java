package fantasypvp.kand.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class KandCoin extends ItemStack {
    public static ItemStack kandCoin;

    public static void init() {
        kandCoin = KandCoin();
    }

    public static ItemStack KandCoin() {
        ItemStack item = new ItemStack(Material.POPPED_CHORUS_FRUIT, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "Kand Coin");

        List<String> lore = new ArrayList<>();
        String lore_line = ChatColor.GRAY + "The Official KandSMP Currency.";
        lore.add(lore_line);
        meta.setLore(lore);

        item.setItemMeta(meta);
        return item;
    }

}
