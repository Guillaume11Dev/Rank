package fr.guillaume.rank.Commands;

import com.google.common.collect.Lists;
import fr.guillaume.rank.Rank;
import fr.guillaume.rank.RankList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.List;

public final class RankCommand implements CommandExecutor, TabCompleter {

    private  final Rank rank;

    public RankCommand(Rank rank) {
        this.rank = rank;
    }

    // /rank <Player> < NomGrade/id>
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player)
            if (rank.hasPowerInf((Player)sender, 90))
                return  sendMessage(sender,"§c Vous n'avez pas la permission");


        if (args.length < 2) return  sendMessage(sender, " §c/rank <Player> <Rank>" );

        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) return  sendMessage(sender, "§CLe joueur n'a pas été trouvé.");

        RankList rankList = null;

        try {
            rankList = rank.getRankById(Integer.parseInt(args[1]));
        }catch (NumberFormatException nbe){
            try{
                rankList = RankList.valueOf(args[1].toUpperCase());
            }catch (Exception e){
                return sendMessage(sender, "§cLe rank n'a pas été trouvé.");
            }

        }

        rank.changeRank(target, rankList);
        sendMessage(target, "§9Votre grade a été modifié.");
        return sendMessage(sender, "§6"+target.getName()+"§2a bien obtenu son grade"+rankList.getName().toLowerCase());

    }

    public  boolean sendMessage(CommandSender sender, String msg){
        sender.sendMessage(rank.getPrefix()+msg);
        return true;
    }


    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        List<String> tabComplete = Lists.newArrayList();

        if (args.length == 2){
            for (RankList rankList : RankList.values()){
                if (rankList.getName().toLowerCase().startsWith(args[1].toLowerCase())) tabComplete.add(rankList.getName());
            }

            return tabComplete;
        }

        return null;
    }
}
