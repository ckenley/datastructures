package com.structures.list;

/*
 * Interface contract for classes implementing List<T>
 */
public interface List<T> extends Iterable<T> {

    int size();

    boolean add(T value);

    void clear();

    T get(int index);

    boolean isEmpty();

    boolean remove(int index);

    int indexOf(T value);

}
