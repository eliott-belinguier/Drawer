package net.drawer.event;

public interface Cancellable {

    public void setCancelled(boolean cancelled);
    public boolean isCancelled();

}
