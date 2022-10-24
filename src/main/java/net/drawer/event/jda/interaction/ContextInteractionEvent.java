package net.drawer.event.jda.interaction;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.events.interaction.command.GenericContextInteractionEvent;
import net.dv8tion.jda.api.interactions.Interaction;
import net.dv8tion.jda.api.interactions.commands.context.ContextInteraction;

import javax.annotation.Nonnull;

public class ContextInteractionEvent<T> extends CommandInteractionEvent implements ContextInteraction<T> {

    public ContextInteractionEvent(final JDA jda, final long responseNumber, final Interaction interaction) {
        super(jda, responseNumber, interaction);
    }

    public ContextInteractionEvent(final Event jdaEvent, final ContextInteraction<T> interaction) {
        super(jdaEvent, interaction);
    }

    public ContextInteractionEvent(final GenericContextInteractionEvent<T> jdaEvent) {
        super(jdaEvent, jdaEvent.getInteraction());
    }

    @Override
    public ContextInteraction<T> getInteraction() {
        return (ContextInteraction<T>) super.interaction;
    }

    @Nonnull
    @Override
    public ContextTarget getTargetType() {
        return getInteraction().getTargetType();
    }

    @Nonnull
    @Override
    public T getTarget() {
        return getInteraction().getTarget();
    }

}
