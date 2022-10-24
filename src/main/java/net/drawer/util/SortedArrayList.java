package net.drawer.util;

import java.util.Collection;
import java.util.Comparator;
import java.util.concurrent.CopyOnWriteArrayList;

public class SortedArrayList<T> extends CopyOnWriteArrayList<T> {

    private Comparator<? super T> comparator;

    public SortedArrayList(final Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    public SortedArrayList(final Collection<? extends T> collection, final Comparator<? super T> comparator) {
        super(collection);
        this.comparator = comparator;
        if (this.comparator != null)
            super.sort(comparator);
    }

    @Override
    public boolean add(final T element) {
        final boolean result = super.add(element);

        super.sort(this.comparator);
        return result;
    }

    @Override
    public T set(final int index, final T element) {
        final T result = super.set(index, element);

        super.sort(this.comparator);
        return result;
    }

    @Override
    public boolean addAll(final Collection<? extends T> collection) {
        final boolean result = super.addAll(collection);

        super.sort(this.comparator);
        return result;
    }

    @Override
    public void sort(final Comparator<? super T> comparator) {
        this.comparator = comparator;
        super.sort(this.comparator);
    }
}
