package fantasypvp.kand;

import fantasypvp.kand.commands.*;
import fantasypvp.kand.events.*;
import fantasypvp.kand.items.*;

import org.bukkit.loot.LootTable;
import org.bukkit.loot.LootTables;
import org.bukkit.plugin.java.JavaPlugin;

public final class kandMain extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        TrueNetherite.init();
        CustomDrinks.init();
        KandCoin.init();

        getCommand("spawn").setExecutor(new CmdTeleportSpawn(this));
        getCommand("setglobalspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("get_currency").setExecutor(new KandCoinCmd());

        // register listeners
        getServer().getPluginManager().registerEvents(new CustomDrinks(), this);
        getServer().getPluginManager().registerEvents(new KandCoinCmd(), this);
        getServer().getPluginManager().registerEvents(new FireDamageListener(), this);
        BlessedSet steven_gear = new BlessedSet();
        getServer().getPluginManager().registerEvents(steven_gear, this);
        getCommand("steven_gear").setExecutor(steven_gear);

        DragonSet dragon_gear = new DragonSet();
        getServer().getPluginManager().registerEvents(dragon_gear, this);
        getCommand("dragon_gear").setExecutor(dragon_gear);

        DashItem dash_stick = new DashItem();
        getServer().getPluginManager().registerEvents(dash_stick, this);
        getCommand("dashstick").setExecutor(dash_stick);

        LightningGear lightning_sword = new LightningGear();
        getServer().getPluginManager().registerEvents(lightning_sword, this);
        getCommand("lightning_sword").setExecutor(lightning_sword);

        Witherite witherite_gear = new Witherite();
        Witherite.init();
        getServer().getPluginManager().registerEvents(witherite_gear, this);

        getServer().broadcastMessage("§aKand SMP Plugin has been enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
