package com.structures.algorithms;

import java.util.Arrays;

public class SearchAndSortAlgorithms {

	public static void main(String[] args) {
		int[] arr = { 9, 5, 12, 6, 3, 7, 3, 5, 8, 2, 3, 4 };

		StringBuilder sb = new StringBuilder();
		sb.append("Array 1: ");
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i] + ", ");
		}
		sb.deleteCharAt(sb.lastIndexOf(","));

		// quick sort
		arr = quickSort(arr, 0, arr.length - 1);

		sb.append("\n\nResult of quick sort: ");
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i] + ", ");
		}
		sb.deleteCharAt(sb.lastIndexOf(","));
		System.out.println(sb.toString());

		sb = new StringBuilder();
		// merge sort
		arr = mergeSort(arr);
		sb.append("\nResult of merge sort: ");
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i] + ", ");
		}
		sb.deleteCharAt(sb.lastIndexOf(","));
		System.out.println(sb.toString());
		
		sb = new StringBuilder();
		// bubble sort
		arr = bubbleSort(arr);
		sb.append("\nResult of bubble sort: ");
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i] + ", ");
		}
		sb.deleteCharAt(sb.lastIndexOf(","));
		System.out.println(sb.toString());

		System.out.println("\nIndex of 2: "
				+ binarySearch(arr, 2, 0, arr.length));
	}

	/*
	 * Merge sort implementation
	 */
	public static int[] mergeSort(int[] arr) {
		if (arr.length <= 1) {
			return arr;
		}
		int pos = arr.length / 2;

		int[] left = Arrays.copyOfRange(arr, 0, pos);
		int[] right = Arrays.copyOfRange(arr, pos, arr.length);

		left = mergeSort(left);
		right = mergeSort(right);

		return merge(left, right);
	}

	public static int[] merge(int[] left, int[] right) {
		int[] result = new int[left.length + right.length];
		int index = 0;
		while (left.length != 0 && right.length != 0) {
			if (left[0] <= right[0]) {
				result[index++] = left[0];
				left = Arrays.copyOfRange(left, 1, left.length);
			} else {
				result[index++] = right[0];
				right = Arrays.copyOfRange(right, 1, right.length);
			}
		}
		while (left.length != 0) {
			result[index++] = left[0];
			left = Arrays.copyOfRange(left, 1, left.length);
		}
		while (right.length != 0) {
			result[index++] = right[0];
			right = Arrays.copyOfRange(right, 1, right.length);
		}
		return result;
	}

	/*
	 * Quicksort implementation
	 */
	public static int[] quickSort(int[] list, int low, int high) {
		if (low < high) {
			int p = partition(list, low, high);
			quickSort(list, low, p - 1);
			quickSort(list, p + 1, high);
		}
		return list;
	}

	public static void swap(int[] list, int left, int right) {
		int temp = list[left];
		list[left] = list[right];
		list[right] = temp;
	}

	public static int partition(int[] list, int low, int high) {
		int pivotIndex = (low + high) / 2;
		int pivotValue = list[pivotIndex];

		swap(list, pivotIndex, high);

		int lowIndex = low;

		for (int i = low; i < high; i++) {
			if (list[i] < pivotValue) {
				swap(list, lowIndex, i);
				lowIndex++;
			}
		}
		swap(list, lowIndex, high);
		return lowIndex;
	}

	/*
	 * Bubble sort implementation
	 */
	public static int[] bubbleSort(int[] list) {
		boolean swapped = true;
		while (swapped) {
			swapped = false;
			for (int i = 0; i < list.length - 1; i++) {
				if (list[i] > list[i + 1]) {
					swap(list, i, i + 1);
					swapped = true;
				}		
			}
		}
		return list;
	}

	/*
	 * Binary Search implementation
	 */
	public static int binarySearch(int[] list, int key, int min, int max) {
		int index = Integer.MAX_VALUE;
		if (max < min) {
			System.out.println("Value not in list");
			return -1;
		} else {
			index = (min + max) / 2;
			if (key < list[index]) {
				return binarySearch(list, key, min, index - 1);
			} else if (key > list[index]) {
				return binarySearch(list, key, index + 1, max);
			} else
				return index;
		}
	}
}
