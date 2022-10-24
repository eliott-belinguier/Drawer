package net.drawer.event.jda.interaction;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;

import javax.annotation.Nonnull;

public class SlashCommandInteractionEvent extends CommandInteractionEvent implements SlashCommandInteraction {

    private final SlashCommandInteraction interaction;

    public SlashCommandInteractionEvent(final JDA jda, final long responseNumber, final SlashCommandInteraction interaction) {
        super(jda, responseNumber, interaction);
        this.interaction = interaction;
    }

    public SlashCommandInteractionEvent(final Event jdaEvent, final SlashCommandInteraction interaction) {
        super(jdaEvent, interaction);
        this.interaction = interaction;
    }

    public SlashCommandInteractionEvent(final net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent jdaEvent) {
        this(jdaEvent, jdaEvent.getInteraction());
    }

    @Override
    public SlashCommandInteraction getInteraction() {
        return this.interaction;
    }

    @Nonnull
    @Override
    public MessageChannelUnion getChannel() {
        return this.interaction.getChannel();
    }

}
