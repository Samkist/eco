package com.willfp.eco.core.command.impl;

import com.willfp.eco.core.Eco;
import com.willfp.eco.core.EcoPlugin;
import com.willfp.eco.core.command.CommandBase;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Subcommands can be added to PluginCommands or to other Subcommands.
 */
public abstract class Subcommand implements CommandBase {

    private final CommandBase delegate;

    /**
     * Create subcommand.
     *
     * @param plugin      The plugin.
     * @param name        The subcommand name.
     * @param permission  The subcommand permission.
     * @param playersOnly If the subcommand only works on players.
     */
    protected Subcommand(@NotNull final EcoPlugin plugin,
                         @NotNull final String name,
                         @NotNull final String permission,
                         final boolean playersOnly) {
        this.delegate = Eco.get().createSubCommand(this, plugin, name, permission, playersOnly);
    }

    /**
     * Create subcommand.
     *
     * @param plugin The plugin.
     * @param name   The name of the subcommand.
     * @param parent The parent command.
     */
    protected Subcommand(@NotNull final EcoPlugin plugin,
                         @NotNull final String name,
                         @NotNull final CommandBase parent) {
        this(plugin, name, parent.getPermission(), parent.isPlayersOnly());
    }

    @Override
    public @NotNull String getName() {
        return delegate.getName();
    }

    @Override
    public @NotNull String getPermission() {
        return delegate.getPermission();
    }

    @Override
    public boolean isPlayersOnly() {
        return delegate.isPlayersOnly();
    }

    @Override
    public @NotNull CommandBase addSubcommand(@NotNull CommandBase command) {
        return delegate.addSubcommand(command);
    }

    @Override
    public @NotNull List<CommandBase> getSubcommands() {
        return delegate.getSubcommands();
    }

    @Override
    public @NotNull CommandBase getWrapped() {
        return this;
    }

    @Override
    public EcoPlugin getPlugin() {
        return delegate.getPlugin();
    }


}
