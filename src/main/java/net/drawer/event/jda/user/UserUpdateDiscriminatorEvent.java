package net.drawer.event.jda.user;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.User;

import javax.annotation.Nonnull;

public class UserUpdateDiscriminatorEvent extends UserUpdateEvent<String> {

    public static final String IDENTIFIER = "discriminator";

    public UserUpdateDiscriminatorEvent(final JDA jda, final long responseNumber, final User user, final String oldDiscriminator) {
        super(jda, responseNumber, user, oldDiscriminator, user.getDiscriminator(), IDENTIFIER);
    }

    public UserUpdateDiscriminatorEvent(final net.dv8tion.jda.api.events.user.update.UserUpdateDiscriminatorEvent jdaEvent) {
        super(jdaEvent);
    }

    @Nonnull
    public String getOldDiscriminator() {
        return this.previous;
    }

    @Nonnull
    public String getNewDiscriminator() {
        return this.next;
    }

}
