package com.structures.list;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public interface List<T> extends Iterable<T> {

    int size();

    boolean add(T value);

    void clear();

    T get(int index);

    boolean isEmpty();

    T remove(int index);

    boolean remove(T value);

    int indexOf(T value);

    @NotNull
    Iterator<T> iterator();

    T set(int index, T value);

    boolean contains(T value);

}
