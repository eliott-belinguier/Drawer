package net.drawer.event.jda.user;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Member;

import javax.annotation.Nonnull;

public class UserUpdateOnlineStatusEvent extends UserUpdateEvent<OnlineStatus> {

    public static final String IDENTIFIER = "status";

    public UserUpdateOnlineStatusEvent(final JDA jda, final long responseNumber, final Member member, final OnlineStatus oldOnlineStatus) {
        super(jda, responseNumber, member.getUser(), oldOnlineStatus, member.getOnlineStatus(), IDENTIFIER);
    }

    public UserUpdateOnlineStatusEvent(final net.dv8tion.jda.api.events.user.update.UserUpdateOnlineStatusEvent jdaEvent) {
        super(jdaEvent);
    }

    @Nonnull
    public OnlineStatus getOldOnlineStatus() {
        return this.previous;
    }

    @Nonnull
    public OnlineStatus getNewOnlineStatus() {
        return this.next;
    }

}
