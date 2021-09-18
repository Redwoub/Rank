package fr.redwoub.rank.scoreboard;

import fr.redwoub.rank.Main;
import fr.redwoub.rank.rank.Accouts;
import fr.redwoub.rank.rank.RankUnit;
import fr.redwoub.rank.utils.Players;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PersonalScoreboard {
    private Player player;
    private final UUID uuid;
    private final ObjectiveSign objectiveSign;
    private RankUnit rankUnit;

    PersonalScoreboard(Player player){
        this.player = player;
        uuid = player.getUniqueId();
        objectiveSign = new ObjectiveSign("sidebar", "DevPlugin");

        reloadData();
        objectiveSign.addReceiver(player);
    }

    public void reloadData(){}

    public void setLines(String ip){
        objectiveSign.setDisplayName("§eMydoria");

        objectiveSign.setLine(0, "§1");
        objectiveSign.setLine(1, "§fGrade : " + Players.getPrefix(player));
        objectiveSign.setLine(2, "§fCoins : §6" + Players.getCoins(player));
        objectiveSign.setLine(3, "§3");
        objectiveSign.setLine(4, "§fJoueurs : §a" + Bukkit.getOnlinePlayers().size() + "/250");
        objectiveSign.setLine(5, "§fMonde : §a" + player.getWorld().getName());
        objectiveSign.setLine(6, "§4");
        objectiveSign.setLine(7, ip);

        objectiveSign.updateLines();
    }

    public void onLogout(){
        objectiveSign.removeReceiver(Bukkit.getServer().getOfflinePlayer(uuid));
    }
}
