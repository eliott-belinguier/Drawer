package net.drawer.plugin;

import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.Map;

public class PluginConfig {

    private Map map;
    private File file;

    public static PluginConfig fromFile(File configFile) {
        try {
            InputStream input = new FileInputStream(configFile);
            Yaml yaml = new Yaml();
            return new PluginConfig().setFile(configFile).setMap(yaml.load(input));
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public PluginConfig setFile(File file) {
        this.file = file;
        return this;
    }

    public File getFile() {
        return file;
    }

    public PluginConfig setMap(Map map) {
        this.map = map;
        return this;
    }

    public Map getMap() {
        return map;
    }

    public PluginConfig set(String key, Object value) {
        map.put(key, value);
        return this;
    }

    public void save() {
        try {
            PrintWriter writer = new PrintWriter(file);
            Yaml yaml = new Yaml();
            yaml.dump(map, writer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public <T> T getAs(Class<T> type, String key) {
        return (T) map.get(key);
    }

    public String getAsString(String key) {
        return getAs(String.class, key);
    }

    public int getAsInt(String key) {
        return getAs(Integer.class, key);
    }

    public long getAsLong(String key) {
        return getAs(Long.class, key);
    }

    public boolean getAsBoolean(String key) {
        return getAs(Boolean.class, key);
    }
}
