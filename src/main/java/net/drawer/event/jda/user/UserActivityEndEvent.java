package net.drawer.event.jda.user;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.user.update.GenericUserPresenceEvent;

import javax.annotation.Nonnull;

public class UserActivityEndEvent extends UserEvent implements GenericUserPresenceEvent {

    protected final Activity oldActivity;
    protected final Member member;

    public UserActivityEndEvent(final JDA jda, final long responseNumber, final Member member, final Activity oldActivity) {
        super(jda, responseNumber, member.getUser());
        this.oldActivity = oldActivity;
        this.member = member;
    }

    public UserActivityEndEvent(final net.dv8tion.jda.api.events.user.UserActivityEndEvent jdaEvent) {
        super(jdaEvent);
        this.oldActivity = jdaEvent.getOldActivity();
        this.member = jdaEvent.getMember();
    }

    @Nonnull
    public Activity getOldActivity() {
        return this.oldActivity;
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
