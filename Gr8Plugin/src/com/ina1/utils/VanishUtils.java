package com.ina1.utils;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class VanishUtils {

	public static ArrayList<Player> vanishedPlayers = new ArrayList<Player>();
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event)
	{
		Player player = event.getPlayer();
		for (int i = 0; i < vanishedPlayers.size(); i++) 
		{
			player.hidePlayer(vanishedPlayers.get(i));
		}
		
		if (vanishedPlayers.contains(player)) 
		{
			event.setJoinMessage(null);
		}
	} 
	
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent event) 
	{
		Player player = event.getPlayer();
		if (vanishedPlayers.contains(player)) 
		{
			event.setQuitMessage(null);
		}
	}
}
