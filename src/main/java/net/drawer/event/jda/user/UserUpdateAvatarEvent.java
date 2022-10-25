package net.drawer.event.jda.user;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.utils.ImageProxy;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class UserUpdateAvatarEvent extends UserUpdateEvent<String> {

    public static final String IDENTIFIER = "avatar";

    public UserUpdateAvatarEvent(final JDA jda, final long responseNumber, final User user, final String oldDiscriminator) {
        super(jda, responseNumber, user, oldDiscriminator, user.getDiscriminator(), IDENTIFIER);
    }

    public UserUpdateAvatarEvent(final net.dv8tion.jda.api.events.user.update.UserUpdateAvatarEvent jdaEvent) {
        super(jdaEvent);
    }

    @Nonnull
    public String getOldAvatarId() {
        return this.previous;
    }

    @Nullable
    public String getOldAvatarUrl() {
        return this.previous == null ? null : String.format(User.AVATAR_URL, this.user.getId(), this.previous, this.previous.startsWith("a_") ? "gif" : "png");
    }

    @Nullable
    public ImageProxy getOldAvatar() {
        final String oldAvatarUrl = getOldAvatarUrl();

        return oldAvatarUrl == null ? null : new ImageProxy(oldAvatarUrl);
    }

    @Nonnull
    public String getNewAvatarId() {
        return this.next;
    }

    @Nullable
    public String getNewAvatarUrl() {
        return this.next == null ? null : String.format(User.AVATAR_URL, this.user.getId(), this.next, this.next.startsWith("a_") ? "gif" : "png");
    }

    @Nullable
    public ImageProxy getNewAvatar() {
        final String newAvatarUrl = getNewAvatarUrl();

        return newAvatarUrl == null ? null : new ImageProxy(newAvatarUrl);
    }

}
