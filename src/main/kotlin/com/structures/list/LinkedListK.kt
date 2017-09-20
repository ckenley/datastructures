package com.structures.list

class LinkedListK<E> : List<E> {
    private data class Node(var value: Any, var next: Node? = null)

    private var head: Node? = null

    private var size = 0

    override fun size(): Int {
        return size
    }

    override fun add(value: E): Boolean {
        if (size == 0) {
            head = Node(value as Any)
        } else {
            var n = head!!
            while (n.next != null) {
                n = n.next!!
            }
            n.next = Node(value as Any)
        }
        size++
        return true
    }

    override fun clear() {
        head = null
        size = 0
    }

    override fun get(index: Int): E {
        if (index < 0 || index >= size) {
            throw IndexOutOfBoundsException()
        }
        var n = head!!
        var i = 0
        while (i < index && n.next != null) {
            n = n.next!!
            i++
        }
        return n.value as E
    }

    override fun isEmpty(): Boolean {
        return head == null
    }

    override fun remove(index: Int): E {
        if (isEmpty || index < 0 || index >= size) {
            throw IndexOutOfBoundsException()
        }
        if (index == 0) {
            val value = head!!.value
            head = head!!.next
            size--
            return value as E
        } else {
            var p: Node? = null
            var n = head!!
            var i = 0
            while (i < index) {
                i++
                p = n
                n = n.next!!
            }
            p?.next = n.next
            size--
            return n.value as E
        }
    }

    override fun indexOf(value: E): Int {
        if (size == 0) {
            return -1
        } else {
            if (head!!.value == value) {
                return 0
            } else {
                var n = head!!
                var i = 0
                while (n.next != null) {
                    n = n.next!!
                    i++
                    if (n.value == value) {
                        return i
                    }
                }
            }
        }
        return -1
    }

    override fun set(index: Int, value: E): E {
        if (isEmpty || index < 0 || index >= size()) {
            throw IndexOutOfBoundsException()
        }
        var n = head!!
        var i = 0
        while (i < index && n.next != null) {
            n = n.next!!
            i++
        }
        val p = n.value
        n.value = value as Any
        return p as E
    }

    override fun contains(value: E): Boolean {
        if (size == 0) {
            return false
        } else {
            if (head!!.value == value) {
                return true
            } else {
                var n = head!!
                while (n.next != null) {
                    n = n.next!!
                    if (n.value == value) {
                        return true
                    }
                }
            }
        }
        return false
    }

    override fun remove(value: E): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun iterator(): MutableIterator<E> {
        return LinkedListKIterator(this)
    }

    class LinkedListKIterator<out E>(private var linkedList: LinkedListK<E>) : MutableIterator<E> {

        private var index = 0

        override fun hasNext(): Boolean {
            return linkedList.size() > index + 1
        }

        override fun next(): E {
            return linkedList.get(index++)
        }

        override fun remove() {
            linkedList.remove(index)
        }

    }
}
