package com.structures.node;

/*
 * Generic container for a data object to be used in data structure implementations.
 */
public interface Node<T> {

	void setValue(T value);

	T getValue();

}
