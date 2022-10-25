package net.drawer;

import net.drawer.plugin.PluginManager;
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.CommandAutoCompleteInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.MessageContextInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.SelectMenuInteractionEvent;
import net.dv8tion.jda.api.events.user.UserActivityEndEvent;
import net.dv8tion.jda.api.events.user.UserActivityStartEvent;
import net.dv8tion.jda.api.events.user.UserTypingEvent;
import net.dv8tion.jda.api.events.user.update.*;
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

    @Override
    public void onCommandAutoCompleteInteraction(@Nonnull CommandAutoCompleteInteractionEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.interaction.CommandAutoCompleteInteractionEvent(event));
    }

    @Override
    public void onModalInteraction(@Nonnull ModalInteractionEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.interaction.ModalInteractionEvent(event));
    }

    @Override
    public void onUserUpdateName(@Nonnull UserUpdateNameEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.user.UserUpdateNameEvent(event));
    }

    @Override
    public void onUserUpdateDiscriminator(@Nonnull UserUpdateDiscriminatorEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.user.UserUpdateDiscriminatorEvent(event));
    }

    @Override
    public void onUserUpdateAvatar(@Nonnull UserUpdateAvatarEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.user.UserUpdateAvatarEvent(event));
    }

    @Override
    public void onUserUpdateOnlineStatus(@Nonnull UserUpdateOnlineStatusEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.user.UserUpdateOnlineStatusEvent(event));
    }

    @Override
    public void onUserUpdateActivityOrder(@Nonnull UserUpdateActivityOrderEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.user.UserUpdateActivityOrderEvent(event));
    }

    @Override
    public void onUserUpdateFlags(@Nonnull UserUpdateFlagsEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.user.UserUpdateFlagsEvent(event));
    }

    @Override
    public void onUserTyping(@Nonnull UserTypingEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.user.UserTypingEvent(event));
    }

    @Override
    public void onUserActivityStart(@Nonnull UserActivityStartEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.user.UserActivityStartEvent(event));
    }

    @Override
    public void onUserActivityEnd(@Nonnull UserActivityEndEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.user.UserActivityEndEvent(event));
    }

}
