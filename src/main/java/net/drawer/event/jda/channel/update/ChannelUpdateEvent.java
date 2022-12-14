/*
 * Copyright 2015 Austin Keener, Michael Ritter, Florian Spieß, and the JDA contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.drawer.event.jda.channel.update;

import net.drawer.event.jda.channel.ChannelEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.audit.AuditLogKey;
import net.dv8tion.jda.api.entities.channel.Channel;
import net.dv8tion.jda.api.entities.channel.ChannelField;
import net.dv8tion.jda.api.events.UpdateEvent;
import net.dv8tion.jda.api.events.channel.GenericChannelEvent;
import net.dv8tion.jda.api.events.channel.update.GenericChannelUpdateEvent;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ChannelUpdateEvent<T> extends ChannelEvent implements UpdateEvent<Channel, T>
{
    protected final ChannelField channelField;
    protected final T oldValue;
    protected final T newValue;

    public ChannelUpdateEvent(@Nonnull JDA api, long responseNumber, Channel channel, ChannelField channelField, T oldValue, T newValue)
    {
        super(api, responseNumber, channel);

        this.channelField = channelField;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public ChannelUpdateEvent(GenericChannelUpdateEvent<T> event) {
        super(event);
        this.channelField = ChannelField.valueOf(event.getPropertyIdentifier());
        this.oldValue = event.getOldValue();
        this.newValue = event.getNewValue();
    }
    @Nonnull
    @Override
    public String getPropertyIdentifier()
    {
        return channelField.getFieldName();
    }


    @Nonnull
    @Override
    public Channel getEntity()
    {
        return getChannel();
    }


    @Nullable
    @Override
    public T getOldValue()
    {
        return oldValue;
    }


    @Nullable
    @Override
    public T getNewValue()
    {
        return newValue;
    }
}
