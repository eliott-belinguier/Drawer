package net.drawer.event.jda.self;

import net.drawer.event.jda.JDAEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.SelfUser;
import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.events.UpdateEvent;
import net.dv8tion.jda.api.events.self.GenericSelfUpdateEvent;
import net.dv8tion.jda.api.events.self.SelfUpdateAvatarEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SelfUpdateEvent<T> extends JDAEvent implements UpdateEvent<SelfUser, T> {

    protected final T previous;
    protected final T next;
    protected final String identifier;

    public SelfUpdateEvent(JDA jda, long responseNumber, T previous, T next, String identifier) {
        super(jda, responseNumber);
        this.previous = previous;
        this.next = next;
        this.identifier = identifier;
    }

    public SelfUpdateEvent(final GenericSelfUpdateEvent<T> jdaEvent)  {
        super(jdaEvent);
        this.previous = jdaEvent.getOldValue();
        this.next = jdaEvent.getNewValue();
        this.identifier = jdaEvent.getPropertyIdentifier();

    }


    @NotNull
    @Override
    public Class<SelfUser> getEntityType() {
        return UpdateEvent.super.getEntityType();
    }

    @NotNull
    @Override
    public String getPropertyIdentifier() {
        return identifier;
    }

    @NotNull
    @Override
    public SelfUser getEntity() {
        return super.jda.getSelfUser();
    }

    @Nullable
    @Override
    public T getOldValue() {
        return previous;
    }

    @Nullable
    @Override
    public T getNewValue() {
        return next;
    }
}
