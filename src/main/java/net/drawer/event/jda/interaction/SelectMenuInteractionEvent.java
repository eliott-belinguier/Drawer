package net.drawer.event.jda.interaction;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.interactions.components.selections.SelectMenu;
import net.dv8tion.jda.api.interactions.components.selections.SelectMenuInteraction;

import javax.annotation.Nonnull;
import java.util.List;

public class SelectMenuInteractionEvent extends ComponentInteractionEvent implements SelectMenuInteraction {

    protected final SelectMenuInteraction selectMenuInteraction;

    public SelectMenuInteractionEvent(final JDA jda, final long responseNumber, final SelectMenuInteraction selectMenuInteraction) {
        super(jda, responseNumber, selectMenuInteraction);
        this.selectMenuInteraction = selectMenuInteraction;
    }

    public SelectMenuInteractionEvent(final Event jdaEvent, final SelectMenuInteraction selectMenuInteraction) {
        super(jdaEvent, selectMenuInteraction);
        this.selectMenuInteraction = selectMenuInteraction;
    }

    public SelectMenuInteractionEvent(final net.dv8tion.jda.api.events.interaction.component.SelectMenuInteractionEvent jdaEvent) {
        this(jdaEvent, jdaEvent.getInteraction());
    }

    @Nonnull
    @Override
    public SelectMenuInteraction getInteraction() {
        return this.selectMenuInteraction;
    }

    @Nonnull
    @Override
    public SelectMenu getComponent() {
        return this.selectMenuInteraction.getComponent();
    }

    @Nonnull
    @Override
    public List<String> getValues() {
        return this.selectMenuInteraction.getValues();
    }

}
