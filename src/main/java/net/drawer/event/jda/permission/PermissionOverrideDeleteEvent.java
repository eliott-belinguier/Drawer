package net.drawer.event.jda.permission;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.PermissionOverride;
import net.dv8tion.jda.api.entities.channel.attribute.IPermissionContainer;

public class PermissionOverrideDeleteEvent extends PermissionOverrideEvent {


    public PermissionOverrideDeleteEvent(final JDA jda, final long responseNumber, final IPermissionContainer channel, final PermissionOverride override) {
        super(jda, responseNumber, channel, override);
    }

    public PermissionOverrideDeleteEvent(final net.dv8tion.jda.api.events.guild.override.PermissionOverrideDeleteEvent event) {
        super(event);
    }

}
