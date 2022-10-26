package net.drawer.event.jda.message;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;

public class MessageDeleteEvent extends MessageEvent {

    public MessageDeleteEvent(final JDA jda, final long responseNumber, final long messageId, final MessageChannel channel) {
        super(jda, responseNumber, messageId, channel);
    }

    public MessageDeleteEvent(final net.dv8tion.jda.api.events.message.MessageDeleteEvent jdaEvent) {
        super(jdaEvent);
    }

}
