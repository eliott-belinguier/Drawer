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

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.channel.Channel;
import net.dv8tion.jda.api.entities.channel.ChannelField;
import net.dv8tion.jda.api.entities.channel.attribute.IAgeRestrictedChannel;
import net.dv8tion.jda.api.events.channel.update.GenericChannelUpdateEvent;

import javax.annotation.Nonnull;

/**
 * Indicates that a {@link Channel Channels} nsfw state has been updated.
 *
 * <p>Can be used to retrieve the old nsfw state and the new one.
 *
 * <p>Limited to {@link IAgeRestrictedChannel IAgeRestrictedChannels} (and implementations).
 *
 * @see IAgeRestrictedChannel#isNSFW()
 * @see ChannelField#NSFW
 */
public class ChannelUpdateNSFWEvent extends ChannelUpdateEvent<Boolean>
{
    public static ChannelField FIELD = ChannelField.NSFW;
    public static final String IDENTIFIER = FIELD.getFieldName();

    public ChannelUpdateNSFWEvent(GenericChannelUpdateEvent<Boolean> jdaEvent) {
        super(jdaEvent);
    }

    public ChannelUpdateNSFWEvent(@Nonnull JDA api, long responseNumber, Channel channel, Boolean oldValue, Boolean newValue)
    {
        super(api, responseNumber, channel, FIELD, oldValue, newValue);
    }
}
