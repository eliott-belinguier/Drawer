package net.drawer.event.jda.self;

import net.drawer.event.jda.JDAEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.self.GenericSelfUpdateEvent;
import net.dv8tion.jda.api.utils.ImageProxy;

import javax.annotation.Nullable;

public class SelfUpdateAvatarEvent extends SelfUpdateEvent<String> {

    public static final String IDENTIFIER = "avatar";
    private static final String AVATAR_URL = "https://cdn.discordapp.com/avatars/%s/%s%s";
    public SelfUpdateAvatarEvent(JDA jda, long responseNumber, String previous, String next, String identifier) {
        super(jda, responseNumber, previous, next, identifier);
    }

    public SelfUpdateAvatarEvent(GenericSelfUpdateEvent jdaEvent) {
        super(jdaEvent);
    }

    @Nullable
    public String getOldAvatarId()
    {
        return getOldValue();
    }

    @Nullable
    public String getOldAvatarUrl()
    {
        return previous == null ? null : String.format(AVATAR_URL,  super.getEntity().getId(), previous, previous.startsWith("a_") ? ".gif" : ".png");
    }

    @Nullable
    public ImageProxy getOldAvatar()
    {
        final String oldAvatarUrl = getOldAvatarUrl();
        return oldAvatarUrl == null ? null : new ImageProxy(oldAvatarUrl);
    }

    @Nullable
    public String getNewAvatarId()
    {
        return getNewValue();
    }

    @Nullable
    public String getNewAvatarUrl()
    {
        return next == null ? null : String.format(AVATAR_URL, super.getEntity().getId(), next, next.startsWith("a_") ? ".gif" : ".png");
    }

    @Nullable
    public ImageProxy getNewAvatar()
    {
        final String newAvatarUrl = getNewAvatarUrl();
        return newAvatarUrl == null ? null : new ImageProxy(newAvatarUrl);
    }
}
