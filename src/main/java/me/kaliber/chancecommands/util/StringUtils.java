package me.kaliber.chancecommands.util;

import org.bukkit.ChatColor;

public final class StringUtils
{

    private StringUtils() {}

    public static String color(final String string)
    {
        return ChatColor.translateAlternateColorCodes('&', string);
    }
}
