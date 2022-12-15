package net.drawer.event.jda.self;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.self.GenericSelfUpdateEvent;

import javax.annotation.Nonnull;

public class SelfUpdateNameEvent extends SelfUpdateEvent<String>
{
    public static final String IDENTIFIER = "name";

    public SelfUpdateNameEvent(@Nonnull JDA api, long responseNumber, @Nonnull String oldName)
    {
        super(api, responseNumber, oldName, api.getSelfUser().getName(), IDENTIFIER);
    }

    public SelfUpdateNameEvent(GenericSelfUpdateEvent event) {
        super(event);
    }

    /**
     * The old name
     *
     * @return The old name
     */
    @Nonnull
    public String getOldName()
    {
        return getOldValue();
    }

    /**
     * The new name
     *
     * @return The new name
     */
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