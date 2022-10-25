package net.drawer.event.jda.user;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.user.update.GenericUserPresenceEvent;

import javax.annotation.Nonnull;

public class UserActivityStartEvent extends UserEvent implements GenericUserPresenceEvent {

    protected final Activity newActivity;
    protected final Member member;

    public UserActivityStartEvent(final JDA jda, final long responseNumber, final Member member, final Activity newActivity) {
        super(jda, responseNumber, member.getUser());
        this.newActivity = newActivity;
        this.member = member;
    }

    public UserActivityStartEvent(final net.dv8tion.jda.api.events.user.UserActivityStartEvent jdaEvent) {
        super(jdaEvent);
        this.newActivity = jdaEvent.getNewActivity();
        this.member = jdaEvent.getMember();
    }

    public Activity getNewActivity() {
        return this.newActivity;
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

}
