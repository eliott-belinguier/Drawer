package net.drawer;

import net.drawer.plugin.PluginManager;
import net.dv8tion.jda.api.events.channel.ChannelCreateEvent;
import net.dv8tion.jda.api.events.channel.ChannelDeleteEvent;
import net.dv8tion.jda.api.events.channel.GenericChannelEvent;
import net.dv8tion.jda.api.events.channel.forum.ForumTagAddEvent;
import net.dv8tion.jda.api.events.channel.forum.ForumTagRemoveEvent;
import net.dv8tion.jda.api.events.channel.forum.GenericForumTagEvent;
import net.dv8tion.jda.api.events.channel.forum.update.ForumTagUpdateEmojiEvent;
import net.dv8tion.jda.api.events.channel.forum.update.ForumTagUpdateNameEvent;
import net.dv8tion.jda.api.events.channel.forum.update.GenericForumTagUpdateEvent;
import net.dv8tion.jda.api.events.channel.update.*;
import net.dv8tion.jda.api.events.guild.override.PermissionOverrideCreateEvent;
import net.dv8tion.jda.api.events.guild.override.PermissionOverrideDeleteEvent;
import net.dv8tion.jda.api.events.guild.override.PermissionOverrideUpdateEvent;
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.CommandAutoCompleteInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.MessageContextInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.SelectMenuInteractionEvent;
import net.dv8tion.jda.api.events.message.*;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveAllEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEmojiEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.api.events.self.*;
import net.dv8tion.jda.api.events.user.UserActivityEndEvent;
import net.dv8tion.jda.api.events.user.UserActivityStartEvent;
import net.dv8tion.jda.api.events.user.UserTypingEvent;
import net.dv8tion.jda.api.events.user.update.*;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class DrawerListenerAdapter extends ListenerAdapter {

    private final PluginManager pluginManager;

    public DrawerListenerAdapter(final PluginManager pluginManager) {
        this.pluginManager = pluginManager;
    }

    @Override
    public void onSlashCommandInteraction(@Nonnull SlashCommandInteractionEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.interaction.command.SlashCommandInteractionEvent(event));
    }

    @Override
    public void onUserContextInteraction(@Nonnull UserContextInteractionEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.interaction.command.UserContextInteractionEvent(event));
    }

    @Override
    public void onMessageContextInteraction(@Nonnull MessageContextInteractionEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.interaction.command.MessageContextInteractionEvent(event));
    }

    @Override
    public void onButtonInteraction(@Nonnull ButtonInteractionEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.interaction.component.ButtonInteractionEvent(event));
    }

    @Override
    public void onSelectMenuInteraction(@Nonnull SelectMenuInteractionEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.interaction.component.SelectMenuInteractionEvent(event));
    }

    @Override
    public void onCommandAutoCompleteInteraction(@Nonnull CommandAutoCompleteInteractionEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.interaction.command.CommandAutoCompleteInteractionEvent(event));
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

    @Override
    public void onUserUpdateActivities(@Nonnull UserUpdateActivitiesEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.user.UserUpdateActivitiesEvent(event));
    }

    @Override
    public void onGenericSelfUpdate(@NotNull GenericSelfUpdateEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.self.SelfUpdateEvent(event));
    }

    @Override
    public void onSelfUpdateAvatar(@NotNull SelfUpdateAvatarEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.self.SelfUpdateAvatarEvent(event));
    }

    @Override
    public void onSelfUpdateMFA(@NotNull SelfUpdateMFAEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.self.SelfUpdateMFAEvent(event));
    }

    @Override
    public void onSelfUpdateVerified(@NotNull SelfUpdateVerifiedEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.self.SelfUpdateVerifiedEvent(event));
    }

    @Override
    public void onSelfUpdateName(@NotNull SelfUpdateNameEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.self.SelfUpdateNameEvent(event));
    }

    /*
    public void onSelfUpdateDiscriminator(@NotNull SelfUpdateDiscriminatorEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.self.SelfUpdateDiscriminatorEvent(event));
    }*/

    @Override
    public void onGenericChannel(@NotNull GenericChannelEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.channel.ChannelEvent(event));
    }

    @Override
    public void onChannelCreate(@NotNull ChannelCreateEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.channel.ChannelCreateEvent(event));
    }

    @Override
    public void onChannelDelete(@NotNull ChannelDeleteEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.channel.ChannelDeleteEvent(event));
    }

    @Override
    public void onGenericForumTag(@NotNull GenericForumTagEvent event) {
       this.pluginManager.callEvent(new net.drawer.event.jda.channel.forum.ForumTagEvent(event));
    }

    @Override
    public void onForumTagAdd(@NotNull ForumTagAddEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.channel.forum.ForumTagAddEvent(event));
    }

    @Override
    public void onForumTagRemove(@NotNull ForumTagRemoveEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.channel.forum.ForumTagRemoveEvent(event));
    }

    @Override
    public void onGenericForumTagUpdate(@NotNull GenericForumTagUpdateEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.channel.forum.update.ForumTagUpdateEvent(event));
    }

    @Override
    public void onForumTagUpdateEmoji(@NotNull ForumTagUpdateEmojiEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.channel.forum.update.ForumTagUpdateEmojiEvent(event));
    }
    @Override
    public void onForumTagUpdateName(@NotNull ForumTagUpdateNameEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.channel.forum.update.ForumTagUpdateNameEvent(event));
    }
    @Override
    public void onForumTagUpdateModerated(@NotNull net.dv8tion.jda.api.events.channel.forum.update.ForumTagUpdateModeratedEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.channel.forum.update.ForumTagUpdateModeratedEvent(event));
    }

    @Override
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.message.MessageReceivedEvent(event));
    }

    @Override
    public void onMessageUpdate(@Nonnull MessageUpdateEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.message.MessageUpdateEvent(event));
    }

    @Override
    public void onMessageDelete(@Nonnull MessageDeleteEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.message.MessageDeleteEvent(event));
    }

    @Override
    public void onMessageBulkDelete(@Nonnull MessageBulkDeleteEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.message.MessageBulkDeleteEvent(event));
    }

    @Override
    public void onMessageEmbed(@Nonnull MessageEmbedEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.message.MessageEmbedEvent(event));
    }

    @Override
    public void onMessageReactionAdd(@Nonnull MessageReactionAddEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.message.MessageReactionAddEvent(event));
    }

    @Override
    public void onMessageReactionRemove(@Nonnull MessageReactionRemoveEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.message.MessageReactionRemoveEvent(event));
    }

    @Override
    public void onMessageReactionRemoveAll(@Nonnull MessageReactionRemoveAllEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.message.MessageReactionRemoveAllEvent(event));
    }

    @Override
    public void onMessageReactionRemoveEmoji(@Nonnull MessageReactionRemoveEmojiEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.message.MessageReactionRemoveEmojiEvent(event));
    }

    @Override
    public void onPermissionOverrideDelete(@NotNull PermissionOverrideDeleteEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.permission.PermissionOverrideDeleteEvent(event));
    }

    @Override
    public void onPermissionOverrideUpdate(@NotNull PermissionOverrideUpdateEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.permission.PermissionOverrideUpdateEvent(event));
    }

    @Override
    public void onPermissionOverrideCreate(@NotNull PermissionOverrideCreateEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.permission.PermissionOverrideCreateEvent(event));
    }

    @Override
    public void onChannelUpdateAppliedTags(@NotNull ChannelUpdateAppliedTagsEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.channel.update.ChannelUpdateAppliedTagsEvent(event));
    }

    @Override
    public void onChannelUpdateArchived(@NotNull ChannelUpdateArchivedEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.channel.update.ChannelUpdateArchivedEvent(event));
    }

    @Override
    public void onChannelUpdateArchiveTimestamp(@NotNull ChannelUpdateArchiveTimestampEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.channel.update.ChannelUpdateArchiveTimestampEvent(event));
    }

    @Override
    public void onChannelUpdateAutoArchiveDuration(@NotNull ChannelUpdateAutoArchiveDurationEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.channel.update.ChannelUpdateAutoArchiveDurationEvent(event));
    }

    @Override
    public void onChannelUpdateBitrate(@NotNull ChannelUpdateBitrateEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.channel.update.ChannelUpdateBitrateEvent(event));
    }

    @Override
    public void onChannelUpdateDefaultReaction(@NotNull ChannelUpdateDefaultReactionEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.channel.update.ChannelUpdateDefaultReactionEvent(event));
    }

    @Override
    public void onChannelUpdateDefaultThreadSlowmode(@NotNull ChannelUpdateDefaultThreadSlowmodeEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.channel.update.ChannelUpdateDefaultThreadSlowmodeEvent(event));
    }

    @Override
    public void onGenericChannelUpdate(@NotNull GenericChannelUpdateEvent<?> event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.channel.update.ChannelUpdateEvent(event));
    }

    @Override
    public void onChannelUpdateFlags(@NotNull ChannelUpdateFlagsEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.channel.update.ChannelUpdateFlagsEvent(event));
    }

    @Override
    public void onChannelUpdateInvitable(@NotNull ChannelUpdateInvitableEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.channel.update.ChannelUpdateInvitableEvent(event));
    }

    @Override
    public void onChannelUpdateLocked(@NotNull ChannelUpdateLockedEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.channel.update.ChannelUpdateLockedEvent(event));
    }

    @Override
    public void onChannelUpdateName(@NotNull ChannelUpdateNameEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.channel.update.ChannelUpdateNameEvent(event));
    }

    @Override
    public void onChannelUpdateNSFW(@NotNull ChannelUpdateNSFWEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.channel.update.ChannelUpdateNSFWEvent(event));
    }

    @Override
    public void onChannelUpdateParent(@NotNull ChannelUpdateParentEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.channel.update.ChannelUpdateParentEvent(event));
    }

    @Override
    public void onChannelUpdatePosition(@NotNull ChannelUpdatePositionEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.channel.update.ChannelUpdatePositionEvent(event));
    }

    @Override
    public void onChannelUpdateRegion(@NotNull ChannelUpdateRegionEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.channel.update.ChannelUpdateRegionEvent(event));
    }

    @Override
    public void onChannelUpdateSlowmode(@NotNull ChannelUpdateSlowmodeEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.channel.update.ChannelUpdateSlowmodeEvent(event));
    }

    @Override
    public void onChannelUpdateTopic(@NotNull ChannelUpdateTopicEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.channel.update.ChannelUpdateTopicEvent(event));
    }

    @Override
    public void onChannelUpdateType(@NotNull ChannelUpdateTypeEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.channel.update.ChannelUpdateTypeEvent(event));
    }

    @Override
    public void onChannelUpdateUserLimit(@NotNull ChannelUpdateUserLimitEvent event) {
        this.pluginManager.callEvent(new net.drawer.event.jda.channel.update.ChannelUpdateUserLimitEvent(event));
    }
}
