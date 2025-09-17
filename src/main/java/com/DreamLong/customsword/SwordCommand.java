package com.DreamLong.customsword;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SwordCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        Player player = (Player) sender;
        
        if (player.hasPermission("customsword.give")) {
            player.getInventory().addItem(SwordItem.createBladeOfBlood());
            player.sendMessage("§aYou have received the Blade of Blood!");
            return true;
        } else {
            player.sendMessage("§cYou do not have permission to use this command.");
            return true;
        }
    }
}
