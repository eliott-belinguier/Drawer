package net.drawer.plugin;

import java.util.function.Supplier;

public class PluginContext {

    public static <T> T runInPluginContext(final Plugin plugin, final Supplier<T> supplier) {
        final Thread thread = Thread.currentThread();
        final ClassLoader classLoader = thread.getContextClassLoader();
        final T result;

        thread.setContextClassLoader(plugin.getClass().getClassLoader());
        result = supplier.get();
        thread.setContextClassLoader(classLoader);
        return result;
    }

    public static void runInPluginContext(final Plugin plugin, final Runnable runnable) {
        final Thread thread = Thread.currentThread();
        final ClassLoader classLoader = thread.getContextClassLoader();

        thread.setContextClassLoader(plugin.getClass().getClassLoader());
        runnable.run();
        thread.setContextClassLoader(classLoader);
    }

    public static Plugin getPluginContest() {
        final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        if (classLoader instanceof PluginClassLoader)
            return ((PluginClassLoader) classLoader).getPlugin();
        return null;
    }

}
