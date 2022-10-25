package net.drawer.event.jda.user;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.user.update.GenericUserPresenceEvent;

import javax.annotation.Nonnull;

public class UserUpdateOnlineStatusEvent extends UserUpdateEvent<OnlineStatus> implements GenericUserPresenceEvent {

    public static final String IDENTIFIER = "status";

    protected final Member member;

    public UserUpdateOnlineStatusEvent(final JDA jda, final long responseNumber, final Member member, final OnlineStatus oldOnlineStatus) {
        super(jda, responseNumber, member.getUser(), oldOnlineStatus, member.getOnlineStatus(), IDENTIFIER);
        this.member = member;
    }

    public UserUpdateOnlineStatusEvent(final net.dv8tion.jda.api.events.user.update.UserUpdateOnlineStatusEvent jdaEvent) {
        super(jdaEvent);
        this.member = jdaEvent.getMember();
    }

    @Nonnull
    @Override
    public Guild getGuild() {
        return this.member.getGuild();
    }

    @Nonnull
    @Override
    public Member getMember() {
        return this.member;
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
