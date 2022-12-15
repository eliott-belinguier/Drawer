package net.drawer.event.jda.channel.forum;

import net.drawer.event.jda.JDAEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.concrete.ForumChannel;
import net.dv8tion.jda.api.entities.channel.forums.ForumTag;
import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.events.channel.forum.GenericForumTagEvent;

import javax.annotation.Nonnull;

public class ForumTagEvent extends JDAEvent {

    protected final ForumChannel channel;
    protected final ForumTag tag;

    public ForumTagEvent(@Nonnull JDA api, long responseNumber, @Nonnull ForumChannel channel, @Nonnull ForumTag tag)
    {
        super(api, responseNumber);
        this.channel = channel;
        this.tag = tag;
    }

    public ForumTagEvent(GenericForumTagEvent event){
        super(event);
        this.channel = event.getChannel();
        this.tag = event.getTag();
    }

    @Nonnull
    public ForumChannel getChannel()
    {
        return channel;
    }


    @Nonnull
    public ForumTag getTag()
    {
        return tag;
    }
}