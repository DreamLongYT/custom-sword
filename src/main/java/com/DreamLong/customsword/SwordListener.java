package com.DreamLong.customsword;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

public class SwordListener implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        if (event.getEntity().getKiller() instanceof Player) {
            Player killer = event.getEntity().getKiller();
            ItemStack hand = killer.getInventory().getItemInMainHand();

            if (SwordItem.isCustomSword(hand)) {
                SwordItem.incrementDamage(hand);
                
                killer.sendMessage("§cYour Blade of Blood has grown stronger! Damage Count: §4" + SwordItem.getDamageCount(hand));
            }
        }
    }
}
