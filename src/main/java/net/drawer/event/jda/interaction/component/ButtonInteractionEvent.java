package net.drawer.event.jda.interaction.component;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.components.buttons.ButtonInteraction;

import javax.annotation.Nonnull;

public class ButtonInteractionEvent extends ComponentInteractionEvent implements ButtonInteraction {

    protected final ButtonInteraction buttonInteraction;

    public ButtonInteractionEvent(final JDA jda, final long responseNumber, final ButtonInteraction interaction) {
        super(jda, responseNumber, interaction);
        this.buttonInteraction = interaction;
    }

    public ButtonInteractionEvent(final Event jdaEvent, final ButtonInteraction interaction) {
        super(jdaEvent, interaction);
        this.buttonInteraction = interaction;
    }

    public ButtonInteractionEvent(final net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent jdaEvent) {
        this(jdaEvent, jdaEvent.getInteraction());
    }

    @Nonnull
    @Override
    public ButtonInteraction getInteraction() {
        return this.buttonInteraction;
    }

    @Nonnull
    @Override
    public Button getComponent() {
        return this.buttonInteraction.getComponent();
    }

    @Nonnull
    @Override
    public Button getButton() {
        return this.buttonInteraction.getButton();
    }

}
