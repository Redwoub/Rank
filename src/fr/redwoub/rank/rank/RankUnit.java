package fr.redwoub.rank.rank;

import org.bukkit.ChatColor;

import java.util.Arrays;

public enum RankUnit {

    JOUEUR("Joueur", 8, "§7[Joueur] ", ChatColor.GRAY),
    VIP("VIP", 7, "§7[§eVIP§7]§e ", ChatColor.YELLOW),
    MVP("MVP", 6, "§7[§bMVP§7]§b ", ChatColor.AQUA),
    YOUTUBEUR("YOUTUBEUR", 5, "§7[§cYoutu§fbeur§7]§f ", ChatColor.RED),
    SUPPORT("SUPPORT", 4, "§7[§2Support§7]§2 ", ChatColor.DARK_GREEN),
    BUILDER("BUILDER", 3, "§7[§3Builder§7]§3 ", ChatColor.DARK_AQUA),
    MODERATEUR("MODERATEUR", 2, "§7[§9Modérateur§7]§9 ", ChatColor.BLUE),
    DEVELOPPEUR("DEVELOPPEUR", 1, "§7[§6Developpeur§7]§6 ", ChatColor.GOLD),
    ADMINISTRATEUR("ADMINISTRATEUR", 0, "§7[§4Administrateur§7]§4 ", ChatColor.DARK_RED);


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

    public ChatColor getChatColor(){
        return chatColor;
    }

}
