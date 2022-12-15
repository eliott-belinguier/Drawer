package net.drawer.event.jda.channel.forum.update;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.concrete.ForumChannel;
import net.dv8tion.jda.api.entities.channel.forums.ForumTag;
import net.dv8tion.jda.api.entities.emoji.EmojiUnion;
import net.dv8tion.jda.api.events.channel.forum.update.GenericForumTagUpdateEvent;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ForumTagUpdateEmojiEvent extends ForumTagUpdateEvent<EmojiUnion>
{
    public static final String IDENTIFIER = "emoji";

    public ForumTagUpdateEmojiEvent(@Nonnull JDA api, long responseNumber, @Nonnull ForumChannel channel, @Nonnull ForumTag tag, @Nullable EmojiUnion previous)
    {
        super(api, responseNumber, channel, tag, previous, tag.getEmoji(), IDENTIFIER);
    }

    public ForumTagUpdateEmojiEvent(GenericForumTagUpdateEvent<EmojiUnion> jdaEvent) {
        super(jdaEvent);
    }

    @Nullable
    public EmojiUnion getOldEmoji()
    {
        return getOldValue();
    }


    @Nullable
    public EmojiUnion getNewEmoji()
    {
        return getNewValue();
    }
}