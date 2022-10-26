package net.drawer.event.jda.message;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;

public class MessageReactionRemoveAllEvent extends MessageEvent {

    public MessageReactionRemoveAllEvent(final JDA jda, final long responseNumber, final long messageId, final MessageChannel channel) {
        super(jda, responseNumber, messageId, channel);
    }

    public MessageReactionRemoveAllEvent(final net.dv8tion.jda.api.events.message.react.MessageReactionRemoveAllEvent jdaEvent) {
        super(jdaEvent);
    }

}
