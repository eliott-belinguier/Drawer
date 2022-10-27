package net.drawer.plugin;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class PluginInfo {

    protected final String name;
    protected final String version;
    protected final String mainClassName;
    protected final List<String> dependencies;

    public PluginInfo(final String name, final String version, final String mainClassName) {
        this.name = name;
        this.version = version;
        this.mainClassName = mainClassName;
        this.dependencies = new ArrayList<String>();
    }

    public String getName() {
        return this.name;
    }

    public String getVersion() {
        return this.version;
    }

    public String getMainClassName() {
        return mainClassName;
    }

    public List<String> getDependencies() {
        return Collections.unmodifiableList(this.dependencies);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.name);
    }

    private static <T> T getEntry(final Map<String, Object> entries, final String entry, final Class<T> typeClass) {
        final Object value = entries.get(entry);

        if (typeClass.isInstance(value))
            return typeClass.cast(value);
        return null;
    }

    private static String getStringEntry(final Map<String, Object> entries, final String entry) {
        final Object value = entries.get(entry);

        if (value == null)
            return null;
        if (value instanceof String)
            return (String) value;
        return value.toString();
    }

    public static PluginInfo getPluginInfo(final Map<String, Object> entries) throws InvalidPluginInfoException {
        final String name = getStringEntry(entries, "name");
        final String version = getStringEntry(entries, "version");
        final String mainClassName = getStringEntry(entries, "main");
        final List<?> dependencies = getEntry(entries, "depend", List.class);
        final PluginInfo pluginInfo;

        if (name == null)
            throw new InvalidPluginInfoException("drawer.yml doesn't contains name property");
        if (version == null)
            throw new InvalidPluginInfoException("drawer.yml doesn't contains version property");
        if (mainClassName == null)
            throw new InvalidPluginInfoException("drawer.yml doesn't contains main class property");
        pluginInfo = new PluginInfo(name, version, mainClassName);
        if (dependencies != null) {
            for (final Object dependency : dependencies) {
                if (dependency instanceof String)
                    pluginInfo.dependencies.add((String) dependency);
            }
        }
        return new PluginInfo(name, version, mainClassName);
    }

    public static PluginInfo getPluginInfo(final File pluginFile) throws InvalidPluginInfoException {
        final JarFile jarFile;
        final JarEntry jarEntry;
        final InputStream entryInputStream;
        final Yaml yaml;
        final Map<String, Object> entries;

        if (pluginFile == null)
            throw new NullPointerException("drawer file must be not null");
        try {
            jarFile = new JarFile(pluginFile);
            jarEntry = jarFile.getJarEntry("drawer.yml");
            if (jarEntry == null)
                throw new InvalidPluginInfoException("jar must be contain drawer.yml");
            yaml = new Yaml();
            entryInputStream = jarFile.getInputStream(jarEntry);
            entries = yaml.load(entryInputStream);
            entryInputStream.close();
            return getPluginInfo(entries);
        } catch (IOException exception) {
            throw new InvalidPluginInfoException(exception);
        }
    }

}
