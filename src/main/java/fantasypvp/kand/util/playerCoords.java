package fantasypvp.kand.util;
import org.bukkit.entity.Player;

public class playerCoords {

    public static String get(Player player) {

        String x,y,z;

        x=String.format("%.0f",player.getLocation().getX());
        y=String.format("%.0f",player.getLocation().getY());
        z=String.format("%.0f",player.getLocation().getZ());

        return (x +" " + y + " "+ z);
    }
}
