package net.drawer.event.jda.self;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.self.GenericSelfUpdateEvent;

import javax.annotation.Nonnull;

public class SelfUpdateVerifiedEvent extends SelfUpdateEvent<Boolean>
{
    public static final String IDENTIFIER = "verified";

    public SelfUpdateVerifiedEvent(@Nonnull JDA api, long responseNumber, boolean wasVerified)
    {
        super(api, responseNumber, wasVerified, !wasVerified, IDENTIFIER);
    }

    public SelfUpdateVerifiedEvent(GenericSelfUpdateEvent event) {
        super(event);
    }


    public boolean wasVerified()
    {
        return getOldValue();
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