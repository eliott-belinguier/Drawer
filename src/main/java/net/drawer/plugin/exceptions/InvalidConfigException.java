package net.drawer.plugin.exceptions;

public class InvalidConfigException extends Exception {

    public InvalidConfigException(final Throwable cause) {
        super(cause);
    }

    public InvalidConfigException(final String message) {
        super(message);
    }

}
