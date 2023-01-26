package fr.guillaume.rank;

import com.google.common.collect.Maps;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public final class Rank {

    private final Map<String, RankList> playerRanks = Maps.newHashMap();
    private Scoreboard scoreboard;
    private final JavaPlugin plugin;
    private FileConfiguration config;
    private File file;

    public Rank(JavaPlugin plugin) {
        this.plugin = plugin;
        initConfig();
    }

    public final JavaPlugin getPlugin() {
        return plugin;
    }
    public final Scoreboard getScoreboard() {
        return scoreboard;
    }

    private void initConfig() {
        File f = new File("plugins/rank");
        if (f.exists()) f.mkdirs();
        file = new File(f, "rank.yml");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        config = YamlConfiguration.loadConfiguration(file);
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

    public void loadPlayer(Player player){
        String uuid = player.getUniqueId().toString();
        if (playerRanks.containsKey(uuid)) return;
        if (!config.contains(uuid)){
            config.set("uuid", 1);
            saveConfig();
        }

        playerRanks.put(uuid, getRankById(config.getInt(uuid)));
        scoreboard.getTeam(playerRanks.get(uuid).getName()).addEntry(player.getName());
    }

    public void deletePlayer(Player player){
        if (!playerRanks.containsKey(player.getUniqueId().toString())) return;
        playerRanks.remove(player.getUniqueId().toString());
    }


    public RankList getPlayerRank(Player player){

        if (!playerRanks.containsKey(player.getUniqueId().toString())) loadPlayer(player);
        return playerRanks.get(player.getUniqueId().toString());

    }

    public  RankList getRankById(int id){
        for (RankList rankList : RankList.values()){
            if (rankList.getId() == id) return  rankList;
        }
        return RankList.PLAYER;
    }

    public void saveConfig() {
        try {
            config.save(file);
        }catch(IOException ioe){ioe.printStackTrace();}
    }
}
