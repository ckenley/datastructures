package com.structures.list

class ArrayListK<E> : List<E> {

    private val INITIAL_SIZE: Int = 10
    private var currentSize: Int = 0
    private var array = arrayOfNulls<Any>(INITIAL_SIZE)

    override fun size(): Int {
        return currentSize
    }

    override fun add(value: E): Boolean {
        if (array.contains(value)) {
            return false
        }
        checkSize()
        array[currentSize++] = value
        return true
    }

    override fun clear() {
        currentSize = 0
        array = arrayOfNulls(currentSize)
    }

    override fun remove(index: Int): E {
        val item: E = get(index)
        System.arraycopy(array, index + 1, array, index, currentSize--)
        return item
    }

    override fun remove(value: E): Boolean {
        if (value in array) {
            System.arraycopy(array, array.indexOf(value) + 1, array, array.indexOf(value), currentSize--)
            return true
        }
        return false
    }

    override fun set(index: Int, value: E): E {
        val existing = get(index)
        array[index] = value
        return existing
    }


    override fun contains(element: E): Boolean {
        return element in array
    }

    override fun get(index: Int): E {
        if (index < 0 || index >= currentSize) {
            throw IndexOutOfBoundsException()
        }
        return array[index] as E
    }

    /**
     * Returns first index of [element], or -1 if the collection does not contain element.
     */
    override fun indexOf(element: E): Int {
        if (element in array) {
            return array.indexOf(element)
        } else {
            return -1
        }
    }

    override fun isEmpty(): Boolean {
        return currentSize == 0
    }

    private fun resize() {
        this.array = array.copyOf(currentSize * 2)
    }

    private fun checkSize() {
        if (currentSize >= array.size) {
            resize()
        }
    }

    override fun iterator(): MutableIterator<E> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}