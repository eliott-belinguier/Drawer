package net.drawer.event.jda.interaction;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.interactions.Interaction;
import net.dv8tion.jda.api.interactions.commands.context.ContextInteraction;
import net.dv8tion.jda.api.interactions.commands.context.MessageContextInteraction;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class MessageContextInteractionEvent extends ContextInteractionEvent<Message> {

    public MessageContextInteractionEvent(final JDA jda, final long responseNumber, final Interaction interaction) {
        super(jda, responseNumber, interaction);
    }

    public MessageContextInteractionEvent(final Event jdaEvent, final ContextInteraction<Message> interaction) {
        super(jdaEvent, interaction);
    }

    public MessageContextInteractionEvent(final net.dv8tion.jda.api.events.interaction.command.MessageContextInteractionEvent jdaEvent) {
        super(jdaEvent, jdaEvent.getInteraction());
    }

    @Nonnull
    @Override
    public MessageContextInteraction getInteraction() {
        return (MessageContextInteraction) super.getInteraction();
    }

    @Nullable
    @Override
    public MessageChannelUnion getChannel() {
        return (MessageChannelUnion) super.getChannel();
    }

}
