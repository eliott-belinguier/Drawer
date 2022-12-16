package net.drawer.event.jda.interaction.command;

import net.drawer.event.jda.interaction.InteractionEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.events.interaction.command.GenericCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.Interaction;
import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.CommandInteraction;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.components.Modal;
import net.dv8tion.jda.api.requests.restaction.interactions.ModalCallbackAction;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyCallbackAction;

import javax.annotation.Nonnull;
import java.util.List;

public class CommandInteractionEvent extends InteractionEvent implements CommandInteraction {

    public CommandInteractionEvent(final JDA jda, final long responseNumber, final Interaction interaction) {
        super(jda, responseNumber, interaction);
    }

    public CommandInteractionEvent(final Event jdaEvent, final Interaction interaction) {
        super(jdaEvent, interaction);
    }

    public CommandInteractionEvent(final GenericCommandInteractionEvent jdaEvent) {
        super(jdaEvent, jdaEvent.getInteraction());
    }

    @Override
    public CommandInteraction getInteraction() {
        return (CommandInteraction) super.getInteraction();
    }

    @Nonnull
    @Override
    public ModalCallbackAction replyModal(@Nonnull Modal modal) {
        return getInteraction().replyModal(modal);
    }

    @Nonnull
    @Override
    public ReplyCallbackAction deferReply() {
        return getInteraction().deferReply();
    }

    @Nonnull
    @Override
    public InteractionHook getHook() {
        return getInteraction().getHook();
    }

    @Nonnull
    @Override
    public Command.Type getCommandType() {
        return getInteraction().getCommandType();
    }

    @Nonnull
    @Override
    public String getName() {
        return getInteraction().getName();
    }

    @Nonnull
    @Override
    public String getSubcommandName() {
        return getInteraction().getSubcommandName();
    }

    @Nonnull
    @Override
    public String getSubcommandGroup() {
        return getInteraction().getSubcommandGroup();
    }

    @Override
    public long getCommandIdLong() {
        return getInteraction().getCommandIdLong();
    }

    @Override
    public boolean isGuildCommand() {
        return getInteraction().isGuildCommand();
    }

    @Nonnull
    @Override
    public List<OptionMapping> getOptions() {
        return getInteraction().getOptions();
    }

}
