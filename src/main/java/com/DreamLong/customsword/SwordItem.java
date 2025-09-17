package com.DreamLong.customsword;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.Arrays;

public class SwordItem {

    private static final NamespacedKey CUSTOM_SWORD_KEY = new NamespacedKey(CustomSword.getInstance(), "custom_sword");
    private static final NamespacedKey DAMAGE_COUNT_KEY = new NamespacedKey(CustomSword.getInstance(), "damage_count");

    public static ItemStack createBladeOfBlood() {
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName("§4Blade of Blood");
        
        meta.getPersistentDataContainer().set(CUSTOM_SWORD_KEY, PersistentDataType.STRING, "blade_of_blood");

        int initialDamage = 1;
        meta.getPersistentDataContainer().set(DAMAGE_COUNT_KEY, PersistentDataType.INTEGER, initialDamage);
        
        updateLore(meta, initialDamage);

        item.setItemMeta(meta);

        return item;
    }

    public static boolean isCustomSword(ItemStack item) {
        if (item == null || item.getItemMeta() == null) {
            return false;
        }
        ItemMeta meta = item.getItemMeta();
        return meta.getPersistentDataContainer().has(CUSTOM_SWORD_KEY, PersistentDataType.STRING);
    }

    public static int getDamageCount(ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            return meta.getPersistentDataContainer().getOrDefault(DAMAGE_COUNT_KEY, PersistentDataType.INTEGER, 0);
        }
        return 0;
    }

    public static void incrementDamage(ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            int currentDamage = getDamageCount(item);
            int newDamage = currentDamage + 1;
            meta.getPersistentDataContainer().set(DAMAGE_COUNT_KEY, PersistentDataType.INTEGER, newDamage);
            updateLore(meta, newDamage);
            item.setItemMeta(meta);
        }
    }
    
    private static void updateLore(ItemMeta meta, int damage) {
        meta.setLore(Arrays.asList("§7Damage Count: §c" + damage, "§7" + (damage * 0.5) + " hearts of additional damage."));
    }
}
