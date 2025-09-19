package com.DreamLong.customsword;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class DamageListener implements Listener {

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        // Überprüfen, ob der Angreifer ein Spieler ist
        if (!(event.getDamager() instanceof Player)) {
            return;
        }

        Player player = (Player) event.getDamager();
        ItemStack mainHandItem = player.getInventory().getItemInMainHand();

        // Überprüfen, ob es sich um das "Bloody Sword" handelt
        if (SwordItem.isBloodySword(mainHandItem)) {
            // Holen des aktuellen Schadenswertes aus dem Schwert
            int damageCount = SwordItem.getDamageCount(mainHandItem);
            double additionalDamage = damageCount * 0.5;

            // Den Schaden des Events erhöhen
            double originalDamage = event.getDamage();
            event.setDamage(originalDamage + additionalDamage);
        }
    }
}
