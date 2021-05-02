package me.kaliber.chancecommands.config;

import org.bukkit.configuration.file.FileConfiguration;

public enum Config
{
   // DEBUG_ENABLED("settings.debug", false),
    INVALID_COMMAND_USAGE("messages.invalid-command-usage", "&cInvalid usage!"),
    COMMAND_NOT_FOUND("messages.command-not-found", "&cThe command you're trying to use doesn't exist!"),
    NO_PERMISSION("messages.no-permission", "&cNo Permission!"),
    RELOAD_COMMAND_SUCCESS("messages.reload-command", "&bReloaded config");

    private final String path;
    private final Object def;
    private Object value;

    Config(String path, Object def)
    {
        this.path = path;
        this.def = def;
    }

    public void load(final FileConfiguration config)
    {
        this.value = config.get(this.path);
    }

    public String getPath()
    {
        return path;
    }

    public Object getDefault()
    {
        return def;
    }

    public String getString()
    {
        return String.valueOf(value);
    }

    public boolean getBool()
    {
        return (boolean) value;
    }

}
