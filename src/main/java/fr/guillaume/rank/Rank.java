package fr.guillaume.rank;

import jdk.tools.jlink.plugin.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public final class Rank {

    private Scoreboard scoreboard;
    private final JavaPlugin plugin;


    public Rank(JavaPlugin plugin) {
        this.plugin = plugin;
    }


    public final JavaPlugin getPlugin() {
        return plugin;
    }

    public final Scoreboard getScoreboard() {
        return scoreboard;
    }

    public  void initScoreboard() {
        if (scoreboard != null) throw new UnsupportedOperationException("Le scoreboard est deja initialise.");
        scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();

        for (RankList rankList : RankList.values()){
            Team team = scoreboard.registerNewTeam(rankList.getName());
            team.setPrefix(rankList.getPrefix());
            team.setSuffix(rankList.getSuffix());

        }

    }
}
