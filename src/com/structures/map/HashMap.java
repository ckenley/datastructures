package com.structures.map;

import com.structures.list.LinkedList;
import com.structures.list.List;

import java.util.Collection;
import java.util.Set;


public class HashMap<K, V> implements Map<K, V> {

    private int size;
    private List<List<Entry<K, V>>> table;

    public HashMap(int size) {
        this.size = size;
        table = new LinkedList<>(size);
    }

    @Override
    public void clear() {
    	for (List<Entry<K,V>> bucket : table){
    		if (bucket != null){
    			bucket.clear();
    		}
    	}
    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        return false;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
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
            	if (bucket.size() > 0){
            		empty = false;
            	}
            }
        }
        return empty;
    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public V put(K key, V value) {
        Entry<K, V> entry = new HashEntry(key, value);
        int index = hash(key);
        List<Entry<K, V>> bucket = table.get(index);
        if (bucket == null) {
            bucket = new LinkedList<Entry<K, V>>();
            table.set(index, bucket);
        }
        bucket.add(entry);
        return value;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    private int hash(K key) {
        return (key.hashCode() & Integer.MAX_VALUE) % size;
    }

    private class HashEntry implements Entry<K, V> {

        private K key;
        private V value;

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
