package fantasypvp.kand_smp;

import fantasypvp.kand_smp.commands.*;
import fantasypvp.kand_smp.events.DashItemListener;
import fantasypvp.kand_smp.events.Events;
import fantasypvp.kand_smp.events.FireDamageListener;
import fantasypvp.kand_smp.items.*;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public final class Kand_smp extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        LightningGear.init();
        TrueNetherite.init();
        Witherite.init();
        registerBlazingHaloRecipe();
        // register listeners
        getServer().getPluginManager().registerEvents(new Events(), this);
        getServer().getPluginManager().registerEvents(new DashItemListener(),this);
        getServer().getPluginManager().registerEvents(new FireDamageListener(), this);
        //register commands
        getCommand("lightning_sword").setExecutor(new CmdLightningSword());
        getCommand("spawn").setExecutor(new CmdTeleportSpawn(this));
        getCommand("setSpawnTp").setExecutor(new SetSpawnCommand(this));
        getCommand("dashstick").setExecutor(new GiveDashItemCommand());
        getServer().broadcastMessage("§aKand SMP has been enabled!");
    }

    private void registerBlazingHaloRecipe() {
        ItemStack blazingHalo = BlazingHalo.createBlazingHalo();

        NamespacedKey key = new NamespacedKey(this, "blazing_halo");
        ShapedRecipe recipe = new ShapedRecipe(key, blazingHalo);

        recipe.shape(
                "BBB",
                "BNB",
                "BBB"
        );
        recipe.setIngredient('B', Material.BLAZE_ROD);
        recipe.setIngredient('N',Material.NETHER_STAR);

        Bukkit.addRecipe(recipe);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
