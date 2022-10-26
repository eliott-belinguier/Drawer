package net.drawer.event.jda.message;

import net.drawer.event.jda.JDAEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.middleman.GuildMessageChannel;
import net.dv8tion.jda.api.entities.channel.unions.GuildMessageChannelUnion;

import javax.annotation.Nonnull;
import java.util.List;

public class MessageBulkDeleteEvent extends JDAEvent {

    protected final GuildMessageChannel channel;
    protected final List<String> messageIds;

    public MessageBulkDeleteEvent(final JDA jda, final long responseNumber, final GuildMessageChannel channel, final List<String> messageIds) {
        super(jda, responseNumber);
        this.channel = channel;
        this.messageIds = messageIds;
    }

    public MessageBulkDeleteEvent(final net.dv8tion.jda.api.events.message.MessageBulkDeleteEvent jdaEvent) {
        super(jdaEvent);
        this.channel = jdaEvent.getChannel();
        this.messageIds = jdaEvent.getMessageIds();
    }

    @Nonnull
    public GuildMessageChannelUnion getChannel() {
        return (GuildMessageChannelUnion) this.channel;
    }

    @Nonnull
    public Guild getGuild() {
        return this.channel.getGuild();
    }

    @Nonnull
    public List<String> getMessageIds() {
        return this.messageIds;
    }

}
