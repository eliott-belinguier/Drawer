package net.drawer.event.jda.message;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class MessageReceivedEvent extends MessageEvent {

    protected final Message message;

    public MessageReceivedEvent(final JDA jda, final long responseNumber, final Message message) {
        super(jda, responseNumber, message.getIdLong(), message.getChannel());
        this.message = message;
    }

    public MessageReceivedEvent(final net.dv8tion.jda.api.events.message.MessageReceivedEvent jdaEvent) {
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

    public boolean isWebhookMessage() {
        return this.message.isWebhookMessage();
    }

}
