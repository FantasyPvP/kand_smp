package fantasypvp.kand_smp.commands;
//Was made by DanThePythonMan
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CmdTeleportSpawn implements CommandExecutor {

    private final JavaPlugin plugin;

    

    public CmdTeleportSpawn(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        boolean success = false;

        if (!(sender instanceof Player)) {
            sender.sendMessage("You must be a player to execute this command!");
            return false;
        }

        Player player = (Player) sender;

        player.sendMessage(ChatColor.GREEN + "Sending you to spawn");

        String coordinates = getCoordinates();

        if (coordinates == null) {
            player.sendMessage(ChatColor.RED + "An error occurred, you will not be teleported.");
        } else {

            int x, y, z;

            String[] coordsList = coordinates.split(" ");

            x = Integer.parseInt(coordsList[0]);
            y = Integer.parseInt(coordsList[1]);
            z = Integer.parseInt(coordsList[2]);

            Location location = new Location(player.getWorld(), x,y,z);

            location.setPitch(player.getLocation().getPitch());
            location.setYaw(player.getLocation().getYaw());

            player.teleport(location);

            success = true;
        }

        return success;
    }

    private String getCoordinates() {
        File dataFolder = plugin.getDataFolder();
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }

        try {
            File file = new File(dataFolder, "spawnCoords.txt");
            if (!file.exists()) {
                return null;
            }

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            bufferedReader.close();

            return line;

        } catch (IOException e) {
            plugin.getLogger().warning("Error occurred while reading spawn coordinates: " + e.getMessage());
            return null;
        }
    }
}
