package net.drawer.event.jda.message;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.entities.emoji.EmojiUnion;
import net.dv8tion.jda.api.events.message.react.GenericMessageReactionEvent;
import net.dv8tion.jda.api.requests.RestAction;
import net.dv8tion.jda.internal.requests.CompletedRestAction;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class MessageReactionEvent extends MessageEvent {

    protected final long userId;
    protected final User user;
    protected final Member member;
    protected final MessageReaction reaction;

    public MessageReactionEvent(final JDA jda, final long responseNumber, final User user, final Member member, final MessageReaction reaction, long userId) {
        super(jda, responseNumber, reaction.getMessageIdLong(), reaction.getChannel());
        this.userId = userId;
        this.user = user;
        this.member = member;
        this.reaction = reaction;
    }

    public MessageReactionEvent(final GenericMessageReactionEvent jdaEvent) {
        super(jdaEvent);
        this.userId = jdaEvent.getUserIdLong();
        this.user = jdaEvent.getUser();
        this.member = jdaEvent.getMember();
        this.reaction = jdaEvent.getReaction();
    }

    @Nonnull
    public String getUserId() {
        return Long.toUnsignedString(userId);
    }

    public long getUserIdLong() {
        return this.userId;
    }

    @Nullable
    public User getUser() {
        return this.user == null && isFromType(ChannelType.PRIVATE) ? getChannel().asPrivateChannel().getUser() : this.user;
    }

    @Nullable
    public Member getMember() {
        return this.member;
    }

    @Nonnull
    public MessageReaction getReaction() {
        return this.reaction;
    }

    @Nonnull
    public EmojiUnion getEmoji() {
        return this.reaction.getEmoji();
    }

    @Nonnull
    @CheckReturnValue
    public RestAction<User> retrieveUser() {
        final User user = getUser();

        if (user != null)
            return new CompletedRestAction<>(this.jda, user);
        return getJDA().retrieveUserById(this.userId);
    }

    @Nonnull
    @CheckReturnValue
    public RestAction<Member> retrieveMember() {
        if (this.member != null)
            return new CompletedRestAction<Member>(this.jda, this.member);
        return getGuild().retrieveMemberById(this.userId);
    }

    @Nonnull
    @CheckReturnValue
    public RestAction<Message> retrieveMessage() {
        return getChannel().retrieveMessageById(this.messageId);
    }

}
