package com.ForgeEssentials.commands;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;

import com.ForgeEssentials.core.CoreConfig;
import com.ForgeEssentials.core.IFEModule;
import com.ForgeEssentials.core.ModuleLauncher;
import com.ForgeEssentials.permission.ForgeEssentialsPermissionRegistrationEvent;
import com.ForgeEssentials.permission.PermissionsAPI;
import com.ForgeEssentials.util.OutputHandler;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.event.FMLServerStoppingEvent;

public class ModuleCommands implements IFEModule
{

	public static ConfigCmd conf;

	public ModuleCommands()
	{
		if (!ModuleLauncher.cmdEnabled)
			return;
	}

	public void preLoad(FMLPreInitializationEvent e)
	{
		OutputHandler.SOP("Commands module is enabled. Loading...");
		conf = new ConfigCmd();
	}

	public void load(FMLInitializationEvent e)
	{
		MinecraftForge.EVENT_BUS.register(new EventHandler());
	}

	@Override
	public void postLoad(FMLPostInitializationEvent e)
	{
	}

	@Override
	public void serverStarting(FMLServerStartingEvent e)
	{
		e.registerServerCommand(new CommandMotd());
		e.registerServerCommand(new CommandRules());
		e.registerServerCommand(new CommandButcher());
		e.registerServerCommand(new CommandRemove());
		e.registerServerCommand(new CommandKill());
		e.registerServerCommand(new CommandSmite());
		e.registerServerCommand(new CommandSpawn());
		e.registerServerCommand(new CommandHome());
		e.registerServerCommand(new CommandTpSpawn());
		e.registerServerCommand(new CommandBack());
		e.registerServerCommand(new CommandRestart());
		e.registerServerCommand(new CommandServerDo());
		e.registerServerCommand(new CommandModlist());
		e.registerServerCommand(new CommandWarp());
		e.registerServerCommand(new CommandBackup());
		e.registerServerCommand(new CommandBurn());
		e.registerServerCommand(new CommandRepair());
		e.registerServerCommand(new CommandHeal());
		e.registerServerCommand(new CommandList());
		e.registerServerCommand(new CommandCredits());
	}

	@Override
	public void serverStarted(FMLServerStartedEvent e)
	{
	}

	@ForgeSubscribe
	public void registerPermissions(ForgeEssentialsPermissionRegistrationEvent event)
	{
		event.registerPermissionDefault("ForgeEssentials.commands", false);
		event.registerPermissionDefault("ForgeEssentials.commands.remove", false);
		event.registerPermissionDefault("ForgeEssentials.commands.restart", false);
		event.registerPermissionDefault("ForgeEssentials.commands.rules", false);
		event.registerPermissionDefault("ForgeEssentials.commands.serverdo", false);
		event.registerPermissionDefault("ForgeEssentials.commands.smite", false);
		event.registerPermissionDefault("ForgeEssentials.commands.kill", false);
		event.registerPermissionDefault("ForgeEssentials.commands.modlist", false);
		event.registerPermissionDefault("ForgeEssentials.commands.motd", false);
		event.registerPermissionDefault("ForgeEssentials.commands.burn", false);
		event.registerPermissionDefault("ForgeEssentials.commands.list", false);
		event.registerPermissionDefault("ForgeEssentials.commands.compass", false);
		event.registerPermissionDefault("ForgeEssentials.commands.repair", false);
		event.registerPermissionDefault("ForgeEssentials.commands.heal", false);
		
		event.registerGlobalGroupPermissions(PermissionsAPI.GROUP_OWNERS, "ForgeEssentials.commands", true);
		event.registerGlobalGroupPermissions(PermissionsAPI.GROUP_DEFAULT, "ForgeEssentials.commands.list", true);
		event.registerGlobalGroupPermissions(PermissionsAPI.GROUP_DEFAULT, "ForgeEssentials.commands.rules", true);
		event.registerGlobalGroupPermissions(PermissionsAPI.GROUP_DEFAULT, "ForgeEssentials.commands.motd", true);
		event.registerGlobalGroupPermissions(PermissionsAPI.GROUP_MEMBERS, "ForgeEssentials.commands.compass", true);
	}

	@Override
	public void serverStopping(FMLServerStoppingEvent e)
	{
		// TODO Auto-generated method stub

	}
}