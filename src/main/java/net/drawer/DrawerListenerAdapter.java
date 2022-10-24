package net.drawer;

import net.drawer.plugin.PluginManager;
import net.dv8tion.jda.api.events.interaction.command.MessageContextInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.SelectMenuInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class DrawerListenerAdapter extends ListenerAdapter {

    private final PluginManager pluginManager;

    public DrawerListenerAdapter(final PluginManager pluginManager) {
        this.pluginManager = pluginManager;
    }

    @Override
    public void onSlashCommandInteraction(@Nonnull SlashCommandInteractionEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.interaction.SlashCommandInteractionEvent(event));
    }

    @Override
    public void onUserContextInteraction(@Nonnull UserContextInteractionEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.interaction.UserContextInteractionEvent(event));
    }

    @Override
    public void onMessageContextInteraction(@Nonnull MessageContextInteractionEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.interaction.MessageContextInteractionEvent(event));
    }

    @Override
    public void onButtonInteraction(@Nonnull ButtonInteractionEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.interaction.ButtonInteractionEvent(event));
    }

    @Override
    public void onSelectMenuInteraction(@Nonnull SelectMenuInteractionEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.interaction.SelectMenuInteractionEvent(event));
    }

}
