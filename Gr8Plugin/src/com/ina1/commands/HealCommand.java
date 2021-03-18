package com.ina1.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.ina1.Messeges;

public class HealCommand implements CommandExecutor {
	
	

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String String, String[] args) 
	{
		Player player = (Player) sender;
		
		if (sender instanceof Player) 
		{
			if (args.length == 0) 
			{
				if (player.hasPermission("gr8.heal.me"))
				{
				player.setHealth(20);
				player.setFoodLevel(20);
				player.setSaturation(20);
				player.sendMessage(Messeges.YouveBeenHealed);
				}
				else 
				{
					player.sendMessage(Messeges.YouDontHavePermission);
				}
			}
					
			else if (args.length == 1) 
			{
				if (player.hasPermission("gr8.heal.others")) 
				{
					Player target = Bukkit.getServer().getPlayer(args[0]);
					if (target != null) 
					{
						target.setHealth(20);
						target.setFoodLevel(20);
						target.setSaturation(20);
						target.sendMessage(Messeges.YouveBeenHealed);
					}
					else
					{ 
						player.sendMessage(Messeges.ArgumentsErrorPlayer);
						player.sendMessage(Messeges.ArgumentsSpecifyAPlayer);
					}
				}
				else 
				{
					player.sendMessage(Messeges.YouDontHavePermission);
				}
			}
			else
			{
				player.sendMessage(Messeges.TooManyArguments);
			}
		
	}
		return false;
	}
}
