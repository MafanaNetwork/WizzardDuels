package me.TahaCheji;

import me.TahaCheji.game.NormalDuel;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        GameMain.getInstance().addGame(new NormalDuel());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
