package net.drawer.event;

import java.util.ArrayList;

public class Event {

    public static Class<? extends Event>[] getAllEvents(final Class<? extends Event> eventClass) {
        final ArrayList<Class<? extends Event>> subEvents = new ArrayList<Class<? extends Event>>();
        Class<? extends Event> currentEvent;
        Class<?> unknownClass;

        if (eventClass == null)
            return null;
        currentEvent = eventClass;
        do {
            subEvents.add(currentEvent);
            unknownClass = currentEvent.getSuperclass();
            currentEvent = unknownClass.isAssignableFrom(Event.class) ? unknownClass.asSubclass(Event.class) : null;
        } while (currentEvent != null && !currentEvent.equals(Event.class));
        return subEvents.toArray(new Class[subEvents.size()]);
    }

}