package com.structures.node;

/*
 * Implementation of Node<T> interface specific to all implementations of List<T> interface
 */
public class ListNode<T> implements Node<T> {

    private T value;
    private ListNode<T> next;

    public ListNode() {
    }

    public ListNode(T value) {
        this.value = value;
    }

    @Override
    public T getValue() {
        return this.value;
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }

    public ListNode<T> getNext() {
        return this.next;
    }

    public void setNext(ListNode<T> node) {
        this.next = node;
    }

}
