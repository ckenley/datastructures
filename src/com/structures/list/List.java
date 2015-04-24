package com.structures.list;

import java.util.Iterator;

/*
 * Interface contract for classes implementing List<T>
 */
public interface List<T> extends Iterable<T> {

    int size();

    boolean add(T value);

    void clear();

    T get(int index);

    boolean isEmpty();

    T remove(int index);
    
    boolean remove(T value);

    int indexOf(T value);

    Iterator<T> iterator();

    T set(int index, T value);
    
    boolean contains(T value);

}
