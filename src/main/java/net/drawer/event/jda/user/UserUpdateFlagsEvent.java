package net.drawer.event.jda.user;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.User;

import javax.annotation.Nonnull;
import java.util.EnumSet;

public class UserUpdateFlagsEvent extends UserUpdateEvent<EnumSet<User.UserFlag>> {

    public static final String IDENTIFIER = "public_flags";

    public UserUpdateFlagsEvent(final JDA jda, final long responseNumber, final User user, final EnumSet<User.UserFlag> oldFlags) {
        super(jda, responseNumber, user, oldFlags, user.getFlags(), IDENTIFIER);
    }

    public UserUpdateFlagsEvent(final net.dv8tion.jda.api.events.user.update.UserUpdateFlagsEvent jdaEvent) {
        super(jdaEvent);
    }

    @Nonnull
    public EnumSet<User.UserFlag> getOldFlags() {
        return this.previous;
    }

    public int getOldFlagsRaw() {
        return User.UserFlag.getRaw(this.previous);
    }

    @Nonnull
    public EnumSet<User.UserFlag> getNewFlags() {
        return this.next;
    }

    public int getNewFlagsRaw() {
        return User.UserFlag.getRaw(this.next);
    }

}
