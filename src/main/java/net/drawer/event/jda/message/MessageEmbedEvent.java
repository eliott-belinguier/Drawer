package net.drawer.event.jda.message;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;

import javax.annotation.Nonnull;
import java.util.List;

public class MessageEmbedEvent extends MessageEvent {

    protected final List<MessageEmbed> embeds;

    public MessageEmbedEvent(final JDA jda, final long responseNumber, final long messageId, final MessageChannel channel, final List<MessageEmbed> embeds) {
        super(jda, responseNumber, messageId, channel);
        this.embeds = embeds;
    }

    public MessageEmbedEvent(final net.dv8tion.jda.api.events.message.MessageEmbedEvent jdaEvent) {
        super(jdaEvent);
        this.embeds = jdaEvent.getMessageEmbeds();
    }

    @Nonnull
    public List<MessageEmbed> getMessageEmbeds() {
        return this.embeds;
    }

}
