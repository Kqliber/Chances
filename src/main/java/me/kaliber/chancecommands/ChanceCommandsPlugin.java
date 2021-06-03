package me.kaliber.chancecommands;

import me.kaliber.chancecommands.commands.ReloadCommand;
import me.kaliber.chancecommands.commands.ChanceCommand;
import me.kaliber.chancecommands.commands.MainCommand;
import me.kaliber.chancecommands.config.ConfigManager;
import me.mattstudios.mf.base.CommandManager;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.IOException;
import java.io.File;

public final class ChanceCommandsPlugin extends JavaPlugin
{

    private final ConfigManager configManager = new ConfigManager(this);

    private CommandManager commandManager;

    @Override
    public void onEnable()
    {
        commandManager = new CommandManager(this);
        commandManager.register(
                new ChanceCommand(),
                new MainCommand(this),
                new ReloadCommand(this)
        );
        loadConfig();
    }

    private void loadConfig()
    {
        final File file = new File(this.getDataFolder(), "config.yml");
        if (!file.exists())
        {
            file.getParentFile().mkdirs();
            try
            {
                file.createNewFile();
            } catch (final IOException exception)
            {
                this.getLogger().severe("Cannot create config file!" + exception);
            }
            this.getConfig().options().copyDefaults(true);
        }
        saveConfig();
        configManager.reload();
    }

    public ConfigManager getConfigManager()
    {
        return configManager;
    }

    public CommandManager getCommandManager()
    {
        return commandManager;
    }
}
