package net.drawer.event.jda.interaction;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.interactions.components.ActionComponent;
import net.dv8tion.jda.api.interactions.components.Component;
import net.dv8tion.jda.api.interactions.components.ComponentInteraction;
import net.dv8tion.jda.api.interactions.components.Modal;
import net.dv8tion.jda.api.requests.restaction.interactions.MessageEditCallbackAction;
import net.dv8tion.jda.api.requests.restaction.interactions.ModalCallbackAction;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyCallbackAction;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ComponentInteractionEvent extends InteractionEvent implements ComponentInteraction {

    protected final ComponentInteraction interaction;

    public ComponentInteractionEvent(final JDA jda, final long responseNumber, final ComponentInteraction interaction) {
        super(jda, responseNumber, interaction);
        this.interaction = interaction;
    }

    public ComponentInteractionEvent(final Event jdaEvent, final ComponentInteraction interaction) {
        super(jdaEvent, interaction);
        this.interaction = interaction;
    }

    @Nonnull
    @Override
    public ComponentInteraction getInteraction() {
        return this.interaction;
    }

    @Nullable
    @Override
    public MessageChannelUnion getChannel() {
        return (MessageChannelUnion) super.getChannel();
    }

    @NotNull
    @Override
    public String getComponentId() {
        return this.interaction.getComponentId();
    }

    @NotNull
    @Override
    public ActionComponent getComponent() {
        return this.interaction.getComponent();
    }

    @NotNull
    @Override
    public Message getMessage() {
        return this.interaction.getMessage();
    }

    @Override
    public long getMessageIdLong() {
        return this.interaction.getMessageIdLong();
    }

    @NotNull
    @Override
    public Component.Type getComponentType() {
        return this.interaction.getComponentType();
    }

    @NotNull
    @Override
    public MessageEditCallbackAction deferEdit() {
        return this.interaction.deferEdit();
    }

    @NotNull
    @Override
    public InteractionHook getHook() {
        return this.interaction.getHook();
    }

    @NotNull
    @Override
    public ReplyCallbackAction deferReply() {
        return this.interaction.deferReply();
    }

    @NotNull
    @Override
    public ModalCallbackAction replyModal(@NotNull Modal modal) {
        return this.interaction.replyModal(modal);
    }

}