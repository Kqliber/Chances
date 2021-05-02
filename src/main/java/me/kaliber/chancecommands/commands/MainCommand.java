package me.kaliber.chancecommands.commands;

import me.kaliber.chancecommands.util.StringUtils;
import me.mattstudios.mf.annotations.Permission;
import me.mattstudios.mf.annotations.Command;
import me.mattstudios.mf.annotations.Default;
import me.mattstudios.mf.base.CommandBase;
import org.bukkit.command.CommandSender;
import me.kaliber.chancecommands.ChanceCommandsPlugin;

import java.util.stream.Stream;

@Command("chances")
public final class MainCommand extends CommandBase
{

    private final ChanceCommandsPlugin plugin;

    public MainCommand(final ChanceCommandsPlugin plugin)
    {
        this.plugin = plugin;
    }

    @Default
    @Permission("chances.admin")
    public void mainCommand(final CommandSender sender)
    {
        Stream.of(
                "&bChances Plugin: &fv" + plugin.getDescription().getVersion(),
                "&bBy: &fKaliber")
                .map(StringUtils::color)
                .forEach(sender::sendMessage);
    }
}
