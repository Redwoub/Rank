package fr.redwoub.rank.utils;

import fr.redwoub.rank.Main;
import org.bukkit.entity.Player;

public class Players {

    public static void updateRank(Player player, String rank){
        Main.getInstance().rankjoueurs.remove(player);
        Main.getInstance().rankjoueurs.put(player, rank);
    }

    public static long getCoins(Player target){
        return Main.getInstance().coinjoueurs.get(target);
    }

    public static void updateCoins(Player player, long coins){
        long finalcoin = getCoins(player) + coins;
        Main.getInstance().coinjoueurs.remove(player);
        Main.getInstance().coinjoueurs.put(player, finalcoin);
    }

    public static void setCoins(Player target, long coins){
        Main.getInstance().coinjoueurs.remove(target);
        Main.getInstance().coinjoueurs.put(target, coins);
    }

    public static void addCoins(Player target, long coins){
        updateCoins(target, coins);
    }

    public static void removeCoins(Player target, long coins, Player sender){
        if(getCoins(target) >= coins){
            long finalcoin = getCoins(target) - coins;
            Main.getInstance().coinjoueurs.remove(target);
            Main.getInstance().coinjoueurs.put(target, finalcoin);
            sender.sendMessage("§7[§6Rank§7] §a Vous avez bien retirer : " + coins + " coins à : " + target.getName());
        }else {
            setCoins(target, 0);
            sender.sendMessage("§7[§6Rank§7] §cErreur §8: §cLe joueur n'avais pas assez de coins pour lui en retirer " + coins + "§c. Il a donc était remis a 0 !");
        }
    }
}
