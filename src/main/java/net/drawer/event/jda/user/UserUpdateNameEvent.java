package net.drawer.event.jda.user;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.User;

public class UserUpdateNameEvent extends UserUpdateEvent<String> {

    public static final String IDENTIFIER = "name";

    public UserUpdateNameEvent(final JDA jda, final long responseNumber, final User user, final String oldName) {
        super(jda, responseNumber, user, oldName, user.getName(), IDENTIFIER);
    }

    public UserUpdateNameEvent(final net.dv8tion.jda.api.events.user.update.UserUpdateNameEvent jdaEvent) {
        super(jdaEvent);
    }

}
