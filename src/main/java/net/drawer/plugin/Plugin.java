package net.drawer.plugin;

import net.drawer.Drawer;
import net.drawer.plugin.exceptions.InvalidConfigException;
import net.drawer.plugin.exceptions.InvalidPluginException;
import org.apache.logging.log4j.core.util.FileUtils;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

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

    public void useConfig() throws IOException, InvalidConfigException {
        useConfig("config");
    }

    public void useConfig(String config) throws IOException, InvalidConfigException {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream(config+".yml");
        if(config == null) {
            throw new InvalidConfigException("Config name must be not null");
        }
        if(in == null) {
            throw new InvalidConfigException("The "+config+".yml file need to be not null");
        }

        String goalPath = getPluginInfo().getPluginFolderPath()+config+".yml";
        if(!new File(goalPath).exists()) {
            Files.copy(in, Paths.get(goalPath));
        }
    }

    public PluginConfig getConfig() {
        return getConfig("config");
    }

    public PluginConfig getConfig(String config) {
        try {
            return this.drawer.getPluginManager().getConfig(this, config);
        } catch (InvalidConfigException e) {
            e.printStackTrace();
        }
        return null;
    }

}
