package fr.redwoub.rank.rank;

import fr.redwoub.rank.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.Arrays;

public enum RankUnit {

    JOUEUR("Joueur", 8, "§7", ChatColor.GRAY),
    VIP("VIP", 7, "§eVIP ", ChatColor.YELLOW),
    MVP("MVP", 6, "§4Yout§fuber ", ChatColor.DARK_RED),
    YOUTUBER("YOUTUBER", 5, "§bMVP ", ChatColor.AQUA),
    SUPPORT("SUPPORT", 4, "§2Support ", ChatColor.DARK_GREEN),
    BUILDER("BUILDER", 3, "§3Builder ", ChatColor.DARK_BLUE),
    MODERATEUR("MODERATEUR", 2, "§9Modérateur ", ChatColor.BLUE),
    DEVELOPPER("DEVELOPPER", 1, "§6Developper ", ChatColor.GOLD),
    ADMINISTRATEUR("ADMINISTRATEUR", 0, "§4Administrateur ", ChatColor.DARK_RED);


    private String name;
    private int power;
    private String prefix;
    private ChatColor chatColor;

    RankUnit(String name, int power, String prefix, ChatColor chatColor){
        this.name = name;
        this.power = power;
        this.prefix = prefix;
        this.chatColor = chatColor;
    }

    public static RankUnit getByName(String name){
        return Arrays.stream(values()).filter(r -> r.getName().equalsIgnoreCase(name)).findAny().orElse(RankUnit.JOUEUR);
    }

    public static RankUnit getbyPower(int power){
        return Arrays.stream(values()).filter(r -> r.getPower() == power).findAny().orElse(RankUnit.JOUEUR);
    }


    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public String getPrefix() {
        return prefix;
    }


}
