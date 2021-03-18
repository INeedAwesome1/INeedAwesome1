package com.ina1.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.ina1.Messeges;
import com.ina1.utils.VanishUtils;

public class VanishCommand implements CommandExecutor{

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		 if (sender instanceof Player) {
	            Player player = (Player) sender;

	            if (player.hasPermission("gr8.vanish")) 
	            {
	                if (args.length == 0) 
	                {
	                    for (Player VanishPlayer : Bukkit.getServer().getOnlinePlayers()) // vanishes the player for everyone else Bukkit.getOnlinePlayers()
	                    { 
	                        VanishPlayer.hidePlayer(player);
	                    }
	                    VanishUtils.vanishedPlayers.add(player);
	                    player.sendMessage(ChatColor.LIGHT_PURPLE + Messeges.beenVanished);
	                    Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + player.getDisplayName() + " " + Messeges.playerLeaveEvent);
	                    System.out.println(ChatColor.DARK_RED + player.getDisplayName() + " " + Messeges.toConsolePlayerLeave);
	                }
	                else 
	                {
	                	player.sendMessage(Messeges.TooManyArguments);
	                }
	            }
	            else 
	            {
	            	player.sendMessage(Messeges.YouDontHavePermission);
	            }
		 	}	
		return false;
	}
}