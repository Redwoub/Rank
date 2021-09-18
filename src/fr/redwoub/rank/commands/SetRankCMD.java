package fr.redwoub.rank.commands;

import fr.redwoub.rank.rank.Accouts;
import fr.redwoub.rank.rank.RankUnit;
import fr.redwoub.rank.utils.Players;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetRankCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        String prefix = "§7[§6Rank§7]";

        if(args.length < 2){
            sender.sendMessage(prefix + " §cErreur §8: §e/setrank <Pseudo du joueur> <rank>");
            sender.sendMessage(prefix + " §cErreur §8: §fLes ranks sont : §7Joueur, §eVip, §bMvp, §cYoutu§fbeur, §2Support, §3Builder, §9Moderateur, §6Developpeur, §4Administrateur");
            return false;
        }

        if(Bukkit.getPlayer(args[0]) == null){
            sender.sendMessage(prefix + " §cCe joueur n'est pas connecter ou n'existe pas !");
            return false;
        }

        Player target = Bukkit.getPlayer(args[0]);

        Accouts accouts = new Accouts(target);
        RankUnit rankUnit = RankUnit.valueOf(args[1].toUpperCase());
        Players.updateRank(target, args[1]);
        accouts.setRank(rankUnit);
        Players.updatePrefix(target);
        sender.sendMessage(prefix + " §aVous avez bien changer le rank de " + target.getName() + " en : §e " + args[1]);
        return false;
    }
}
