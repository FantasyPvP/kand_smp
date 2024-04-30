package fantasypvp.kand_smp.events;

import org.bukkit.event.Listener;

import static org.bukkit.Bukkit.getServer;

public class Events implements Listener {
    public static void onPlayerJoin(org.bukkit.event.player.PlayerJoinEvent event) {
        getServer().broadcastMessage("§a" + event.getPlayer().getName() + " has joined the server!");
    }
}
