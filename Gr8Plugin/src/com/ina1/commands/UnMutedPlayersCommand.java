package com.ina1.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.ina1.Messeges;
import com.ina1.utils.MutedPlayers;

public class UnMutedPlayersCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String String, String[] args) 
	{
		Player player = (Player) sender;
		if (sender instanceof Player) 
		{
			if(player.hasPermission("gr8.mute")) 
			{
				if (args.length == 1) 
				{
					Player target = Bukkit.getServer().getPlayer(args[0]);
					if (target != null) 
					{
						if (MutedPlayers.mutedPlayers.contains(target)) 
						{
							MutedPlayers.mutedPlayers.remove(target);
						}
						else
						{
							player.sendMessage(Messeges.alreadyMuted);
						}
						
					}
					else 
					{
						player.sendMessage(Messeges.ArgumentsErrorPlayer);
					}
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