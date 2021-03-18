package com.ina1.utils;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class MutedPlayers {
	
	public static ArrayList<Player> mutedPlayers = new ArrayList<Player>();
	
	@SuppressWarnings("unlikely-arg-type")
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) 
	{
		Player player = event.getPlayer();
		if (mutedPlayers.contains(player.getName())) 
        {
        	event.setCancelled(true);
        }    
	}
}
