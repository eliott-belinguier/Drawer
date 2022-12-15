package net.drawer.event.jda.self;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.self.GenericSelfUpdateEvent;

import javax.annotation.Nonnull;

public class SelfUpdateDiscriminatorEvent extends SelfUpdateEvent<String> {
    public static final String IDENTIFIER = "discriminator";

    public SelfUpdateDiscriminatorEvent(@Nonnull JDA api, long responseNumber, @Nonnull String oldDiscriminator) {
        super(api, responseNumber, oldDiscriminator, api.getSelfUser().getDiscriminator(), IDENTIFIER);
    }

    public SelfUpdateDiscriminatorEvent(GenericSelfUpdateEvent jdaEvent) {
        super(jdaEvent);

    }

    @Nonnull
    public String getOldDiscriminator() {
        return getOldValue();
    }

    @Nonnull
    public String getNewDiscriminator() {
        return getNewValue();
    }

    @Nonnull
    @Override
    public String getOldValue() {
        return super.getOldValue();
    }

    @Nonnull
    @Override
    public String getNewValue() {
        return super.getNewValue();
    }
}