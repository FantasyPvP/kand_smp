package fantasypvp.kand_smp.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class FireDamageListener implements Listener {

    @EventHandler
    public void onPlayerTakeFireDamage(EntityDamageEvent event){
       if(event.getEntity() instanceof Player player){
           ItemStack helmet = player.getInventory().getHelmet();
           if (helmet == null){
               return;
           }
           ItemMeta meta = helmet.getItemMeta();
           if(meta == null || !meta.hasDisplayName()){
               return;
           }
           if (meta.getDisplayName().equals(ChatColor.GOLD+"Blazing Halo")){
               event.setCancelled(true);
           }
       }
    }

}
