package fantasypvp.kand.events;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;

import static org.bukkit.Bukkit.*;

public class DragonGlide implements Listener {
    @EventHandler
    public static void onPlayerJump(PlayerJumpEvent event) {
        getServer().broadcastMessage("§a" + event.getPlayer().getName() + " jumped!");
    }
}