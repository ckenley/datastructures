package com.structures.node;

/*
 * Generic container for a data object to be used in data structure implementations.
 */
public interface Node<T> {

    T getValue();

    void setValue(T value);

}
