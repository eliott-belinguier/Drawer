package net.drawer.event.interaction;

import net.drawer.event.jda.JDAEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.Channel;
import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.interactions.DiscordLocale;
import net.dv8tion.jda.api.interactions.Interaction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class InteractionEvent extends JDAEvent implements Interaction {

    protected final Interaction interaction;

    public InteractionEvent(final JDA jda, final long responseNumber, final Interaction interaction) {
        super(jda, responseNumber);
        this.interaction = interaction;
    }

    public InteractionEvent(final Event jdaEvent, final Interaction interaction) {
        super(jdaEvent);
        this.interaction = interaction;
    }

    public Interaction getInteraction() {
        return this.interaction;
    }

    @Override
    public int getTypeRaw() {
        return this.interaction.getTypeRaw();
    }

    @NotNull
    @Override
    public String getToken() {
        return this.interaction.getToken();
    }

    @Nullable
    @Override
    public Guild getGuild() {
        return this.interaction.getGuild();
    }

    @NotNull
    @Override
    public User getUser() {
        return this.interaction.getUser();
    }

    @Nullable
    @Override
    public Member getMember() {
        return this.interaction.getMember();
    }

    @Override
    public boolean isAcknowledged() {
        return this.interaction.isAcknowledged();
    }

    @Nullable
    @Override
    public Channel getChannel() {
        return this.interaction.getChannel();
    }

    @NotNull
    @Override
    public DiscordLocale getUserLocale() {
        return this.interaction.getUserLocale();
    }

    @Override
    public long getIdLong() {
        return this.interaction.getIdLong();
    }
}

