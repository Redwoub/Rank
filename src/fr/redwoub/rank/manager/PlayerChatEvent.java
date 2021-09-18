package fr.redwoub.rank.manager;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChatEvent implements Listener {

    @EventHandler
    public void chatEvent(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();
        String value = ChatColor.translateAlternateColorCodes('&', event.getMessage());
        if(player.hasPermission("chatcolor.use")){
            event.setMessage(value);
        }
    }
}
