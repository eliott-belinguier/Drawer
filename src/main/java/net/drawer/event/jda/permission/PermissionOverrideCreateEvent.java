package net.drawer.event.jda.permission;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.PermissionOverride;
import net.dv8tion.jda.api.entities.channel.attribute.IPermissionContainer;

public class PermissionOverrideCreateEvent extends PermissionOverrideEvent {

    public PermissionOverrideCreateEvent(final JDA jda, final long responseNumber, final IPermissionContainer channel, final PermissionOverride override) {
        super(jda, responseNumber, channel, override);
    }

    public PermissionOverrideCreateEvent(final net.dv8tion.jda.api.events.guild.override.PermissionOverrideCreateEvent event) {
        super(event);
    }

}
