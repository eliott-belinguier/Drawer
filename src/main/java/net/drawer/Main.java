package net.drawer;

import net.drawer.plugin.Plugin;
import net.drawer.plugin.PluginContext;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        final File pluginFolder = new File("plugins");
        final Drawer drawer;
        final Logger logger;
        final BufferedReader console;
        final Set<Plugin> plugins;
        String token = System.getProperty("DISCORD_TOKEN");
        String line;

        if (token == null) {
            System.err.println("Token not set.");
            return;
        }
        drawer = Drawer.createNewDrawer(token);
<<<<<<< HEAD
=======
        drawer.getJda().addEventListener(new DrawerListenerAdapter(drawer.getPluginManager()));
>>>>>>> master
        logger = drawer.getLogger();
        pluginFolder.mkdir();
        logger.info("Loading plugins...");
        plugins = drawer.getPluginManager().loadPluginFolder(pluginFolder);
        if (plugins != null) {
            for (Plugin plugin : plugins) {
<<<<<<< HEAD

                new File(plugin.getPluginInfo().getPluginFolderPath()).mkdir();

                logger.info("Enabling " + plugin.getName() + " plugin...");

                PluginContext.runInPluginContext(plugin, () -> plugin.onEnable(false));
                System.out.println("Creating folder : "+plugin.getPluginInfo().getPluginFolderPath());
=======
                logger.info("Enabling " + plugin.getName() + " plugin...");
                PluginContext.runInPluginContext(plugin, () -> plugin.onEnable(false));
>>>>>>> master
            }
        }
        console = new BufferedReader(new InputStreamReader(System.in));
        try {
            while ((line = console.readLine()) != null) {
                if (line.equalsIgnoreCase("stop"))
                    break;
            }
        } catch (IOException ignored) {};
        logger.info("Disabling plugins...");
        for (Plugin plugin : drawer.getPluginManager().getPlugins()) {
            logger.info("Disabling " + plugin.getName() + " plugin...");
            PluginContext.runInPluginContext(plugin, () -> plugin.onDisable(false));
        }
        drawer.getJda().shutdown();
    }

}