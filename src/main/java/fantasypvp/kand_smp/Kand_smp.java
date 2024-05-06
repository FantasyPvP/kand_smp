package fantasypvp.kand_smp;

import fantasypvp.kand_smp.commands.CmdLightningSword;
import fantasypvp.kand_smp.commands.CmdTeleportSpawn;
import fantasypvp.kand_smp.events.Events;
import fantasypvp.kand_smp.items.LightningGear;
import fantasypvp.kand_smp.items.TrueNetherite;
import fantasypvp.kand_smp.items.Witherite;
import me.danthepythonman.spawntp.commands.SetSpawnCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Kand_smp extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        LightningGear.init();
        TrueNetherite.init();
        Witherite.init();
        // register listeners
        getServer().getPluginManager().registerEvents(new Events(), this);

        getCommand("lightning_sword").setExecutor(new CmdLightningSword());
        getCommand("spawn").setExecutor(new CmdTeleportSpawn(this));
        getCommand("setSpawnTp").setExecutor(new SetSpawnCommand(this));

        getServer().broadcastMessage("§aKand SMP has been enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
