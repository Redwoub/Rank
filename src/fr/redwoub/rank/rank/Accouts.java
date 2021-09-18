package fr.redwoub.rank.rank;

import fr.redwoub.rank.Main;
import fr.redwoub.rank.database.MySQL;
import fr.redwoub.rank.utils.Players;
import org.bukkit.entity.Player;
import java.sql.SQLException;


public class Accouts {

    private static final String TABLE = "players_info ";
    private Player player;
    private String uuid;

    public Accouts(Player player) {
        this.player = player;
        uuid = player.getUniqueId().toString();
    }

    public Player getPlayer() {
        return player;
    }

    public void setup(){
        Main.getInstance().getAccouts().add(this);
        Main.getInstance().getMySQL().query("SELECT * FROM " + TABLE + "WHERE uuid='" + uuid + "'", rs ->{
            try {
                if(!rs.next()){
                    Main.getInstance().getMySQL().update("INSERT INTO " + TABLE + "(uuid, pseudo, grade, coins) VALUES ('" + uuid + "', '" + player.getName() + "', '" + RankUnit.JOUEUR.getName() + "', '0')");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public static Accouts getAccount(Player player){
        return Main.getInstance().getAccouts().stream().filter(a -> a.getPlayer() == player).findFirst().get();
    }

    public RankUnit getRank(){
        return (RankUnit) Main.getInstance().getMySQL().query("SELECT * FROM " + TABLE + " WHERE uuid='" + uuid + "'", rs -> {
            try {
                if(rs.next()){
                    return RankUnit.getByName(rs.getString("grade"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return RankUnit.JOUEUR;
        });
    }

    public void setRank(RankUnit rankName){
        Players.updateRank(player, String.valueOf(rankName));
        Main.getInstance().getMySQL().update("UPDATE " +  TABLE + " SET grade='" + rankName + "' WHERE uuid='" + uuid + "'");
    }

    public void delete(){
        Main.getInstance().getAccouts().remove(this);
    }


}
