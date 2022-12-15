package net.drawer.event.jda.channel.forum.update;

import net.drawer.event.jda.channel.forum.ForumTagEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.concrete.ForumChannel;
import net.dv8tion.jda.api.entities.channel.forums.ForumTag;
import net.dv8tion.jda.api.events.UpdateEvent;
import net.dv8tion.jda.api.events.channel.forum.update.GenericForumTagUpdateEvent;

import javax.annotation.Nonnull;

public class ForumTagUpdateEvent<T> extends ForumTagEvent implements UpdateEvent<ForumTag, T>
{
private final T previous;
private final T next;
private final String identifier;

public ForumTagUpdateEvent(@Nonnull JDA api, long responseNumber, @Nonnull ForumChannel channel, @Nonnull ForumTag tag,
                           T previous, T next, @Nonnull String identifier)
        {
        super(api, responseNumber, channel, tag);
        this.previous = previous;
        this.next = next;
        this.identifier = identifier;
        }

    public ForumTagUpdateEvent(GenericForumTagUpdateEvent<T> event) {
        super(event);
        this.previous = event.getOldValue();
        this.next = event.getNewValue();
        this.identifier = event.getPropertyIdentifier();
    }

@Nonnull
@Override
public ForumTag getEntity()
        {
        return getTag();
        }

@Override
public T getOldValue()
        {
        return previous;
        }

@Override
public T getNewValue()
        {
        return next;
        }

@Nonnull
@Override
public String getPropertyIdentifier()
        {
        return identifier;
        }
        }