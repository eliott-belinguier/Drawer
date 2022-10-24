package net.drawer;

import net.drawer.plugin.PluginManager;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class DrawerListenerAdapter extends ListenerAdapter {

    private final PluginManager pluginManager;

    public DrawerListenerAdapter(final PluginManager pluginManager) {
        this.pluginManager = pluginManager;
    }

    @Override
    public void onSlashCommandInteraction(@Nonnull SlashCommandInteractionEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.interaction.SlashCommandInteractionEvent(event));
    }

    @Override
    public void onUserContextInteraction(@Nonnull UserContextInteractionEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.interaction.UserContextInteractionEvent(event));
    }

}
