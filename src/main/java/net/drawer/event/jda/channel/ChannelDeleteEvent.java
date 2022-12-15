package net.drawer.event.jda.channel;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.Channel;
import net.dv8tion.jda.api.events.channel.GenericChannelEvent;

import javax.annotation.Nonnull;

public class ChannelDeleteEvent extends ChannelEvent
{
    public ChannelDeleteEvent(@Nonnull JDA api, long responseNumber, Channel channel)
    {
        super(api, responseNumber, channel);
    }

    public ChannelDeleteEvent(GenericChannelEvent event) {
        super(event);
    }
}