package net.drawer.plugin;

import com.sun.org.apache.xpath.internal.objects.XNull;
import net.drawer.Drawer;
import net.drawer.event.Event;
import net.drawer.plugin.exceptions.InvalidConfigException;
import net.drawer.plugin.exceptions.InvalidPluginException;
import net.drawer.plugin.exceptions.InvalidPluginInfoException;

import java.io.File;
import java.net.MalformedURLException;
import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class PluginManager {

    private final Drawer drawer;
    private final Map<String, Plugin> plugins;

    public PluginManager(final Drawer drawer) {
        this.drawer = drawer;
        this.plugins = new ConcurrentHashMap<String, Plugin>();
    }

    public Plugin loadPlugin(final File pluginFile) throws InvalidPluginInfoException, InvalidPluginException {
        final PluginInfo pluginInfo;
        final PluginClassLoader pluginClassLoader;
        final Plugin plugin;

        pluginInfo = PluginInfo.getPluginInfo(pluginFile);
        if (this.plugins.get(pluginInfo.name) != null)
            throw new InvalidPluginException("plugin already loaded");
        try {
            pluginClassLoader = new PluginClassLoader(this, getClass().getClassLoader(), PluginInfo.getPluginInfo(pluginFile), pluginFile);
        } catch (MalformedURLException exception) {
            throw new InvalidPluginException(exception);
        }
        plugin = pluginClassLoader.getPlugin();
        this.plugins.put(plugin.getName(), plugin);
        PluginContext.runInPluginContext(plugin, plugin::onLoad);
        return plugin;
    }

    private String getFileExtension(final File file) {
        final String name = file.getName();
        final int index = name.lastIndexOf(".");

        if (index < 0)
            return name;
        return name.substring(index + 1);
    }

    public Set<Plugin> loadPluginFolder(final File pluginFolder) {
        final File[] files;
        final Set<Plugin> plugins;

        if (pluginFolder == null)
            throw new NullPointerException("plugin folder must be not null");
        if (!pluginFolder.isDirectory())
            throw new InvalidParameterException("file must be a folder");
        files = pluginFolder.listFiles();
        if (files == null)
            return null;
        plugins = new HashSet<Plugin>();
        for (File file : files) {
            if (getFileExtension(file).equalsIgnoreCase("jar")) {
                try {
                    plugins.add(loadPlugin(file));
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
        if (plugins.isEmpty())
            return null;
        return plugins;
    }

    public boolean unloadPlugin(final String name) {
        return this.plugins.remove(name) != null;
    }

    public Plugin getPlugin(final String name) {
        if (name == null)
            return null;
        return this.plugins.get(name);
    }

    public PluginConfig getConfig(Plugin plugin, String config) throws InvalidConfigException {
        if (config == null) {
            throw new NullPointerException("Config must be not null");
        }
        File f = new File(plugin.getPluginInfo().getPluginFolderPath());

        if (f == null || !f.isDirectory()) {
            throw new NullPointerException("Plugin directory must be not null and a folder");
        }

        File configFile = new File(f.getAbsoluteFile() + "/" + config + ".yml");
        if (configFile == null) {
            throw new InvalidConfigException("Config " + config + " must exist");
        }
    return PluginConfig.fromFile(configFile);
    }

    public Set<Plugin> getPlugins() {
        return new HashSet<Plugin>(this.plugins.values());
    }

    public boolean callEvent(final Event event) {
        return false;
    }

    public Drawer getDrawer() {
        return this.drawer;
    }

}
