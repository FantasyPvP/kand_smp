package fantasypvp.kand.items;

import fantasypvp.kand.kandMain;
import fantasypvp.kand.util.gear_templates.TierIV;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.CommandExecutor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.loot.LootContext;
import org.bukkit.loot.LootTable;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class DragonSet implements CommandExecutor, Listener, LootTable {
    private ArrayList<Player> cooldown = new ArrayList<>();

    private Plugin plugin = kandMain.getPlugin(kandMain.class);
    private NamespacedKey key = new NamespacedKey(plugin, "dragon_loot");
    private Collection<ItemStack> items = new ArrayList<ItemStack>();


    @NotNull
    @Override
    public Collection<ItemStack> populateLoot(Random random, LootContext context) {
        int scaleCount = 32;
        ItemStack dragonScales = dragonScale();
        dragonScales.setAmount(scaleCount);
        items.add(dragonScales);

        return items;
    }

    @Override
    public void fillInventory(@NotNull Inventory inventory, @NotNull Random random, @NotNull LootContext lootContext) {
        // nothing.
    }

    @NotNull
    @Override
    public NamespacedKey getKey() {
        return key;
    }


    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem(); // Get the item the player interacted with

        if (!(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
            return;
        }

        if (item == null || item.getType() != Material.DIAMOND_SWORD || event.getHand() != EquipmentSlot.HAND) {
            return;
        }

        try {
            ItemMeta meta = item.getItemMeta();
            if (!meta.getLore().toString().contains("A Blade Crafted from the essence of dragons")) {
                return;
            }
        } catch (Exception e) {
            return;
        }

        if (cooldown.contains(player)) {
            return;
        }

        Location location = player.getLocation();
        Vector direction = location.getDirection();
        player.setVelocity(direction.multiply(2.0));
        player.playSound(location, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);
        World world = player.getWorld();
        world.spawnParticle(Particle.PORTAL, location, 1);

        cooldown.add(player);
        Bukkit.getScheduler().scheduleSyncDelayedTask(
                Objects.requireNonNull(Bukkit.getPluginManager().getPlugin("kand")),
                () -> cooldown.remove(player),
                50
        );

    }

    @EventHandler
    public void onEntityDeath(org.bukkit.event.entity.EntityDeathEvent event) {

        if (event.getEntity() instanceof EnderDragon dragon) {} else {
            return;
        }

        event.getDrops().clear();
        Location location = dragon.getLocation();
        Player player = dragon.getKiller();

        int looting_mod;
        try {
            looting_mod = player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS);
        } catch (NullPointerException e) {
            looting_mod = 0;
        }
        double luck_mod = player.getAttribute(Attribute.GENERIC_LUCK).getValue();

        LootContext.Builder builder = new LootContext.Builder(event.getEntity().getLocation());
        builder.lootedEntity(dragon);
        builder.lootingModifier(looting_mod);
        builder.luck((float)luck_mod);
        builder.killer(player);
        LootContext lootContext = builder.build();


        Collection<ItemStack> drops = new DragonSet().populateLoot(new Random(), lootContext);
        ArrayList<ItemStack> items = (ArrayList<ItemStack>) drops;

        location.getWorld().dropItemNaturally(location, items.get(0));

    }

    @Override
    public boolean onCommand(org.bukkit.command.CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command");
            return true;
        }

        Player player = (Player) sender;

        if(player.hasPermission("kand.lightning_sword")) {
            if (command.getName().equalsIgnoreCase("dragon_gear")) {
                player.getInventory().addItem(DragonSet.helmet());
                player.getInventory().addItem(DragonSet.chestplate());
                player.getInventory().addItem(DragonSet.leggings());
                player.getInventory().addItem(DragonSet.boots());
                player.getInventory().addItem(DragonSet.sword());
            }

        } else {
            player.sendMessage(ChatColor.RED+"You don't have permission to run this command.");
        }

        return true;
    }

    public static ItemStack dragonScale() {
        ItemStack item = new ItemStack(Material.POPPED_CHORUS_FRUIT, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_PURPLE + "Dragon Scale");

        List<String> lore = new ArrayList<>();
        String lore_line = ChatColor.GRAY + "Used to craft powerful items...";
        lore.add(lore_line);
        meta.setLore(lore);

        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack sword() {
        ItemStack item = TierIV.sword();

        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "A Blade Crafted from the essence of dragons");
        meta.setLore(lore);
        meta.setDisplayName(ChatColor.WHITE + "Dragon Sword");
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack helmet() {
        ItemStack item = new ItemStack(Material.DRAGON_HEAD);
        ItemMeta meta = item.getItemMeta();

        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(
                UUID.randomUUID(),
                "generic.armor",
                3.0,
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlot.HEAD
        ));
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(
                UUID.randomUUID(),
                "generic.armorToughness",
                2.0,
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlot.HEAD
        ));

        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "A Helm Crafted from the essence of dragons");
        meta.setLore(lore);
        meta.setDisplayName(ChatColor.WHITE + "Dragon Helmet");
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack chestplate() {
        ItemStack item = new ItemStack(Material.ELYTRA);

        ItemMeta meta = item.getItemMeta();
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(
                UUID.randomUUID(),
                "generic.armor",
                8.0,
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlot.CHEST
        ));
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(
                UUID.randomUUID(),
                "generic.armorToughness",
                2.0,
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlot.CHEST
        ));
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "A Chestplate Crafted from the essence of dragons");
        meta.setLore(lore);
        meta.setDisplayName(ChatColor.WHITE + "Dragon Chestplate");
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack leggings() {
        ItemStack item = TierIV.leggings();

        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "Leggings Crafted from the essence of dragons");
        meta.setLore(lore);
        meta.setDisplayName(ChatColor.WHITE + "Dragon Leggings");
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack boots() {
        ItemStack item = TierIV.boots();

        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "Boots Crafted from the essence of dragons");
        meta.setLore(lore);
        meta.setDisplayName(ChatColor.WHITE + "Dragon Boots");
        item.setItemMeta(meta);
        return item;
    }
}