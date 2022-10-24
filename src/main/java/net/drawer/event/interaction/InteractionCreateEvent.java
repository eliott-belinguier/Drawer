package net.drawer.event.interaction;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.events.interaction.GenericInteractionCreateEvent;
import net.dv8tion.jda.api.interactions.Interaction;

public class InteractionCreateEvent extends InteractionEvent {

    public InteractionCreateEvent(final JDA jda, final long responseNumber, final Interaction interaction) {
        super(jda, responseNumber, interaction);
    }

    public InteractionCreateEvent(final Event jdaEvent, final Interaction interaction) {
        super(jdaEvent, interaction);
    }

    public InteractionCreateEvent(final GenericInteractionCreateEvent jdaEvent) {
        super(jdaEvent, jdaEvent.getInteraction());
    }

}
