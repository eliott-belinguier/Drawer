package net.drawer.event.jda.self;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.self.GenericSelfUpdateEvent;

import javax.annotation.Nonnull;

public class SelfUpdateMFAEvent extends SelfUpdateEvent<Boolean>
{
    public static final String IDENTIFIER = "mfa_enabled";

    public SelfUpdateMFAEvent(@Nonnull JDA api, long responseNumber, boolean wasMfaEnabled)
    {
        super(api, responseNumber, wasMfaEnabled, !wasMfaEnabled, IDENTIFIER);
    }

    public SelfUpdateMFAEvent(GenericSelfUpdateEvent event) {
        super(event);
    }

    public boolean wasMfaEnabled()
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