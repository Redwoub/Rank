package fr.redwoub.rank.tablist;


import fr.redwoub.rank.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.omg.CORBA.TIMEOUT;

public class TabList implements Listener {

    private static String rankByPlayer(Player player){
        return Main.getInstance().rankjoueurs.get(player);
    }

    public static void createTablist(){

        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {

            @Override
            public void run() {
                for(Player players : Bukkit.getOnlinePlayers()){
                    Player player = players.getPlayer();

                    if(player.isOp()){
                        player.setPlayerListName("§cAdministrateur " + player.getName());
                    }else if(rankByPlayer(player).equalsIgnoreCase("joueur")){
                        player.setPlayerListName("§7Joueur " + player.getName());
                    }else if(rankByPlayer(player).equalsIgnoreCase("vip")){
                        player.setPlayerListName("§eVIP " + player.getName());
                    }else if(rankByPlayer(player).equalsIgnoreCase("MVP")){
                        player.setPlayerListName("§bMVP " + player.getName());
                    }else if(rankByPlayer(player).equalsIgnoreCase("support")){
                        player.setPlayerListName("§2Support " + player.getName());
                    }else if(rankByPlayer(player).equalsIgnoreCase("builder")){
                        player.setPlayerListName("§3Builder " + player.getName());
                    }else if(rankByPlayer(player).equalsIgnoreCase("moderateur")){
                        player.setPlayerListName("§9Modérateur " + player.getName());
                    }else if(rankByPlayer(player).equalsIgnoreCase("developper")) {
                        player.setPlayerListName("§6Développer " + player.getName());
                    }else if(rankByPlayer(player).equalsIgnoreCase("youtuber")){
                        player.setPlayerListName("§4Yout§fuber " + player.getName());
                    }
                }
            }
        }, 1, 1);
    }
}
