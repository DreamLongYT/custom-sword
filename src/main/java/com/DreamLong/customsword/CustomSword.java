package com.DreamLong.customsword;

import org.bukkit.plugin.java.JavaPlugin;

public class CustomSword extends JavaPlugin {

    private static CustomSword instance;

    @Override
    public void onEnable() {
        instance = this;
        // Registriere den Listener für Kills, der den Schaden-Zähler erhöht
        getServer().getPluginManager().registerEvents(new SwordListener(), this);
        // Registriere den Listener für jeden Treffer, der den Schaden anpasst
        getServer().getPluginManager().registerEvents(new DamageListener(), this);
        
        getCommand("customsword").setExecutor(new SwordCommand());
        getLogger().info("CustomSword has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("CustomSword has been disabled!");
    }

    public static CustomSword getInstance() {
        return instance;
    }
}
