package net.drawer.event.jda.message;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.entities.emoji.EmojiUnion;

import javax.annotation.Nonnull;

public class MessageReactionRemoveEmojiEvent extends MessageEvent {

    protected final MessageReaction reaction;

    public MessageReactionRemoveEmojiEvent(final JDA jda, final long responseNumber, final long messageId, final MessageChannel channel, final MessageReaction reaction) {
        super(jda, responseNumber, messageId, channel);
        this.reaction = reaction;
    }

    public MessageReactionRemoveEmojiEvent(final net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEmojiEvent jdaEvent) {
        super(jdaEvent);
        this.reaction = jdaEvent.getReaction();
    }

    @Nonnull
    public MessageReaction getReaction() {
        return this.reaction;
    }

    @Nonnull
    public EmojiUnion getEmoji() {
        return this.reaction.getEmoji();
    }

}
