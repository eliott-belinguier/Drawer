package net.drawer.event.jda.channel;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.Channel;
import net.dv8tion.jda.api.events.channel.GenericChannelEvent;

import javax.annotation.Nonnull;

public class  ChannelCreateEvent extends ChannelEvent
{
    public ChannelCreateEvent(@Nonnull JDA api, long responseNumber, Channel channel)
    {
        super(api, responseNumber, channel);
    }

    public ChannelCreateEvent(GenericChannelEvent event) {
        super(event);
    }
}