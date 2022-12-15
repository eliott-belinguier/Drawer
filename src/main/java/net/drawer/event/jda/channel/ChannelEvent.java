package net.drawer.event.jda.channel;

import net.drawer.event.jda.JDAEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.Channel;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.entities.channel.middleman.GuildChannel;
import net.dv8tion.jda.api.entities.channel.unions.ChannelUnion;
import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.events.channel.GenericChannelEvent;

import javax.annotation.Nonnull;

public class ChannelEvent extends JDAEvent {

    protected final Channel channel;
    public ChannelEvent(JDA jda, long responseNumber, Channel channel) {
        super(jda, responseNumber);
        this.channel = channel;
    }

    public ChannelEvent(GenericChannelEvent jdaEvent) {
        super(jdaEvent);
        this.channel = jdaEvent.getChannel();
    }

    public boolean isFromGuild()
    {
        return getChannelType().isGuild();
    }

    @Nonnull
    public ChannelType getChannelType()
    {
        return this.channel.getType();
    }

    public boolean isFromType(ChannelType type)
    {
        return getChannelType() == type;
    }

    @Nonnull
    public ChannelUnion getChannel()
    {
        return (ChannelUnion) this.channel;
    }

    @Nonnull
    public Guild getGuild()
    {
        if (!isFromGuild())
            throw new IllegalStateException("This channel event did not happen in a guild");
        return ((GuildChannel) channel).getGuild();
    }
}
