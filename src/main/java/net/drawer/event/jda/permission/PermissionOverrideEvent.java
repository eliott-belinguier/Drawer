package net.drawer.event.jda.permission;

import net.drawer.event.jda.JDAEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.IPermissionHolder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.PermissionOverride;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.entities.channel.attribute.IPermissionContainer;
import net.dv8tion.jda.api.entities.channel.unions.IPermissionContainerUnion;
import net.dv8tion.jda.api.events.guild.override.GenericPermissionOverrideEvent;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class PermissionOverrideEvent extends JDAEvent {

    protected final IPermissionContainer channel;
    protected final PermissionOverride override;

    public PermissionOverrideEvent(final JDA jda, final long responseNumber, final IPermissionContainer channel, final PermissionOverride override) {
        super(jda, responseNumber);
        this.channel = channel;
        this.override = override;
    }

    public PermissionOverrideEvent(final GenericPermissionOverrideEvent event) {
        super(event);
        this.channel = event.getChannel();
        this.override = event.getPermissionOverride();
    }

    @Nonnull
    public ChannelType getChannelType() {
        return this.channel.getType();
    }

    @Nonnull
    public IPermissionContainerUnion getChannel() {
        return (IPermissionContainerUnion) this.channel;
    }

    @Nonnull
    public PermissionOverride getPermissionOverride() {
        return this.override;
    }

    public boolean isRoleOverride() {
        return this.override.isRoleOverride();
    }

    public boolean isMemberOverride() {
        return this.override.isMemberOverride();
    }

    public IPermissionHolder getPermissionHolder() {
        return isMemberOverride() ? override.getMember() : override.getRole();
    }


    @Nullable
    public Member getMember() {
        return this.override.getMember();
    }

    @Nullable
    public Role getRole() {
        return this.override.getRole();
    }

}
