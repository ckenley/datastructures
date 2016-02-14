package com.structures.map;

import java.util.Set;

public interface Map<K, V> {

    void clear();

    boolean containsKey(K key);

    boolean containsValue(V value);

    Set<Entry<K, V>> entrySet();

    boolean equals(Object o);

    V get(K key);

    int hashCode();

    boolean isEmpty();

    Set<K> keySet();

    V put(K key, V value);

    V remove(K key);

    int size();

    interface Entry<K, V> {
        K getKey();

        V getValue();

        int hashCode();

        boolean equals(Object o);
    }
}
