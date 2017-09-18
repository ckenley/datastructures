package com.structures.map;

import com.structures.list.LinkedListJ;
import com.structures.list.List;

import java.util.HashSet;
import java.util.Set;

public class HashMap<K, V> implements Map<K, V> {

    private static final int DEFAULT_SIZE = 16;
    private final int size;
    private final List<List<Entry<K, V>>> table;

    public HashMap() {
        size = DEFAULT_SIZE;
        table = new LinkedListJ<>(size);
    }

    public HashMap(int size) {
        this.size = size;
        table = new LinkedListJ<>(size);
    }

    @Override
    public void clear() {
        for (List<Entry<K, V>> bucket : table) {
            if (bucket != null) {
                bucket.clear();
            }
        }
    }

    @Override
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    @Override
    public boolean containsValue(V value) {
        for (List<Entry<K, V>> bucket : table) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    if (entry.getValue().equals(value)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> entries = new HashSet<>();
        for (List<Entry<K, V>> bucket : table) {
            for (Entry<K, V> entry : bucket) {
                entries.add(entry);
            }
        }
        return entries;
    }

    @Override
    public V put(K key, V value) {
        Entry<K, V> entry = new HashEntry(key, value);
        int index = hash(key);
        List<Entry<K, V>> bucket = table.get(index);
        if (bucket == null) {
            bucket = new LinkedListJ<>();
            bucket.add(entry);
            table.set(index, bucket);
        } else if (containsKey(key)) {
            remove(key);
            bucket.add(entry);
        } else {
            bucket.add(entry);
        }
        return value;
    }

    @Override
    public V get(K key) {
        int index = hash(key);
        List<Entry<K, V>> bucket = table.get(index);
        if (bucket != null) {
            for (Entry<K, V> e : bucket) {
                if (e.getKey().equals(key)) {
                    return e.getValue();
                }
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        boolean empty = true;
        for (List<Entry<K, V>> bucket : table) {
            if (bucket != null) {
                if (!bucket.isEmpty()) {
                    empty = false;
                }
            }
        }
        return empty;
    }

    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        for (List<Entry<K, V>> bucket : table) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    keys.add(entry.getKey());
                }
            }
        }
        return keys;
    }

    @Override
    public V remove(K key) {
        int index = hash(key);
        V value;
        List<Entry<K, V>> bucket = table.get(index);
        if (bucket != null) {
            for (Entry<K, V> e : bucket) {
                if (e.getKey().equals(key)) {
                    value = e.getValue();
                    bucket.remove(e);
                    return value;
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int hash(K key) {
        return (key.hashCode() & Integer.MAX_VALUE) % size;
    }

    private class HashEntry implements Entry<K, V> {

        private final K key;
        private final V value;

        private HashEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }
    }
}
