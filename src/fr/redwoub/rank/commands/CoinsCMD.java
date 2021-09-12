package fr.redwoub.rank.commands;

import fr.redwoub.rank.utils.Players;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CoinsCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player;
        Player target;
        String prefix = "§7[§6Rank§7]";

        if(!(sender instanceof Player)){
            sender.sendMessage("Seul un joueur peux executer cette commande.");
            return false;
        }
        player = (Player) sender;
        if(cmd.getName().equalsIgnoreCase("setcoins")){
            if(args.length != 2){
                player.sendMessage(prefix + " §cErreur §8: §e/setcoins <Player> <coins>");
                return false;
            }

            if(Bukkit.getPlayer(args[0]) == null){
                player.sendMessage(prefix + " §cErreur §8: §cCe joueur n'existe pas !");
                return false;
            }

            target = Bukkit.getPlayer(args[0]);

            if(args.length == 2){
                Players.setCoins(target, Long.parseLong(args[1]));
                player.sendMessage(prefix + " §a Vous avez bien set : " + args[1] + " coins à : " + target.getName());
            }
            return false;
        }

        if(cmd.getName().equalsIgnoreCase("addcoins")){
            if(args.length != 2){
                player.sendMessage(prefix + " §cErreur §8: §e/addcoins <Player> <coins>");
                return false;
            }

            if(Bukkit.getPlayer(args[0]) == null){
                player.sendMessage(prefix + " §cErreur §8: §cCe joueur n'existe pas !");
                return false;
            }

            target = Bukkit.getPlayer(args[0]);

            if(args.length == 2){
                Players.addCoins(target, Long.parseLong(args[1]));
                player.sendMessage(prefix + " §a Vous avez bien ajouter : " + args[1] + " coins à : " + target.getName());
                return false;
            }

            return false;
        }

        if(cmd.getName().equalsIgnoreCase("removecoins")){
            if(args.length != 2){
                player.sendMessage(prefix + " §cErreur §8: §e/removecoins <Player> <coins>");
                return false;
            }

            if(Bukkit.getPlayer(args[0]) == null){
                player.sendMessage(prefix + " §cErreur §8: §cCe joueur n'existe pas !");
                return false;
            }

            target = Bukkit.getPlayer(args[0]);

            if(args.length == 2){
                Players.removeCoins(target, Long.parseLong(args[1]), player);
                return false;
            }

            return false;
        }
        return false;
    }
}
