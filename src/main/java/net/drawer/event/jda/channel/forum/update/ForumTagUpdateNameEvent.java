package net.drawer.event.jda.channel.forum.update;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.concrete.ForumChannel;
import net.dv8tion.jda.api.entities.channel.forums.ForumTag;
import net.dv8tion.jda.api.events.channel.forum.update.GenericForumTagUpdateEvent;

import javax.annotation.Nonnull;

public class ForumTagUpdateNameEvent extends ForumTagUpdateEvent<String>
{
    public static final String IDENTIFIER = "name";

    public ForumTagUpdateNameEvent(@Nonnull JDA api, long responseNumber, @Nonnull ForumChannel channel, @Nonnull ForumTag tag, @Nonnull String previous)
    {
        super(api, responseNumber, channel, tag, previous, tag.getName(), IDENTIFIER);
    }

    public ForumTagUpdateNameEvent(GenericForumTagUpdateEvent<String> event) {
        super(event);
    }

    @Nonnull
    public String getOldName()
    {
        return getOldValue();
    }

    @Nonnull
    public String getNewName()
    {
        return getNewValue();
    }

    @Nonnull
    @Override
    public String getOldValue()
    {
        return super.getOldValue();
    }

    @Nonnull
    @Override
    public String getNewValue()
    {
        return super.getNewValue();
    }
}