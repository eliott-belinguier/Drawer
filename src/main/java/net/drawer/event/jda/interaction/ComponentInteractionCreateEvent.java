package net.drawer.event.jda.interaction;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.events.interaction.component.GenericComponentInteractionCreateEvent;
import net.dv8tion.jda.api.interactions.components.ComponentInteraction;

public class ComponentInteractionCreateEvent extends ComponentInteractionEvent {

    public ComponentInteractionCreateEvent(final JDA jda, final long responseNumber, final ComponentInteraction interaction) {
        super(jda, responseNumber, interaction);
    }

    public ComponentInteractionCreateEvent(final Event jdaEvent, final ComponentInteraction interaction) {
        super(jdaEvent, interaction);
    }

    public ComponentInteractionCreateEvent(final GenericComponentInteractionCreateEvent jdaEvent) {
        super(jdaEvent, jdaEvent.getInteraction());
    }

}
