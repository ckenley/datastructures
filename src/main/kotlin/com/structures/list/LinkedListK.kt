package com.structures.list

class LinkedListK<E> : List<E> {

    private data class Node(var value: Any, var next: Node? = null)

    private var head: Node? = null
    var size = 0

    override fun size(): Int {
        return size
    }

    override fun add(value: E): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clear() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun get(index: Int): E {
        if (isEmpty || index < 0 || index >= size()) {
            throw IndexOutOfBoundsException()
        }
        var i = 0
        var n = head
        while (i < index && n!!.next != null) {
            n = n.next
            i++
        }
        return n!!.value as E
    }

    override fun isEmpty(): Boolean {
        return head!!.next != null
    }

    override fun remove(index: Int): E {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun remove(value: E): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun indexOf(value: E): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun iterator(): MutableIterator<E> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun set(index: Int, value: E): E {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun contains(value: E): Boolean {
        val n = head
        while (n!!.next != null) {
            if (n.value == value) {
                return true
            }
        }
        return false
    }
}