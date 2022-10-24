package net.drawer.event.jda;

import net.drawer.event.Event;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.utils.data.DataObject;
import net.dv8tion.jda.internal.JDAImpl;
import net.dv8tion.jda.internal.handle.SocketHandler;

public class JDAEvent extends Event {

    protected final JDA jda;
    protected final long responseNumber;
    protected final DataObject rawData;

    public JDAEvent(final JDA jda, final long responseNumber) {
        this.jda = jda;
        this.responseNumber = responseNumber;
        this.rawData = this.jda instanceof JDAImpl && ((JDAImpl) this.jda).isEventPassthrough() ? SocketHandler.CURRENT_EVENT.get() : null;
    }

    public JDAEvent(final net.dv8tion.jda.api.events.Event jdaEvent) {
        this(jdaEvent.getJDA(), jdaEvent.getResponseNumber());
    }

    public JDA getJDA() {
        return this.jda;
    }

    public long getResponseNumber() {
        return this.responseNumber;
    }

    public DataObject getRawData() {
        if (this.jda instanceof JDAImpl) {
            if (!((JDAImpl) this.jda).isEventPassthrough())
                throw new IllegalStateException("Event passthrough is not enabled, see JDABuilder#setEventPassthrough(boolean).");
        }
        return this.rawData;
    }

}
