package fr.redwoub.rank.manager;


import fr.redwoub.rank.Main;
import fr.redwoub.rank.rank.Accouts;
import fr.redwoub.rank.rank.RankUnit;
import fr.redwoub.rank.utils.Players;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


public class PlayerManager implements Listener {


    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();
        RankUnit rankUnit = Accouts.getAccount(player).getRank();
        Accouts accouts = new Accouts(player);

        event.setFormat(rankUnit.getPrefix() + "%1$s §7> " + (rankUnit == RankUnit.JOUEUR ? "§7" : "§f" + "%2$s"));
    }

    @EventHandler
    public void onLeft(PlayerQuitEvent e){
        Player player = e.getPlayer();
        Accouts accouts = new Accouts(player);

        if(accouts.getRank().getPower() <= RankUnit.MODERATEUR.getPower()){
            e.setQuitMessage(accouts.getRank().getPrefix() + player.getName() + " §fvient de quitter le serveur !");
        } else {
            e.setQuitMessage(ChatColor.RED + "- " + ChatColor.WHITE + player.getName());
        }

        Main.getInstance().getScoreboardManager().onLogout(player);
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        Inventory inv = event.getInventory();
        Player player = (Player) event.getWhoClicked();
        ItemStack current = event.getCurrentItem();

        if (current == null) return;

        if (inv.getName().equalsIgnoreCase("§7Sanctions pour ")) {

        }
    }

}




