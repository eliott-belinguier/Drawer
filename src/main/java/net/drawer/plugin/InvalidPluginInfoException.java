package net.drawer.plugin;

public class InvalidPluginInfoException extends Exception {

    public InvalidPluginInfoException(final Throwable cause) {
        super(cause);
    }

    public InvalidPluginInfoException(final String message) {
        super(message);
    }

}
