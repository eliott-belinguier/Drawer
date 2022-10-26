package net.drawer.event.jda.message;

import net.drawer.event.jda.JDAEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.entities.channel.middleman.GuildChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.entities.channel.unions.GuildMessageChannelUnion;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.events.message.GenericMessageEvent;
import net.dv8tion.jda.internal.utils.Helpers;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class MessageEvent extends JDAEvent {

    protected final long messageId;
    protected final MessageChannel channel;

    public MessageEvent(final JDA jda, final long responseNumber, final long messageId, final MessageChannel channel) {
        super(jda, responseNumber);
        this.messageId = messageId;
        this.channel = channel;
    }

    public MessageEvent(final GenericMessageEvent jdaEvent) {
        this(jdaEvent.getJDA(), jdaEvent.getResponseNumber(), jdaEvent.getMessageIdLong(), jdaEvent.getChannel());
    }

    @NotNull
    public MessageChannelUnion getChannel() {
        return (MessageChannelUnion) this.channel;
    }

    @Nonnull
    public GuildMessageChannelUnion getGuildChannel() {
        if (!isFromGuild())
            throw new IllegalStateException("This message event did not happen in a guild");
        return (GuildMessageChannelUnion) this.channel;
    }

    @Nonnull
    public String getMessageId() {
        return Long.toUnsignedString(this.messageId);
    }

    public long getMessageIdLong() {
        return this.messageId;
    }

    public boolean isFromType(@Nonnull final ChannelType type) {
        return this.channel.getType() == type;
    }

    public boolean isFromGuild() {
        return this.channel.getType().isGuild();
    }

    @Nonnull
    public ChannelType getChannelType() {
        return this.channel.getType();
    }

    @Nonnull
    public Guild getGuild() {
        if (!isFromGuild())
            throw new IllegalStateException("This message event did not happen in a guild");
        return ((GuildChannel) this.channel).getGuild();
    }

    @Nonnull
    public String getJumpUrl() {
        return Helpers.format(Message.JUMP_URL, isFromGuild() ? getGuild().getId() : "@me", getChannel().getId(), getMessageId());
    }

    public boolean isFromThread() {
        return getChannelType().isThread();
    }

}
