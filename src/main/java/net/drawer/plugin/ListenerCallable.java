package net.drawer.plugin;

import net.drawer.event.Cancellable;
import net.drawer.event.Event;
import net.drawer.event.EventListener;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ListenerCallable {

    protected final Plugin plugin;
    protected final Object listener;
    protected final Method method;
    protected final EventListener eventListener;

    public ListenerCallable(final Plugin plugin, final Object listener, final Method method, EventListener eventListener) {
        this.plugin = plugin;
        this.listener = listener;
        this.method = method;
        this.eventListener = eventListener;
        this.method.setAccessible(true);
    }

    public void call(final Event event) {
        if (this.eventListener.ignoreCancelled() && event instanceof Cancellable && ((Cancellable) event).isCancelled())
            return;
        PluginContext.runInPluginContext(plugin, () -> {
            try {
                ListenerCallable.this.method.invoke(ListenerCallable.this.listener, event);
            } catch (IllegalAccessException | InvocationTargetException exception) {
                exception.printStackTrace();
            }
        });
    }

    public static int compare(final ListenerCallable c1, final ListenerCallable c2) {
        return Integer.compare(c1.eventListener.priority().ordinal(), c2.eventListener.priority().ordinal());
    }

}
