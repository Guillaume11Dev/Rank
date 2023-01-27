package fr.guillaume.rank;

import fr.guillaume.rank.Commands.RankCommand;
import fr.guillaume.rank.Listener.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class RankJavaPlugin extends JavaPlugin {

    private static RankJavaPlugin instance;
    public static RankJavaPlugin instance() {

        return instance; }

    private Rank rank;
    public Rank getRank() { return rank; }

    @Override
    public void onLoad() {



    }

    @Override
    public void onEnable() {
        instance = this;

        rank = new Rank(this);
        rank.initScoreboard();

        Bukkit.getPluginManager().registerEvents(new PlayerListener(),this);
        getCommand("rank").setExecutor(new RankCommand(rank));
    }
 //Test commit

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
