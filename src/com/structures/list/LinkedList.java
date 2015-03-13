package com.structures.list;

import com.structures.node.ListNode;

import java.util.Iterator;

/*
 * A singly-linked LinkedList<T> implementation of List<T>
 */
public class LinkedList<T> implements List<T>, Iterable<T> {

    private ListNode<T> head;

    public LinkedList() {
    }

    public LinkedList(ListNode<T> head) {
        this.head = head;
    }

    public ListNode<T> getHead() {
        return head;
    }

    public void setHead(ListNode<T> head) {
        this.head = head;
    }

    @Override
    public int size() {
        if (!isEmpty()) {
            ListNode<T> n = head;
            int size = 1;
            while ((n = n.getNext()) != null) {
                size++;
            }
            return size;
        }
        return 0;
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
        if (value != null) {
            if (head == null) {
                head = new ListNode<T>(value);
                return true;
            } else {
                ListNode<T> n = head;
                while (n.getNext() != null) {
                    n = n.getNext();
                }
                n.setNext(new ListNode<T>(value));
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public T get(int index) {
        if (isEmpty() || index < 0 || index > size() - 1) {
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
        return head == null;
    }

    @Override
    public boolean remove(int index) {
        if (isEmpty() || index < 0 || index > size() - 1) {
            return false;
        }
        ListNode<T> n = head;
        for (int i = 0; i < index; i++) {
            System.out.println(i);
            n = n.getNext();
        }
        n = null;
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
        }
    }

}
