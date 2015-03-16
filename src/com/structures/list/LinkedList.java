package com.structures.list;

import com.structures.node.ListNode;

import java.util.Iterator;

/*
 * A singly-linked LinkedList<T> implementation of List<T>
 */
public class LinkedList<T> implements List<T>, Iterable<T> {

    private ListNode<T> head;
    private int size;

    public LinkedList() {
        this.head = new ListNode<T>();
        this.size = 0;
    }

    public LinkedList(ListNode<T> head) {
        this.head = head;
        this.size = 0;
    }

    public LinkedList(int size) {
        for (int i = 0; i < size; i++) {
            add(null);
        }
        this.size = size;
    }

    public ListNode<T> getHead() {
        return head;
    }

    public void setHead(ListNode<T> head) {
        this.head = head;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index;

            @Override
            public boolean hasNext() {
                return this.index < size();
            }

            @Override
            public T next() {
                return get(this.index++);
            }
        };
    }

    @Override
    public boolean add(T value) {
        if (head == null) {
            head = new ListNode<T>(value);
            size++;
            return true;
        } else {
            ListNode<T> n = head;
            while (n.getNext() != null) {
                n = n.getNext();
            }
            n.setNext(new ListNode<T>(value));
            size++;
            return true;
        }
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public T set(int index, T value) {
        if (isEmpty() || index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        int i = 0;
        ListNode<T> n = head;
        while (i < index && n.getNext() != null) {
            n = n.getNext();
            i++;
        }
        n.setValue(value);
        return value;
    }

    @Override
    public T get(int index) {
        if (isEmpty() || index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        int i = 0;
        ListNode<T> n = head;
        while (i < index && n.getNext() != null) {
            n = n.getNext();
            i++;
        }
        return n.getValue();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(int index) {
        if (isEmpty() || index < 0 || index > size() - 1) {
            return false;
        }
        ListNode<T> n = head;
        for (int i = 0; i < index; i++) {
            n = n.getNext();
        }
        n = null;
        size--;
        return true;
    }

    @Override
    public int indexOf(T value) {
        if (this.size() > 0) {
            ListNode n = head;
            for (int i = 1; i <= size(); i++) {
                if (n.getValue().equals(value)) {
                    return i;
                }
                n = n.getNext();
            }
        }
        return -1;
    }

    public void addFirst(T value) {
        if (head == null) {
            head.setValue(value);
        } else {
            ListNode<T> prev = head;
            head = new ListNode<T>(value);
            head.setNext(prev);
        }
        size++;
    }

    public void addLast(T value) {
        if (value != null) {
            if (head == null) {
                head.setValue(value);
            } else {
                ListNode<T> n = head;
                while (n.getNext() != null) {
                    n = n.getNext();
                }
                n.setNext(new ListNode<T>(value));
            }
            size++;
        }
    }

}
