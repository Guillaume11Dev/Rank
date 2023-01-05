package fr.guillaume.rank;

import fr.guillaume.rank.Listener.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class RankJavaPlugin extends JavaPlugin {

    private static RankJavaPlugin instance;
    public static RankJavaPlugin instance() { return instance; }

    private Rank rank;
    public Rank getRank() { return rank; }

    @Override
    public void onLoad() {
        rank = new Rank(this);
    }

    @Override
    public void onEnable() {
        rank.initScoreboard();

        Bukkit.getPluginManager().registerEvents(new PlayerListener(),this);
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
