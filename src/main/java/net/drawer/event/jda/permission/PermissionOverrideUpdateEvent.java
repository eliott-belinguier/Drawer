package net.drawer.event.jda.permission;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.PermissionOverride;
import net.dv8tion.jda.api.entities.channel.attribute.IPermissionContainer;

import javax.annotation.Nonnull;
import java.util.EnumSet;

public class PermissionOverrideUpdateEvent extends PermissionOverrideEvent {

    private final long oldAllow, oldDeny;

    public PermissionOverrideUpdateEvent(final JDA jda, final long responseNumber, final IPermissionContainer channel, final PermissionOverride override, final long oldAllow, final long oldDeny) {
        super(jda, responseNumber, channel, override);
        this.oldAllow = oldAllow;
        this.oldDeny = oldDeny;
    }

    public PermissionOverrideUpdateEvent(final net.dv8tion.jda.api.events.guild.override.PermissionOverrideUpdateEvent event) {
        super(event);
        this.oldAllow = event.getOldAllowRaw();
        this.oldDeny = event.getOldDenyRaw();
    }

    public long getOldAllowRaw() {
        return this.oldAllow;
    }

    public long getOldDenyRaw() {
        return this.oldDeny;
    }

    public long getOldInheritedRaw() {
        return ~(oldAllow | oldDeny);
    }

    @Nonnull
    public EnumSet<Permission> getOldAllow() {
        return Permission.getPermissions(this.oldAllow);
    }

    @Nonnull
    public EnumSet<Permission> getOldDeny() {
        return Permission.getPermissions(this.oldDeny);
    }

    @Nonnull
    public EnumSet<Permission> getOldInherited() {
        return Permission.getPermissions(getOldInheritedRaw());
    }

}
