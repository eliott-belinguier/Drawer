package net.drawer.plugin;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class PluginClassLoader extends URLClassLoader {

    private final PluginManager pluginManager;
    private final PluginInfo pluginInfo;
    private final Plugin plugin;

    public PluginClassLoader(final PluginManager pluginManager, final ClassLoader parent, final PluginInfo pluginInfo, final File pluginFile) throws InvalidPluginException, MalformedURLException {
        super(new URL[] {pluginFile.toURI().toURL()}, parent);
        final Class<?> mainJarClass;
        final Class<? extends Plugin> mainClass;

        this.pluginManager = pluginManager;
        this.pluginInfo = pluginInfo;
        try {
            mainJarClass = Class.forName(pluginInfo.mainClassName, true, this);
        } catch (ClassNotFoundException exception) {
            throw new InvalidPluginException(exception);
        }
        try {
            mainClass = mainJarClass.asSubclass(Plugin.class);
        } catch (ClassCastException exception) {
            throw new InvalidPluginException(exception);
        }
        try {
            this.plugin = mainClass.newInstance();
        } catch (InstantiationException | IllegalAccessException exception) {
            throw new InvalidPluginException(exception);
        }
    }

    public PluginManager getPluginManager() {
        return this.pluginManager;
    }

    public PluginInfo getPluginInfo() {
        return this.pluginInfo;
    }

    public Plugin getPlugin() {
        return this.plugin;
    }

    public void runInContext(final Runnable runnable) {
        final Thread thread = Thread.currentThread();
        final ClassLoader classLoader = thread.getContextClassLoader();

        thread.setContextClassLoader(this);
        runnable.run();
        thread.setContextClassLoader(classLoader);
    }

}
