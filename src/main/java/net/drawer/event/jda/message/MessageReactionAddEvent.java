package net.drawer.event.jda.message;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.entities.User;

public class MessageReactionAddEvent extends MessageReactionEvent {

    public MessageReactionAddEvent(final JDA jda, final long responseNumber, final User user, final Member member, final MessageReaction reaction, final long userId) {
        super(jda, responseNumber, user, member, reaction, userId);
    }

    public MessageReactionAddEvent(final net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent jdaEvent) {
        super(jdaEvent);
    }

}
