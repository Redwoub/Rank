package fr.redwoub.rank.manager;

import fr.redwoub.rank.Main;
import fr.redwoub.rank.commands.CoinsCMD;
import fr.redwoub.rank.commands.SetRankCMD;
import org.bukkit.plugin.PluginManager;

public class Register {

    private static Main main = Main.getInstance();
    private static PluginManager pm = main.getServer().getPluginManager();

    public static void register(){
        pm.registerEvents(new PlayerJoin(), main);
        pm.registerEvents(new PlayerManager(), main);
        pm.registerEvents(new PlayerQuit(), main);
        pm.registerEvents(new PlayerChatEvent(), main);

        main.getCommand("setcoins").setExecutor(new CoinsCMD());
        main.getCommand("addcoins").setExecutor(new CoinsCMD());
        main.getCommand("removecoins").setExecutor(new CoinsCMD());
        main.getCommand("setrank").setExecutor(new SetRankCMD());
    }
}
