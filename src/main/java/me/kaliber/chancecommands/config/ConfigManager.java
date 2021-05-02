package me.kaliber.chancecommands.config;

import static me.kaliber.chancecommands.util.StringUtils.color;
import me.kaliber.chancecommands.ChanceCommandsPlugin;

import me.mattstudios.mf.base.MessageHandler;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.io.IOException;

public final class ConfigManager
{
    private final ChanceCommandsPlugin plugin;

    public ConfigManager(final ChanceCommandsPlugin plugin)
    {
        this.plugin = plugin;
    }

    public void reload()
    {
        plugin.reloadConfig();
        final FileConfiguration config = plugin.getConfig();

        for (Config value : Config.values())
        {
            if (config.get(value.getPath()) == null)
            {
                config.set(value.getPath(), value.getDefault());
            }
            value.load(config);
        }

        try
        {
            config.save(new File(plugin.getDataFolder(), "config.yml"));
        } catch (IOException exception)
        {
            plugin.getLogger().severe("Could not reload config!");
            exception.printStackTrace();
        }

        registerCommandUsages();
    }

    private void registerCommandUsages()
    {
        final MessageHandler handler = plugin.getCommandManager().getMessageHandler();
        handler.register("cmd.wrong.usage", sender -> {
            sender.sendMessage(color(Config.INVALID_COMMAND_USAGE.getString()));
        });

        handler.register("cmd.no.permission", sender -> {
            sender.sendMessage(color(Config.NO_PERMISSION.getString()));
        });

        handler.register("cmd.no.exists", sender -> {
            sender.sendMessage(color(Config.COMMAND_NOT_FOUND.getString()));
        });
    }

}
