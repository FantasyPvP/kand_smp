package fantasypvp.kand.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class DashItem extends ItemStack {

    public ItemStack createDashItem(){

        ItemStack item = new ItemStack(Material.STICK,1);

        ItemMeta meta = item.getItemMeta();

        List<String>stickLore = new ArrayList<>();
        stickLore.add("Click this stick and you'll be there in a jiffy.");
        stickLore.add("About this, don't get sniffy.");


        meta.setLore(stickLore);

        meta.setDisplayName(ChatColor.AQUA+"[Dash"+ChatColor.BLUE+" Stick]");

        item.setItemMeta(meta);

        return item;



    }

}
