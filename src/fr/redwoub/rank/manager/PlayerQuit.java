package fr.redwoub.rank.manager;

import fr.redwoub.rank.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PlayerQuit implements Listener {

    @EventHandler
    public void playerQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();

        try {
            PreparedStatement sts = Main.getInstance().getMySQL().getConnection().prepareStatement("UPDATE players_info SET grade=? WHERE uuid=?");
            sts.setString(1, Main.getInstance().rankJoueurs.get(player));
            sts.setString(2, player.getUniqueId().toString());
            sts.executeUpdate();

            PreparedStatement sts2 = Main.getInstance().getMySQL().getConnection().prepareStatement("UPDATE players_info SET coins=? WHERE uuid=?");
            sts2.setLong(1, Main.getInstance().coinsJoueurs.get(player));
            sts2.setString(2, player.getUniqueId().toString());
            sts2.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
