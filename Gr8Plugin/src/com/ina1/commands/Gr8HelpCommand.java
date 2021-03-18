package com.ina1.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.ina1.Messeges;

public class Gr8HelpCommand implements CommandExecutor {

	public static String opCommands = "/heal <player>";
	
	public static String defaultCommands = "";
	
	// help commands
	public static String help = "This is a command plugin for a list of commands do '/gr8 commands'";
	
	@SuppressWarnings("unlikely-arg-type")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String String, String[] args) 
	{

		Player player = (Player) sender;
		
		if (sender instanceof Player) 
		{	
			
			if (args.length == 0) 
			{
				player.sendMessage("Author: " + Messeges.Author);
				player.sendMessage("Version: " + Messeges.plugin_version);
				player.sendMessage(Messeges.commands_list);
			}
			
			else if (args.equals("help"))
			{
				player.sendMessage("");
			}
			
			else if (args.equals("commands"))
			{ 
				if (player.isOp()) 
				{
					player.sendMessage(opCommands);
				}
				else 
				{ 
					
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

			