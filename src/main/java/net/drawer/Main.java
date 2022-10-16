package net.drawer;

import net.drawer.plugin.Plugin;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        final File pluginFolder = new File("plugins");
        final Drawer drawer;
        final BufferedReader console;
        final Set<Plugin> plugins;
        String token = System.getProperty("DISCORD_TOKEN");
        String line;

        if (token == null) {
            System.err.println("Token not set.");
            return;
        }
        drawer = Drawer.createNewDrawer(token);
        pluginFolder.mkdir();
        System.out.println("Loading plugins...");
        plugins = drawer.getPluginManager().loadPluginFolder(pluginFolder);
        if (plugins != null) {
            for (Plugin plugin : plugins) {
                System.out.println("Enabling " + plugin.getName() + " plugin...");
                plugin.runInContext(() -> plugin.onEnable(false));
            }
        }
        console = new BufferedReader(new InputStreamReader(System.in));
        try {
            while ((line = console.readLine()) != null) {
                if (line.equalsIgnoreCase("stop"))
                    break;
            }
        } catch (IOException ignored) {};
        drawer.getJda().shutdown();
    }

}