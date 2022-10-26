package net.drawer.event.jda.message;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class MessageUpdateEvent extends MessageEvent {

    protected final Message message;

    public MessageUpdateEvent(final JDA jda, final long responseNumber, final Message message) {
        super(jda, responseNumber, message.getIdLong(), message.getChannel());
        this.message = message;
    }

    public MessageUpdateEvent(final net.dv8tion.jda.api.events.message.MessageUpdateEvent jdaEvent) {
        super(jdaEvent);
        this.message = jdaEvent.getMessage();
    }

    @Nonnull
    public Message getMessage() {
        return this.message;
    }

    @Nonnull
    public User getAuthor() {
        return this.message.getAuthor();
    }

    @Nullable
    public Member getMember() {
        return this.message.getMember();
    }

}
