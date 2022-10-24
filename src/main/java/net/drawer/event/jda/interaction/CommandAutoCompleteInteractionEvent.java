package net.drawer.event.jda.interaction;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.interactions.AutoCompleteQuery;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.CommandAutoCompleteInteraction;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.requests.restaction.interactions.AutoCompleteCallbackAction;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.List;

public class CommandAutoCompleteInteractionEvent extends AutoCompleteInteractionEvent implements CommandAutoCompleteInteraction {

    protected final CommandAutoCompleteInteraction commandAutoCompleteInteraction;

    public CommandAutoCompleteInteractionEvent(final JDA jda, final long responseNumber, final CommandAutoCompleteInteraction commandAutoCompleteInteraction) {
        super(jda, responseNumber, commandAutoCompleteInteraction);
        this.commandAutoCompleteInteraction = commandAutoCompleteInteraction;
    }

    public CommandAutoCompleteInteractionEvent(final Event jdaEvent, final CommandAutoCompleteInteraction commandAutoCompleteInteraction) {
        super(jdaEvent, commandAutoCompleteInteraction);
        this.commandAutoCompleteInteraction = commandAutoCompleteInteraction;
    }

    public CommandAutoCompleteInteractionEvent(final net.dv8tion.jda.api.events.interaction.command.CommandAutoCompleteInteractionEvent jdaEvent) {
        this(jdaEvent, jdaEvent.getInteraction());
    }

    @Nonnull
    @Override
    public CommandAutoCompleteInteraction getInteraction() {
        return this.commandAutoCompleteInteraction;
    }

    @Nonnull
    @Override
    public AutoCompleteQuery getFocusedOption() {
        return this.commandAutoCompleteInteraction.getFocusedOption();
    }

    @Nonnull
    @Override
    public Command.Type getCommandType() {
        return this.commandAutoCompleteInteraction.getCommandType();
    }

    @NotNull
    @Override
    public String getName() {
        return this.commandAutoCompleteInteraction.getName();
    }

    @Nonnull
    @Override
    public String getSubcommandName() {
        return this.commandAutoCompleteInteraction.getSubcommandName();
    }

    @Nonnull
    @Override
    public String getSubcommandGroup() {
        return this.commandAutoCompleteInteraction.getSubcommandGroup();
    }

    @Override
    public long getCommandIdLong() {
        return this.commandAutoCompleteInteraction.getCommandIdLong();
    }

    @Override
    public boolean isGuildCommand() {
        return this.commandAutoCompleteInteraction.isGuildCommand();
    }

    @Nonnull
    @Override
    public List<OptionMapping> getOptions() {
        return this.commandAutoCompleteInteraction.getOptions();
    }

    @Nonnull
    @Override
    public AutoCompleteCallbackAction replyChoices(@Nonnull Collection<Command.Choice> choices) {
        return this.commandAutoCompleteInteraction.replyChoices(choices);
    }

    @Nonnull
    @Override
    public MessageChannelUnion getChannel() {
        return this.commandAutoCompleteInteraction.getChannel();
    }

}
