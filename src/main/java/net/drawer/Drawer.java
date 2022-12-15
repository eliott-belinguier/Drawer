package net.drawer;

import net.drawer.plugin.PluginManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import java.util.Arrays;
import java.util.logging.Logger;

public class Drawer {

    private final Logger logger;
    private final JDA jda;
    private final PluginManager pluginManager;

    private Drawer(final JDA jda) {
        logger = Logger.getLogger("Drawer");
        this.jda = jda;
        this.pluginManager = new PluginManager(this);
    }

    public PluginManager getPluginManager() {
        return this.pluginManager;
    }

    public JDA getJda() {
        return this.jda;
    }

    public Logger getLogger() {
        return this.logger;
    }

    public static Drawer createNewDrawer(final JDABuilder jdaBuilder) throws InterruptedException {
        final JDA jda;

        if (jdaBuilder == null)
            throw new NullPointerException("jda builder must be not null");
        jda = jdaBuilder.build();
        jda.awaitReady();
        return new Drawer(jda);
    }

    public static Drawer createNewDrawer(final String token) throws InterruptedException {
        final JDABuilder jdaBuilder;

        if (token == null)
            throw new NullPointerException("token must be not null");
        jdaBuilder = JDABuilder.create(token, Arrays.asList(GatewayIntent.values()));
        jdaBuilder.enableCache(Arrays.asList(CacheFlag.values()));
        return createNewDrawer(jdaBuilder);
    }

}
