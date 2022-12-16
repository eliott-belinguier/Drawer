package net.drawer.event.jda.interaction.command;

import net.drawer.event.jda.interaction.InteractionEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.events.interaction.GenericAutoCompleteInteractionEvent;
import net.dv8tion.jda.api.interactions.Interaction;
import net.dv8tion.jda.api.interactions.callbacks.IAutoCompleteCallback;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.requests.restaction.interactions.AutoCompleteCallbackAction;

import javax.annotation.Nonnull;
import java.util.Collection;

public class AutoCompleteInteractionEvent extends InteractionEvent implements IAutoCompleteCallback {

    public AutoCompleteInteractionEvent(final JDA jda, final long responseNumber, final Interaction interaction) {
        super(jda, responseNumber, interaction);
    }

    public AutoCompleteInteractionEvent(final Event jdaEvent, final Interaction interaction) {
        super(jdaEvent, interaction);
    }

    public AutoCompleteInteractionEvent(final GenericAutoCompleteInteractionEvent jdaEvent) {
        super(jdaEvent, jdaEvent.getInteraction());
    }

    @Nonnull
    @Override
    public IAutoCompleteCallback getInteraction() {
        return (IAutoCompleteCallback) super.getInteraction();
    }

    @Nonnull
    @Override
    public AutoCompleteCallbackAction replyChoices(@Nonnull Collection<Command.Choice> choices) {
        return getInteraction().replyChoices(choices);
    }

}
