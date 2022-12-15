package net.drawer.event.jda.channel.forum.update;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.concrete.ForumChannel;
import net.dv8tion.jda.api.entities.channel.forums.ForumTag;
import net.dv8tion.jda.api.events.channel.forum.update.GenericForumTagUpdateEvent;

import javax.annotation.Nonnull;

public class ForumTagUpdateModeratedEvent extends ForumTagUpdateEvent<Boolean>
{
    public static final String IDENTIFIER = "moderated";

    public ForumTagUpdateModeratedEvent(@Nonnull JDA api, long responseNumber, @Nonnull ForumChannel channel, @Nonnull ForumTag tag, boolean previous)
    {
        super(api, responseNumber, channel, tag, previous, tag.isModerated(), IDENTIFIER);
    }


    public ForumTagUpdateModeratedEvent(GenericForumTagUpdateEvent<Boolean> event) {
        super(event);
    }

    @Nonnull
    @Override
    public Boolean getOldValue()
    {
        return super.getOldValue();
    }

    @Nonnull
    @Override
    public Boolean getNewValue()
    {
        return super.getNewValue();
    }
}