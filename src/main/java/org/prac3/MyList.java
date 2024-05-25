package org.prac3;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class MyList<T> implements List<T> {
    private List<T> innerList = new ArrayList<>();
    @Override
    public synchronized int size() {
        return innerList.size();
    }

    @Override
    public synchronized boolean isEmpty() {
        return innerList.isEmpty();
    }

    @Override
    public synchronized boolean contains(Object o) {
        return innerList.contains(o);
    }

    @NotNull
    @Override
    public synchronized Iterator<T> iterator() {
        return innerList.iterator();
    }

    @NotNull
    @Override
    public synchronized Object[] toArray() {
        return innerList.toArray();
    }

    @NotNull
    @Override
    public synchronized <T1> T1[] toArray(@NotNull T1[] a) {
        return innerList.toArray(a);
    }

    @Override
    public synchronized boolean add(T t) {
        return innerList.add(t);
    }

    @Override
    public synchronized boolean remove(Object o) {
        return innerList.remove(o);
    }

    @Override
    public synchronized boolean containsAll(@NotNull Collection<?> c) {
        return innerList.containsAll(c);
    }

    @Override
    public synchronized boolean addAll(@NotNull Collection<? extends T> c) {
        return innerList.addAll(c);
    }

    @Override
    public synchronized boolean addAll(int index, @NotNull Collection<? extends T> c) {
        return innerList.addAll(index, c);
    }

    @Override
    public synchronized boolean removeAll(@NotNull Collection<?> c) {
        return innerList.removeAll(c);
    }

    @Override
    public boolean retainAll(@NotNull Collection<?> c) {
        return innerList.removeAll(c);
    }

    @Override
    public synchronized void clear() {
        innerList.clear();
    }

    @Override
    public synchronized T get(int index) {
        return innerList.get(index);
    }

    @Override
    public synchronized T set(int index, T element) {
        return innerList.set(index, element);
    }

    @Override
    public synchronized void add(int index, T element) {
        innerList.add(index, element);
    }

    @Override
    public synchronized T remove(int index) {
        return innerList.remove(index);
    }

    @Override
    public synchronized int indexOf(Object o) {
        return innerList.indexOf(o);
    }

    @Override
    public synchronized int lastIndexOf(Object o) {
        return innerList.lastIndexOf(o);
    }

    @NotNull
    @Override
    public synchronized ListIterator<T> listIterator() {
        return innerList.listIterator();
    }

    @NotNull
    @Override
    public synchronized ListIterator<T> listIterator(int index) {
        return innerList.listIterator(index);
    }

    @NotNull
    @Override
    public synchronized List<T> subList(int fromIndex, int toIndex) {
        return innerList.subList(fromIndex, toIndex);
    }
}
