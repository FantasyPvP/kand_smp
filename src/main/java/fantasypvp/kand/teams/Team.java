package fantasypvp.kand.teams;
import org.bukkit.plugin.java.JavaPlugin;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Team {
    public String name;
    public HashMap<UUID, String> members;
    public String tag;


    public static void newTeam(JavaPlugin plugin, String name, UUID founder) throws Exception {

        JSONParser parser = new JSONParser();
        JSONArray teams;

        File f = plugin.getDataFolder().toPath().resolve("teams.json").toFile();
        if (f.exists()) {
            Object obj;
            try {
                obj = parser.parse(new FileReader(f));
                teams = (JSONArray) obj;
            } catch (ParseException e) {
                throw new Exception("Unable to parse teams.json", e);
            }
        } else {
            teams = new JSONArray();
        }

        JSONObject members = new JSONObject();
        members.put(founder.toString(), "founder");

        JSONObject team = new JSONObject();

        team.put("name", name);
        team.put("members", members);

        // write the team to the json file
        teams.add(team);
        try (FileWriter file = new FileWriter(f)) {
            file.write(teams.toJSONString());
        }
    }

    public Team(JavaPlugin plugin, String name) throws Exception {
        JSONParser parser = new JSONParser();
        JSONObject team;

        File f = plugin.getDataFolder().toPath().resolve("teams.json").toFile();
        if (f.exists()) {
            Object obj;
            try {
                obj = parser.parse(new FileReader(f));
                JSONArray teams = (JSONArray) obj;

                for (int i = 0; i < teams.size(); i++) {
                    if (((JSONObject) teams.get(i)).get("name") == name) {
                        team = (JSONObject) teams.get(i);
                    }
                }

            } catch (ParseException e) {
                throw new Exception("Unable to parse teams.json", e);
            }
        } else {
            throw new Exception("specified team does not exist");
        }
    }

    private void saveState(JavaPlugin plugin) {

    }

    public void setName(String name) {
        this.name = name;

    }
}






























