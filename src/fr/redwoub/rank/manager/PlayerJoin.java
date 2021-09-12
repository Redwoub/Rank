package fr.redwoub.rank.manager;


import fr.redwoub.rank.Main;
import fr.redwoub.rank.rank.Accouts;
import fr.redwoub.rank.rank.RankUnit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        Accouts accouts = new Accouts(player);
        accouts.setup();
        if(accouts.getRank().getPower() <= RankUnit.MODERATEUR.getPower()){
            e.setJoinMessage(accouts.getRank().getPrefix() + player.getName() + " §fvient de rejoindre le serveur !");

        } else {
            e.setJoinMessage(ChatColor.GREEN + "+ " + ChatColor.WHITE + player.getName());
        }

        Main.getInstance().getScoreboardManager().onLogin(player);
        player.setFoodLevel(20);
        player.setHealth(20);

        try {
            PreparedStatement sts = Main.getInstance().getMySQL().getConnection().prepareStatement("SELECT * FROM players_info WHERE uuid=?");
            sts.setString(1, player.getUniqueId().toString());
            ResultSet rs = sts.executeQuery();
            if(rs.next()){
                Main.getInstance().rankjoueurs.put(player, rs.getString("grade"));
                Main.getInstance().coinjoueurs.put(player, rs.getLong("coins"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
