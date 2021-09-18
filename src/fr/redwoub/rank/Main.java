package fr.redwoub.rank;

import fr.redwoub.rank.database.MySQL;
import fr.redwoub.rank.manager.Register;
import fr.redwoub.rank.rank.Accouts;
import fr.redwoub.rank.scoreboard.ScoreboardManager;
import fr.redwoub.rank.tablist.TabList;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Main extends JavaPlugin{

    private static Main instance;
    private MySQL mySQL = new MySQL();

    public WeakHashMap<Player, String> rankJoueurs = new WeakHashMap<>();
    public WeakHashMap<Player, Long> coinsJoueurs = new WeakHashMap<>();
    public WeakHashMap<Player, String> prefixRank = new WeakHashMap<>();
    private List<Accouts> accouts;

    private ScoreboardManager scoreboardManager;

    private ScheduledExecutorService executorMonoThread;
    private ScheduledExecutorService scheduledExecutorService;


    @Override
    public void onEnable() {
        instance = this;
        mySQL.connected("154.52.40.25", 3306, "s5695_Mydoria", "u5695_1dWebKgsp2", "Ykq6X07sXwnedLKYNXcg");
        mySQL.createTables();
        accouts = new ArrayList<>();
        Register.register();
        TabList.createTablist();

        scheduledExecutorService = Executors.newScheduledThreadPool(16);
        executorMonoThread = Executors.newScheduledThreadPool(1);
        scoreboardManager = new ScoreboardManager();
    }

    @Override
    public void onDisable() {
        mySQL.disconnect();
        getScoreboardManager().onDisable();
    }

    public static Main getInstance() {
        return instance;
    }

    public MySQL getMySQL() {
        return mySQL;
    }

    public List<Accouts> getAccouts() {
        return accouts;
    }

    public ScoreboardManager getScoreboardManager() {
        return scoreboardManager;
    }

    public ScheduledExecutorService getExecutorMonoThread() {
        return executorMonoThread;
    }

    public ScheduledExecutorService getScheduledExecutorService() {
        return scheduledExecutorService;
    }

}
