package net.drawer.plugin;

import net.drawer.Drawer;
import net.drawer.event.Cancellable;
import net.drawer.event.Event;
import net.drawer.event.EventListener;
import net.drawer.util.SortedArrayList;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.security.InvalidParameterException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class PluginManager {

    private final Drawer drawer;
    private final Map<Class<? extends Event>, SortedArrayList<ListenerCallable>> listenerCallables;
    private final Map<String, Plugin> plugins;

    public PluginManager(final Drawer drawer) {
        this.drawer = drawer;
        this.listenerCallables = new ConcurrentHashMap<Class<? extends Event>, SortedArrayList<ListenerCallable>>();
        this.plugins = new ConcurrentHashMap<String, Plugin>();
    }

    private Plugin loadPlugin(final PluginInfo pluginInfo, final File pluginFile) throws InvalidPluginException {
        final PluginClassLoader pluginClassLoader;
        final Plugin plugin;

        if (this.plugins.get(pluginInfo.name) != null)
            throw new InvalidPluginException("plugin already loaded");
        try {
            pluginClassLoader = new PluginClassLoader(this, getClass().getClassLoader(), pluginInfo, pluginFile);
        } catch (MalformedURLException exception) {
            throw new InvalidPluginException(exception);
        }
        plugin = pluginClassLoader.getPlugin();
        this.plugins.put(plugin.getName(), plugin);
        PluginContext.runInPluginContext(plugin, plugin::onLoad);
        return plugin;
    }

    public Plugin loadPlugin(final File pluginFile) throws InvalidPluginInfoException, InvalidPluginException {
        return loadPlugin(PluginInfo.getPluginInfo(pluginFile), pluginFile);
    }

    private String getFileExtension(final File file) {
        final String name = file.getName();
        final int index = name.lastIndexOf(".");

        if (index < 0)
            return name;
        return name.substring(index + 1);
    }

    public Set<Plugin> loadPlugins(final Set<File> files) {
        final Map<PluginInfo, File> pluginInfos;
        final LinkedList<PluginInfo> loadingQueue = new LinkedList<PluginInfo>();
        final Set<Plugin> plugins;
        PluginInfo pluginInfo;

        if (files == null)
            return null;
        pluginInfos = new HashMap<PluginInfo, File>();
        plugins = new HashSet<Plugin>();
        for (File file : files) {
            if (getFileExtension(file).equalsIgnoreCase("jar")) {
                try {
                    pluginInfo = PluginInfo.getPluginInfo(file);
                    pluginInfos.put(pluginInfo, file);
                } catch (InvalidPluginInfoException exception) {
                    exception.printStackTrace();
                }
            }
        }
        for (final Map.Entry<PluginInfo, File> entry : pluginInfos.entrySet()) {
            try {
                plugins.add(loadPlugin(entry.getKey(), entry.getValue()));
            } catch (InvalidPluginException exception) {
                exception.printStackTrace();
            }
        }
        return plugins;
    }

    public Set<Plugin> loadPluginFolder(final File pluginFolder) {
        final File[] files;

        if (pluginFolder == null)
            throw new NullPointerException("plugin folder must be not null");
        if (!pluginFolder.isDirectory())
            throw new InvalidParameterException("file must be a folder");
        files = pluginFolder.listFiles();
        if (files == null)
            return null;
        return loadPlugins(new HashSet<File>(Arrays.asList(files)));
    }

    public boolean unloadPlugin(final String name) {
        final Plugin removedPlugin;

        if (name == null)
            return false;
        removedPlugin = this.plugins.remove(name);
        if (removedPlugin == null)
            return false;
        unregisterListener(removedPlugin);
        return true;
    }

    public Plugin getPlugin(final String name) {
        if (name == null)
            return null;
        return this.plugins.get(name);
    }
    
    public Set<Plugin> getPlugins() {
        return new HashSet<Plugin>(this.plugins.values());
    }

    private boolean registerListenerMethod(final Object listener, final Method method, final EventListener eventListener) {
        final Plugin plugin = PluginContext.getPluginContext();
        final Class<?>[] parameters;
        final Class<? extends Event> event;
        final ListenerCallable listenerCallable;
        SortedArrayList<ListenerCallable> listenerCallables;

        if (plugin == null)
            return false;
        parameters = method.getParameterTypes();
        if (parameters.length != 1 || !Event.class.isAssignableFrom(parameters[0]))
            return false;
        event = parameters[0].asSubclass(Event.class);
        listenerCallable = new ListenerCallable(plugin, listener, method, eventListener);
        listenerCallables = this.listenerCallables.get(event);
        if (listenerCallables == null) {
            listenerCallables = new SortedArrayList<ListenerCallable>(ListenerCallable::compare);
            this.listenerCallables.put(event, listenerCallables);
        } else if (listenerCallables.contains(listenerCallable))
            return false;
        return listenerCallables.add(listenerCallable);
    }

    public boolean registerListener(final Object listener) {
        final Method[] methods;
        final Class<?> listenerClass;
        boolean result = false;
        EventListener eventListener;

        if (listener == null)
            return false;
        listenerClass = listener.getClass();
        methods = listenerClass.getDeclaredMethods();
        for (final Method method : methods) {
            eventListener = method.getAnnotation(EventListener.class);
            if (eventListener != null)
                result = registerListenerMethod(listener, method, eventListener) || result;
        }
        return result;
    }

    public void unregisterListener(final Object listener) {
        if (listener == null)
            return;
        this.listenerCallables.entrySet().removeIf(entry -> {
            final SortedArrayList<ListenerCallable> listenerCallables = entry.getValue();

            if (listenerCallables == null)
                return true;
            listenerCallables.remove(listener);
            return listenerCallables.isEmpty();
        });
    }

    public void unregisterListener(final Plugin plugin) {
        if (plugin == null)
            return;
        this.listenerCallables.entrySet().removeIf(entry -> {
            final SortedArrayList<ListenerCallable> listenerCallables = entry.getValue();

            if (listenerCallables == null)
                return true;
            listenerCallables.removeIf(listenerCallable -> listenerCallable.plugin.equals(plugin));
            return listenerCallables.isEmpty();
        });
    }

    public boolean callEvent(final Event event) {
        final Class<? extends Event>[] eventClasses;
        SortedArrayList<ListenerCallable> listenerCallables;

        if (event == null)
            return false;
        eventClasses = Event.getAllEvents(event.getClass());
        if (eventClasses == null)
            return false;
        for (final Class<? extends Event> eventClass : eventClasses) {
            listenerCallables = this.listenerCallables.get(eventClass);
            if (listenerCallables == null)
                continue;
            for (final ListenerCallable listenerCallable : listenerCallables) {
                listenerCallable.call(event);
            }
        }
        return !(event instanceof Cancellable) || !((Cancellable) event).isCancelled();
    }

    public Drawer getDrawer() {
        return this.drawer;
    }

}
