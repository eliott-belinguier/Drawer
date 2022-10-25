package net.drawer.event.jda.user;

import net.drawer.event.jda.JDAEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.user.GenericUserEvent;

public class UserEvent extends JDAEvent {

    protected final User user;

    public UserEvent(final JDA jda, final long responseNumber, final User user) {
        super(jda, responseNumber);
        this.user = user;
    }

    public UserEvent(final GenericUserEvent jdaEvent) {
        super(jdaEvent);
        this.user = jdaEvent.getUser();
    }

    public User getUser() {
        return this.user;
    }

}
