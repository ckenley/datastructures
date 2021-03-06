package com.structures.list;

import com.structures.node.ListNode;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * A singly-linked LinkedList implementation in Java
 */
public class LinkedListJ<T> implements List<T>, Iterable<T> {

    private ListNode<T> head;
    private int size;

    public LinkedListJ() {
        head = null;
        size = 0;
    }

    public LinkedListJ(ListNode<T> head) {
        this.head = head;
        size = 0;
    }

    public LinkedListJ(int size) {
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

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator(this);
    }

    @Override
    public boolean add(T value) {
        if (head == null) {
            head = new ListNode<>(value);
            size++;
            return true;
        } else {
            ListNode<T> n = head;
            while (n.getNext() != null) {
                n = n.getNext();
            }
            n.setNext(new ListNode<>(value));
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
    public T remove(int index) {
        if (isEmpty() || index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        T returnVal;
        if (index == 0) {
            returnVal = head.getValue();
            if (size > 1) {
                head = head.getNext();
            } else {
                head = null;
            }
            size--;
            return returnVal;
        }
        ListNode<T> prev = head;
        ListNode<T> next = head.getNext();
        for (int i = 0; i < index - 1; i++) {
            prev = next;
            next = next.getNext();
        }
        returnVal = next.getValue();
        prev.setNext(next.getNext());
        next.setValue(null);
        size--;
        return returnVal;
    }

    @Override
    public boolean remove(T value) {
        if (isEmpty()) {
            return false;
        }
        if (size() == 1) {
            if (head.getValue().equals(value)) {
                head = null;
                size = 0;
                return true;
            }
            return false;
        }
        ListNode<T> prev;
        ListNode<T> n = head.getNext();
        while (n.getNext() != null) {
            prev = n;
            n = n.getNext();
            if (n.getValue().equals(value)) {
                prev.setNext(n.getNext());
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(T value) {
        if (this.size() > 0) {
            ListNode<T> n = head;
            if (n.getValue().equals(value)) {
                return 0;
            } else {
                for (int i = 0; i < size(); i++) {
                    if (n.getValue().equals(value)) {
                        return i;
                    }
                    n = n.getNext();
                }
            }
        }
        return -1;
    }

    public void addFirst(T value) {
        if (head.getValue() == null) {
            head.setValue(value);
        } else {
            ListNode<T> prev = head;
            head = new ListNode<>(value);
            head.setNext(prev);
        }
        size++;
    }

    public void addLast(T value) {
        if (value != null) {
            if (head.getValue() == null) {
                head.setValue(value);
            } else {
                ListNode<T> n = head;
                while (n.getNext() != null) {
                    n = n.getNext();
                }
                n.setNext(new ListNode<>(value));
            }
            size++;
        }
    }

    @Override
    public boolean contains(T value) {
        if (size == 0) {
            return false;
        }
        ListNode<T> n = head;
        if (n.getValue().equals(value)) {
            return true;
        } else {
            while (n.getNext() != null) {
                n = n.getNext();
                if (n.getValue().equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    private class LinkedListIterator implements Iterator<T> {

        private LinkedListJ<T> linkedListJ;
        private int index;

        LinkedListIterator(LinkedListJ<T> linkedList) {
            this.linkedListJ = linkedList;
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < linkedListJ.size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return linkedListJ.get(index++);
        }
    }
}
