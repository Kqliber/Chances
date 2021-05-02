package me.kaliber.chancecommands.commands;

import me.mattstudios.mf.annotations.Permission;
import me.mattstudios.mf.annotations.SubCommand;
import me.mattstudios.mf.annotations.Command;

import me.mattstudios.mf.base.CommandBase;
import org.bukkit.command.CommandSender;
import org.bukkit.Bukkit;

import java.util.SplittableRandom;

@Command("chances")
public final class ChanceCommand extends CommandBase
{
    private static final SplittableRandom RANDOM = new SplittableRandom();

    @SubCommand("execute")
    @Permission("chances.execute")
    public void executeChance(final CommandSender sender, final Integer chance, final String[] command)
    {
        if (chance >= RANDOM.nextInt(1, 100))
        {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), String.join(" ", command));
        }
    }
}
