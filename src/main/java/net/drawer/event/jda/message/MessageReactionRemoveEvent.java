package net.drawer.event.jda.message;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.entities.User;

public class MessageReactionRemoveEvent extends MessageReactionEvent {

    public MessageReactionRemoveEvent(final JDA jda, final long responseNumber, final User user, final Member member, final MessageReaction reaction, final long userId) {
        super(jda, responseNumber, user, member, reaction, userId);
    }

    public MessageReactionRemoveEvent(final net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent jdaEvent) {
        super(jdaEvent);
    }
    
}
