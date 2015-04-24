package com.structures.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<T> implements List<T> {

	private Object[] array;
	private int size;
	private final int INITIAL_SIZE = 10;

	public ArrayList() {
		this.array = new Object[INITIAL_SIZE];
		this.size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	public void resize() {
		Object[] newArr = new Object[size * 2];
		System.arraycopy(array, 0, newArr, size, size);
		this.array = newArr;
	}

	public void checkSize() {
		if (size >= array.length) {
			resize();
		}
	}

	@Override
	public boolean add(T value) {
		checkSize();
		array[size++] = value;
		return true;
	}

	@Override
	public void clear() {
		array = new Object[array.length];
		size = 0;
	}

	@Override
	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		T element = (T) array[index];
		return element;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public T remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		T element = (T) array[index];
		for (int i = index; i < size; i++) {
			array[i] = array[i + 1];
		}
		size--;
		return element;
	}

	@Override
	public boolean remove(T value) {
		for (int i = 0; i < size; i++) {
			if (get(i).equals(value)) {
				remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public int indexOf(T value) {
		for (int i = 0; i < size; i++) {
			if (array[i].equals(value)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public Iterator<T> iterator() {
		return new ArrayListIterator(this);
	}

	@Override
	public T set(int index, T value) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		array[index] = value;
		return value;
	}

	@Override
	public boolean contains(T value) {
		for (int i = 0; i < size; i++) {
			if (array[i].equals(value)) {
				return true;
			}
		}
		return false;
	}

	private class ArrayListIterator implements Iterator<T> {

		private ArrayList<T> arrayList;
		private int index;

		ArrayListIterator(ArrayList<T> arrayList) {
			this.arrayList = arrayList;
			this.index = 0;
		}

		@Override
		public boolean hasNext() {
			return index < arrayList.size();
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return arrayList.get(index++);
		}

	}

}
