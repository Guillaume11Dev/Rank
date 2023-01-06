package fr.guillaume.rank.Listener;

import fr.guillaume.rank.RankJavaPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public final class PlayerListener implements Listener {

    public PlayerListener() {

    }


    @EventHandler
    private void playerJoin(PlayerJoinEvent pje){

        
       /* pje.getPlayer().setScoreboard(RankJavaPlugin.instance().getRank().getScoreboard()); */
    }

    @EventHandler
    private void playerQuit(PlayerQuitEvent pqe ){

    }

    @EventHandler
    private void playerChat(AsyncPlayerChatEvent pce){

    }


}
