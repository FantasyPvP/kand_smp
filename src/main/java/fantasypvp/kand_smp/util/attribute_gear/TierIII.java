package fantasypvp.kand_smp.util.attribute_gear;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.UUID;

public abstract class TierIII extends TierBase {
    public static ItemStack sword () {
        ItemStack item = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta meta = item.getItemMeta();

        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(
                UUID.randomUUID(),
                "generic.attackDamage",
                6.0,
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlot.HAND
        ));
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier(
                UUID.randomUUID(),
                "generic.attackSpeed",
                -2.4,
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlot.HAND
        ));
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack helmet () {
        ItemStack item = new ItemStack(Material.IRON_HELMET, 1);
        ItemMeta meta = item.getItemMeta();
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(
                UUID.randomUUID(),
                "generic.armor",
                2.0,
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlot.HEAD
        ));
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack chestplate () {
        ItemStack item = new ItemStack(Material.IRON_CHESTPLATE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(
                UUID.randomUUID(),
                "generic.armor",
                6.0,
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlot.CHEST
        ));
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack leggings () {
        ItemStack item = new ItemStack(Material.IRON_LEGGINGS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(
                UUID.randomUUID(),
                "generic.armor",
                5.0,
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlot.LEGS
        ));
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack boots () {
        ItemStack item = new ItemStack(Material.IRON_BOOTS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(
                UUID.randomUUID(),
                "generic.armor",
                2.0,
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlot.FEET
        ));
        item.setItemMeta(meta);
        return item;
    }
}
