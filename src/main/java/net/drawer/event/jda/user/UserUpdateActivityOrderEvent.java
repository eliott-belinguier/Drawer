package net.drawer.event.jda.user;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.user.update.GenericUserPresenceEvent;

import javax.annotation.Nonnull;
import java.util.List;

public class UserUpdateActivityOrderEvent extends UserUpdateEvent<List<Activity>> implements GenericUserPresenceEvent {

    public static final String IDENTIFIER = "activity_order";

    protected final Member member;

    public UserUpdateActivityOrderEvent(final JDA jda, final long responseNumber, final Member member, final List<Activity> previous) {
        super(jda, responseNumber, member.getUser(), previous, member.getActivities(), IDENTIFIER);
        this.member = member;
    }

    public UserUpdateActivityOrderEvent(final net.dv8tion.jda.api.events.user.update.UserUpdateActivityOrderEvent jdaEvent) {
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
    public List<Activity> getOldActivities() {
        return this.previous;
    }

    @Nonnull
    public List<Activity> getNewActivities() {
        return this.next;
    }

}
