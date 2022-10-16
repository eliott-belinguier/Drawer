package net.drawer.plugin;

public class InvalidPluginException extends Exception {

    public InvalidPluginException(final Throwable cause) {
        super(cause);
    }

    public InvalidPluginException(final String message) {
        super(message);
    }

}
