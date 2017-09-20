package com.structures.list

class ArrayListK<E> : List<E> {

    private val INITIAL_SIZE: Int = 10
    private var currentSize: Int = 0
    private var arr = arrayOfNulls<Any>(INITIAL_SIZE)

    override fun size(): Int {
        return currentSize
    }

    override fun add(value: E): Boolean {
        if (arr.contains(value)) {
            return false
        }
        checkSize()
        arr[currentSize++] = value
        return true
    }

    override fun clear() {
        currentSize = 0
        arr = arrayOfNulls(INITIAL_SIZE)
    }

    override fun remove(index: Int): E {
        val item = get(index)
        System.arraycopy(arr, index + 1, arr, index, currentSize--)
        return item
    }

    override fun set(index: Int, value: E): E {
        val existing = get(index)
        arr[index] = value
        return existing
    }

    override fun contains(element: E): Boolean {
        return element in arr
    }


    override fun get(index: Int): E {
        if (index < 0 || index >= currentSize) {
            throw IndexOutOfBoundsException()
        }
        return arr[index] as E
    }

    /**
     * Returns first index of [element], or -1 if the collection does not contain element.
     */
    override fun indexOf(element: E): Int {
        if (element in arr) {
            return arr.indexOf(element)
        } else {
            return -1
        }
    }

    override fun isEmpty(): Boolean {
        return currentSize == 0
    }

    private fun resize() {
        this.arr = arr.copyOf(currentSize * 2)
    }

    private fun checkSize() {
        if (currentSize >= arr.size) {
            resize()
        }
    }

    override fun iterator(): MutableIterator<E> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun remove(value: E): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
