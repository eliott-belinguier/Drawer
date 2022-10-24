package net.drawer.event.jda.interaction;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.interactions.ModalInteraction;
import net.dv8tion.jda.api.interactions.modals.ModalMapping;
import net.dv8tion.jda.api.requests.restaction.interactions.MessageEditCallbackAction;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyCallbackAction;

import javax.annotation.Nonnull;
import java.util.List;

public class ModalInteractionEvent extends InteractionEvent implements ModalInteraction {

    protected final ModalInteraction modalInteraction;

    public ModalInteractionEvent(final JDA jda, final long responseNumber, final ModalInteraction modalInteraction) {
        super(jda, responseNumber, modalInteraction);
        this.modalInteraction = modalInteraction;
    }

    public ModalInteractionEvent(final Event jdaEvent, final ModalInteraction modalInteraction) {
        super(jdaEvent, modalInteraction);
        this.modalInteraction = modalInteraction;
    }

    public ModalInteractionEvent(final net.dv8tion.jda.api.events.interaction.ModalInteractionEvent jdaEvent) {
        this(jdaEvent, jdaEvent.getInteraction());
    }

    @Nonnull
    @Override
    public ModalInteraction getInteraction() {
        return this.modalInteraction;
    }

    @Nonnull
    @Override
    public String getModalId() {
        return this.modalInteraction.getModalId();
    }

    @Nonnull
    @Override
    public List<ModalMapping> getValues() {
        return this.modalInteraction.getValues();
    }

    @Nonnull
    @Override
    public Message getMessage() {
        return this.modalInteraction.getMessage();
    }

    @Nonnull
    @Override
    public ReplyCallbackAction deferReply() {
        return this.modalInteraction.deferReply();
    }

    @Nonnull
    @Override
    public InteractionHook getHook() {
        return this.modalInteraction.getHook();
    }

    @Nonnull
    @Override
    public MessageEditCallbackAction deferEdit() {
        return this.modalInteraction.deferEdit();
    }

    @Nonnull
    @Override
    public MessageChannelUnion getChannel() {
        return this.modalInteraction.getChannel();
    }

}
