package net.drawer.plugin;

import net.drawer.Drawer;
import net.drawer.plugin.exceptions.InvalidPluginException;

public class Plugin {

    private final Drawer drawer;
    private final PluginInfo pluginInfo;

    public Plugin() {
        final ClassLoader classLoader = getClass().getClassLoader();
        final PluginClassLoader pluginClassLoader;


        if (classLoader instanceof PluginClassLoader) {
            pluginClassLoader = (PluginClassLoader) classLoader;
            this.drawer = pluginClassLoader.getPluginManager().getDrawer();
            this.pluginInfo = pluginClassLoader.getPluginInfo();
        } else {
            this.drawer = null;
            this.pluginInfo = null;
        }
        if (this.drawer == null)
            throw new IllegalStateException(new InvalidPluginException(new NullPointerException("plugin's drawer not found from class loader")));
        if (this.pluginInfo == null)
            throw new IllegalStateException(new InvalidPluginException(new NullPointerException("plugin's info not found from class loader")));
    }

    public void onLoad() {

    }

    public void onEnable(final boolean reload) {

    }

    public void onDisable(final boolean reload) {

    }

    public String getName() {
        return this.pluginInfo.name;
    }

    public PluginInfo getPluginInfo() {
        return this.pluginInfo;
    }

    public Drawer getDrawer() {
        return this.drawer;
    }

}
