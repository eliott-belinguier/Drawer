package net.drawer.event;

import java.util.ArrayList;
import java.util.Collections;

public class Event {

    public static Class<? extends Event>[] getAllEvents(final Class<? extends Event> eventClass) {
        final Class<Event> classEvent = Event.class;
        final ArrayList<Class<? extends Event>> subEvents = new ArrayList<Class<? extends Event>>();
        Class<? extends Event> currentEvent;
        Class<?> unknownClass;

        if (eventClass == null)
            return null;
        currentEvent = eventClass;
        do {
            subEvents.add(currentEvent);
            if (currentEvent.equals(Event.class))
                break;
            unknownClass = currentEvent.getSuperclass();
            currentEvent = unknownClass != null && classEvent.isAssignableFrom(unknownClass) ? unknownClass.asSubclass(Event.class) : null;
        } while (currentEvent != null);
        Collections.reverse(subEvents);
        return subEvents.toArray(new Class[subEvents.size()]);
    }

}