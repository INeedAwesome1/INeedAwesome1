package com.ina1;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import com.ina1.commands.*;

public class Gr8 extends JavaPlugin {
	
	@Override
    public void onEnable() 
	{
		// REMEMBER TO ADD COMMAND TO PLUGIN.YML
		getCommand("heal").setExecutor(new HealCommand());
		getCommand("gr8").setExecutor(new Gr8HelpCommand());
		getCommand("mute").setExecutor(new MutedPlayersCommand());
		getCommand("unmute").setExecutor(new UnMutedPlayersCommand());
		getCommand("vanish").setExecutor(new VanishCommand());
		getCommand("unvanish").setExecutor(new UnVanishCommand());
		System.out.println(ChatColor.DARK_RED + Messeges.PEnabled);
    }
    @Override
    public void onDisable() 
    {
        getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED + Messeges.PDisabled);
    }
}