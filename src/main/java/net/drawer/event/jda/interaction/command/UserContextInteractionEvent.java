package net.drawer.event.jda.interaction.command;


import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.interactions.Interaction;
import net.dv8tion.jda.api.interactions.commands.context.ContextInteraction;
import net.dv8tion.jda.api.interactions.commands.context.UserContextInteraction;

import javax.annotation.Nullable;

public class UserContextInteractionEvent extends ContextInteractionEvent<User> implements UserContextInteraction {

    public UserContextInteractionEvent(final JDA jda, final long responseNumber, final Interaction interaction) {
        super(jda, responseNumber, interaction);
    }

    public UserContextInteractionEvent(final Event jdaEvent, final ContextInteraction<User> interaction) {
        super(jdaEvent, interaction);
    }

    public UserContextInteractionEvent(final net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent jdaEvent) {
        super(jdaEvent, jdaEvent.getInteraction());
    }

    @Override
    public UserContextInteraction getInteraction() {
        return (UserContextInteraction) super.getInteraction();
    }

    @Nullable
    @Override
    public Member getTargetMember() {
        return getInteraction().getTargetMember();
    }

}
