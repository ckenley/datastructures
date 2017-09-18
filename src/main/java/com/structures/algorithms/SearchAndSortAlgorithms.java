package com.structures.algorithms;

import java.util.Arrays;

public class SearchAndSortAlgorithms {

    public static void main(String[] args) {
        int[] arr = {9, 5, 12, 6, 3, 7, 3, 5, 8, 2, 3, 4};

        StringBuilder sb = new StringBuilder();
        sb.append("Array 1: ");
        for (int num : arr) {
            sb.append(num);
            sb.append(", ");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append("\nArray 2: ");

        //arr = mergeSort(arr);
        arr = quickSort(arr, 0, arr.length - 1);
        for (int num : arr) {
            sb.append(num);
            sb.append(", ");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        System.out.println(sb.toString());

        System.out.println("Index of 4: " + binarySearch(arr, 4, 0, arr.length));
    }

    private static int[] mergeSort(int[] arr) {
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

    private static int[] quickSort(int[] list, int low, int high) {
        if (low < high) {
            int p = partition(list, low, high);
            quickSort(list, low, p - 1);
            quickSort(list, p + 1, high);
        }
        return list;
    }

    private static void swap(int[] list, int left, int right) {
        int temp = list[left];
        list[left] = list[right];
        list[right] = temp;
    }


    private static int partition(int[] list, int low, int high) {
        int pivotIndex = list.length / 2;
        int pivotValue = list[pivotIndex];

        int lowIndex = low;

        //swap pivot value and high value
        swap(list, pivotIndex, high);

        for (int i = low; i < high; i++) {
            if (list[i] < pivotValue) {
                swap(list, lowIndex, i);
                lowIndex++;
            }
        }
        swap(list, lowIndex, high);
        return lowIndex;
    }

    private static int[] merge(int[] left, int[] right) {
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

    private static int binarySearch(int[] list, int key, int min, int max) {
        int index = Integer.MAX_VALUE;
        if (max < min) {
            System.out.println("Value not in list");
        } else {
            index = (min + max) / 2;
            if (key < list[index]) {
                binarySearch(list, key, min, index - 1);
            } else if (key > list[index]) {
                binarySearch(list, key, index + 1, max);
            } else return index;
        }
        return index;
    }
}
