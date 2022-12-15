package net.drawer.event.jda.channel.forum;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.concrete.ForumChannel;
import net.dv8tion.jda.api.entities.channel.forums.ForumTag;
import net.dv8tion.jda.api.events.channel.forum.GenericForumTagEvent;

import javax.annotation.Nonnull;

public class ForumTagRemoveEvent extends ForumTagEvent
{
    public ForumTagRemoveEvent(@Nonnull JDA api, long responseNumber, @Nonnull ForumChannel channel, @Nonnull ForumTag tag)
    {
        super(api, responseNumber, channel, tag);
    }

    public ForumTagRemoveEvent(GenericForumTagEvent event) {
        super(event);
    }
}