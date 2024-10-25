package fantasypvp.kand.util.gear_templates;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.UUID;

// DIAMOND ARMOUR EQUIVALENT

public abstract class TierIV extends TierBase {
    public static ItemStack sword () {
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta meta = item.getItemMeta();

        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier(
                UUID.randomUUID(),
                "generic.attackDamage",
                7.0,
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
        ItemStack item = new ItemStack(Material.DIAMOND_HELMET, 1);
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
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack chestplate () {
        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
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
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack leggings () {
        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(
                UUID.randomUUID(),
                "generic.armor",
                6.0,
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlot.LEGS
        ));
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(
                UUID.randomUUID(),
                "generic.armorToughness",
                2.0,
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlot.LEGS
        ));
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack boots () {
        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS, 1);
        ItemMeta meta = item.getItemMeta();
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(
                UUID.randomUUID(),
                "generic.armor",
                3.0,
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlot.FEET
        ));
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(
                UUID.randomUUID(),
                "generic.armorToughness",
                2.0,
                AttributeModifier.Operation.ADD_NUMBER,
                EquipmentSlot.FEET
        ));
        item.setItemMeta(meta);
        return item;
    }
}