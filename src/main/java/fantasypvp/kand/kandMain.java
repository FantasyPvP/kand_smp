package fantasypvp.kand;

import fantasypvp.kand.commands.*;
import fantasypvp.kand.events.DashItemListener;
import fantasypvp.kand.events.Events;
import fantasypvp.kand.events.PlayerJumpEvent;
import fantasypvp.kand.items.*;

import org.bukkit.plugin.java.JavaPlugin;

public final class kandMain extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        LightningGear.init();
        TrueNetherite.init();
        Witherite.init();
        CustomDrinks.init();
        KandCoin.init();
        // register listeners
        getServer().getPluginManager().registerEvents(new Events(), this);
        getServer().getPluginManager().registerEvents(new DashItemListener(),this);
        getServer().getPluginManager().registerEvents(new CustomDrinks(), this);
        getServer().getPluginManager().registerEvents(new KandCoinCmd(), this);
        PlayerJumpEvent.register(this);

        getCommand("lightning_sword").setExecutor(new CmdLightningSword());
        getCommand("spawn").setExecutor(new CmdTeleportSpawn(this));
        getCommand("setglobalspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("dashstick").setExecutor(new GiveDashItemCmd());
        getCommand("get_currency").setExecutor(new KandCoinCmd());


        getServer().broadcastMessage("§aKand SMP 2 has been enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
