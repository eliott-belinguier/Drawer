package net.drawer.event.jda.user;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.UpdateEvent;
import net.dv8tion.jda.api.events.user.update.GenericUserUpdateEvent;

import javax.annotation.Nonnull;

public class UserUpdateEvent<T> extends UserEvent implements UpdateEvent<User, T> {

    protected final T previous;
    protected final T next;
    protected final String identifier;

    public UserUpdateEvent(final JDA jda, final long responseNumber, final User user, final T previous, final T next, String identifier) {
        super(jda, responseNumber, user);
        this.previous = previous;
        this.next = next;
        this.identifier = identifier;
    }

    public UserUpdateEvent(final GenericUserUpdateEvent<T> jdaEvent) {
        super(jdaEvent);
        this.previous = jdaEvent.getOldValue();
        this.next = jdaEvent.getNewValue();
        this.identifier = jdaEvent.getPropertyIdentifier();
    }

    @Nonnull
    @Override
    public User getEntity() {
        return this.user;
    }

    @Nonnull
    @Override
    public String getPropertyIdentifier() {
        return this.identifier;
    }

    @Nonnull
    @Override
    public T getOldValue() {
        return this.previous;
    }

    @Nonnull
    @Override
    public T getNewValue() {
        return this.next;
    }

}
