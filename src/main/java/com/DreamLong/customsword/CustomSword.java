package com.DreamLong.customsword;

import org.bukkit.plugin.java.JavaPlugin;

public class CustomSword extends JavaPlugin {

    private static CustomSword instance;

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new SwordListener(), this);
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
