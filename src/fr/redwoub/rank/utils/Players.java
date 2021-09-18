package fr.redwoub.rank.utils;

import fr.redwoub.rank.Main;
import fr.redwoub.rank.rank.Accouts;
import org.bukkit.entity.Player;

public class Players {

    public static void updateRank(Player player, String rank){
        Main.getInstance().rankJoueurs.remove(player);
        Main.getInstance().rankJoueurs.put(player, rank);
    }

    public static long getCoins(Player target){
        return Main.getInstance().coinsJoueurs.get(target);
    }

    public static void updateCoins(Player player, long coins){
        long finalcoin = getCoins(player) + coins;
        Main.getInstance().coinsJoueurs.remove(player);
        Main.getInstance().coinsJoueurs.put(player, finalcoin);
    }

    public static void setCoins(Player target, long coins){
        Main.getInstance().coinsJoueurs.remove(target);
        Main.getInstance().coinsJoueurs.put(target, coins);
    }

    public static void addCoins(Player target, long coins){
        updateCoins(target, coins);
    }

    public static void removeCoins(Player target, long coins, Player sender){
        if(getCoins(target) >= coins){
            long finalcoin = getCoins(target) - coins;
            Main.getInstance().coinsJoueurs.remove(target);
            Main.getInstance().coinsJoueurs.put(target, finalcoin);
            sender.sendMessage("§7[§6Rank§7] §a Vous avez bien retirer : " + coins + " coins à : " + target.getName());
        }else {
            setCoins(target, 0);
            sender.sendMessage("§7[§6Rank§7] §cErreur §8: §cLe joueur n'avais pas assez de coins pour lui en retirer " + coins + "§c. Il a donc était remis a 0 !");
        }
    }

    public static String getRank(Player player){
        return Main.getInstance().rankJoueurs.get(player);
    }

    public static String getPrefix(Player player){
        return Main.getInstance().prefixRank.get(player);
    }

    public static void updatePrefix(Player player){
        Main.getInstance().prefixRank.remove(player);
        Main.getInstance().prefixRank.put(player, Accouts.getAccount(player).getRank().getPrefix());
    }
}
