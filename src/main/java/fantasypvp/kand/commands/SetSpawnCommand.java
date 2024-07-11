package fantasypvp.kand.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SetSpawnCommand implements CommandExecutor {

    private final JavaPlugin plugin;

    public SetSpawnCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("You must be a player to execute this command!");
            return false;
        }

        Player player = (Player) sender;
        if(!player.hasPermission("kand.setglobalspawn")){

            player.sendMessage(ChatColor.RED+"You don't have permission to run this.");

        }else{

            String coordinates = getCoordinates(player);

            try {
                if (SetCoordinates(coordinates)) {
                    player.sendMessage(ChatColor.GREEN + "Spawn Coordinates set!");
                }
            } catch (IOException e) {
                player.sendMessage(ChatColor.RED + "Unable to set spawn coordinates");
            }

            return true;
        }
        return false;
    }

    private String getCoordinates(Player player) {
//        return (player.getLocation().getX() + " " + player.getLocation().getY() + " " + player.getLocation().getZ());

        String x,y,z;

        x=String.format("%.0f",player.getLocation().getX());
        y=String.format("%.0f",player.getLocation().getY());
        z=String.format("%.0f",player.getLocation().getZ());

        return (x +" " + y + " "+ z);


    }

    private boolean SetCoordinates(String coordinates) throws IOException {
        File dataFolder = plugin.getDataFolder();
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }

        File file = new File(dataFolder, "spawnCoords.txt");
        try (FileWriter fileWriter = new FileWriter(file, false)) {
            fileWriter.write(coordinates);
            return true;
        } catch (IOException e) {
            plugin.getLogger().warning("Spawn TP Plugin couldn't save coordinates. Error: " + e);
            return false;
        }
    }

}
