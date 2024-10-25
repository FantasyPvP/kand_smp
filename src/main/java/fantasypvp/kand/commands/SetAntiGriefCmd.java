package fantasypvp.kand.commands;

import com.booksaw.betterTeams.Team;
import com.booksaw.betterTeams.customEvents.DisbandTeamEvent;
import fantasypvp.kand.database.Database;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import fantasypvp.kand.util.playerCoords;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;

public class SetAntiGriefCmd implements CommandExecutor, Listener {

    private final JavaPlugin plugin;

    public SetAntiGriefCmd(JavaPlugin plugin) { this.plugin = plugin; }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can execute this command!");
            return true;
        }

        Player player = (Player) sender;

        String coordinates = playerCoords.get(player);

        String locationname = args[0];

        try {
            if (SetCoordinates(player, coordinates)) {
                player.sendMessage(ChatColor.GREEN + "Base location" + locationname + "set at coordinates" + coordinates);
                player.sendMessage("These coordinates are visible only to you.");
            } else {
                return false;
            }
        } catch (IOException e) {
            player.sendMessage(ChatColor.RED + "Unable to set Anti Grief");
        }


        return true;
    }


    private boolean SetCoordinates(Player player, String coordinates) throws IOException {

        Team team = Team.getTeam(player);

        if(team == null){
            player.sendMessage(ChatColor.RED + "You must create or join a team to set a base area!");
            return false;
        }

        Connection conn = Database.SQLite.connect();



        File dataFolder = plugin.getDataFolder();
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }
        return true;
    }

    @EventHandler
    public static void DisbandTeamEvent(DisbandTeamEvent event) {

    }
}
