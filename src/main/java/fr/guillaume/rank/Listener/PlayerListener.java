package fr.guillaume.rank.Listener;

import fr.guillaume.rank.Rank;
import fr.guillaume.rank.RankJavaPlugin;
import fr.guillaume.rank.RankList;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public final class PlayerListener implements Listener {

    public final Rank rank;

    public PlayerListener() {
        this.rank = RankJavaPlugin.instance().getRank();
    }

    @EventHandler
    private void playerJoin(PlayerJoinEvent pje){
        rank.loadPlayer(pje.getPlayer());


    }

    @EventHandler
    private void playerQuit(PlayerQuitEvent pqe ){
        rank.deletePlayer(pqe.getPlayer());

    }

    @EventHandler
    private void playerChat(AsyncPlayerChatEvent pce){

        RankList rankList = rank.getPlayerRank(pce.getPlayer());
        pce.setFormat(rankList.getPrefix()+pce.getPlayer().getName()+rankList.getSuffix()+rankList.getChatSeparator()+pce.getMessage());

    }




}
