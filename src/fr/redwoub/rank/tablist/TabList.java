package fr.redwoub.rank.tablist;


import fr.redwoub.rank.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class TabList implements Listener {

    private static String rankByPlayer(Player player){
        return Main.getInstance().rankJoueurs.get(player);
    }

    public static void createTablist(){

        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {

            @Override
            public void run() {
                for(Player players : Bukkit.getOnlinePlayers()){
                    Player player = players.getPlayer();

                    if(rankByPlayer(player).equalsIgnoreCase("administrateur")){
                        player.setPlayerListName("§7[§4Administrateur§7]§4 " + player.getName());
                    }else if(rankByPlayer(player).equalsIgnoreCase("joueur")){
                        player.setPlayerListName("§7[Joueur] " + player.getName());
                    }else if(rankByPlayer(player).equalsIgnoreCase("vip")){
                        player.setPlayerListName("§7[§eVIP§7]§e " + player.getName());
                    }else if(rankByPlayer(player).equalsIgnoreCase("MVP")){
                        player.setPlayerListName("§7[§bMVP§7]§b " + player.getName());
                    }else if(rankByPlayer(player).equalsIgnoreCase("support")){
                        player.setPlayerListName("§7[§2Support§7]§2 " + player.getName());
                    }else if(rankByPlayer(player).equalsIgnoreCase("builder")){
                        player.setPlayerListName("§7[§3Builder§7]§3 " + player.getName());
                    }else if(rankByPlayer(player).equalsIgnoreCase("moderateur")){
                        player.setPlayerListName("§7[§9Modérateur§7]§9 " + player.getName());
                    }else if(rankByPlayer(player).equalsIgnoreCase("developpeur")) {
                        player.setPlayerListName("§7[§6Développeur§7]§6 " + player.getName());
                    }else if(rankByPlayer(player).equalsIgnoreCase("youtubeur")){
                        player.setPlayerListName("§7[§cYoutu§fbeur§7]§f " + player.getName());
                    }
                }
            }
        }, 1, 10);
    }
}
