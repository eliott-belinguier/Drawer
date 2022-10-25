package net.drawer.event.jda.user;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.OffsetDateTime;

public class UserTypingEvent extends UserEvent {

    protected final Member member;
    protected final MessageChannel channel;
    protected final OffsetDateTime timestamp;

    public UserTypingEvent(final JDA jda, final long responseNumber, final User user, final MessageChannel channel, OffsetDateTime timestamp, Member member) {
        super(jda, responseNumber, user);
        this.member = member;
        this.channel = channel;
        this.timestamp = timestamp;
    }

    public UserTypingEvent(final net.dv8tion.jda.api.events.user.UserTypingEvent jdaEvent) {
        super(jdaEvent);
        this.member = jdaEvent.getMember();
        this.channel = jdaEvent.getChannel();
        this.timestamp = jdaEvent.getTimestamp();
    }

    @Nonnull
    public OffsetDateTime getTimestamp() {
        return this.timestamp;
    }

    @Nonnull
    public MessageChannel getChannel() {
        return this.channel;
    }

    public boolean isFromType(ChannelType  type) {
        return this.channel.getType() == type;
    }

    @Nonnull
    public ChannelType getType() {
        return this.channel.getType();
    }

    @Nullable
    public Guild getGuild() {
        return getType().isGuild() ? member.getGuild() : null;
    }

    @Nullable
    public Member getMember() {
        return this.member;
    }

}
