package com.ina1.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.ina1.Messeges;
import com.ina1.utils.VanishUtils;

public class UnVanishCommand implements CommandExecutor{

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
		 if (sender instanceof Player) {
	            Player player = (Player) sender;

	            if (player.hasPermission("gr8.vanish")) 
	            {
	                if (args.length == 0) 
	                {
	                    for (Player VanishPlayer : Bukkit.getServer().getOnlinePlayers()) // vanishes the player for everyone else
	                    { 
	                        VanishPlayer.showPlayer(player);
	                    }
	                    VanishUtils.vanishedPlayers.remove(player);
	                    player.sendMessage(ChatColor.LIGHT_PURPLE + Messeges.beenUNvanished);
	                    Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + player.getDisplayName() + " " + Messeges.playerJoinEvent);
	                    System.out.println(ChatColor.DARK_RED + player.getDisplayName() + " " + Messeges.toConsolePlayerJoin);
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
