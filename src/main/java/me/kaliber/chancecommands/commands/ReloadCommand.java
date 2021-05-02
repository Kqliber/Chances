package me.kaliber.chancecommands.commands;

import me.kaliber.chancecommands.ChanceCommandsPlugin;
import me.kaliber.chancecommands.config.Config;
import me.kaliber.chancecommands.util.StringUtils;
import me.mattstudios.mf.annotations.Command;
import me.mattstudios.mf.annotations.Permission;
import me.mattstudios.mf.annotations.SubCommand;
import me.mattstudios.mf.base.CommandBase;
import org.bukkit.command.CommandSender;

@Command("chances")
public final class ReloadCommand extends CommandBase
{

    private final ChanceCommandsPlugin plugin;

    public ReloadCommand(final ChanceCommandsPlugin plugin)
    {
        this.plugin = plugin;
    }

    @SubCommand("reload")
    @Permission("chances.admin")
    public void reload(final CommandSender sender)
    {
        plugin.getConfigManager().reload();
        sender.sendMessage(StringUtils.color(Config.RELOAD_COMMAND_SUCCESS.getString()));
    }
}
