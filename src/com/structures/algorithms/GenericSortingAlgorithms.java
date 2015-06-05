package com.structures.algorithms;

import java.util.ArrayList;
import java.util.List;

public class GenericSortingAlgorithms<T> {

    public static <T extends Comparable<T>> List<T> quickSort(List<T> list, int low, int high) {
        if (low < high) {
            int p = partition(list, low, high);
            quickSort(list, low, p - 1);
            quickSort(list, p + 1, high);
        }
        return list;
    }

    private static <T extends Comparable<T>> int partition(List<T> list, int low, int high) {
        int pivot = (low + high) / 2;
        T pivotValue = list.get(pivot);
        //put the chosen pivot at list[high]
        swap(list, pivot, high);
        int lowIndex = low;
        for (int i = low; i < high; i++) {
            if (list.get(i).compareTo(pivotValue) < 0) {
                swap(list, i, lowIndex);
                lowIndex++;
            }
        }
        swap(list, lowIndex, high);
        return lowIndex;
    }

    /**
     * Generic Insertion Sort Implementation
     *
     * @param list
     * @param <T>
     * @return Sorted List<T>
     */
    public static <T extends Comparable<T>> List<T> insertionSort(List<T> list) {
        for (int i = 1; i < list.size(); i++) {
            int j = i;
            while (j > 0 && list.get(j - 1).compareTo(list.get(j)) > 0) {
                swap(list, j, j - 1);
                j = j - 1;
            }
        }
        return list;
    }

    /**
     * Generic Bubble Sort Implementation
     *
     * @param list
     * @param <T>
     * @return Sorted List<T>
     */
    public static <T extends Comparable<T>> List<T> bubbleSort(List<T> list) {
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i).compareTo(list.get(i - 1)) < 0) {
                    swap(list, i, i - 1);
                    swapped = true;
                }
            }
        }
        return list;
    }

    /**
     * Generic MergeSort Implementation
     *
     * @param unsorted
     * @param <T>
     * @return Sorted List<T>
     */
    public static <T extends Comparable> List<T> mergeSort(List<T> unsorted) {
        if (unsorted.size() == 1) {
            return unsorted;
        }
        int mid = unsorted.size() / 2;
        List<T> left = unsorted.subList(0, mid);
        List<T> right = unsorted.subList(mid, unsorted.size());

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private static <T extends Comparable<T>> List<T> merge(List<T> left, List<T> right) {
        List<T> sorted = new ArrayList<T>(left.size() + right.size());
        while (left.size() > 0 && right.size() > 0) {
            if (left.get(0).compareTo(right.get(0)) < 0) {
                sorted.add(left.get(0));
                left = left.subList(1, left.size());
            } else {
                sorted.add(right.get(0));
                right = right.subList(1, right.size());
            }
        }
        while (left.size() > 0) {
            sorted.add(left.get(0));
            left = left.subList(1, left.size());
        }
        while (right.size() > 0) {
            sorted.add(right.get(0));
            right = right.subList(1, right.size());
        }
        return sorted;
    }

    private static <T> void swap(List<T> list, int index1, int index2) {
        T temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

    public static void main(String[] args) {
        List<Integer> unsorted = new ArrayList<Integer>();
        unsorted.add(8);
        unsorted.add(6);
        unsorted.add(3);
        unsorted.add(52);
        unsorted.add(9);
        for (Integer i : unsorted) {
            System.out.print(i + " - ");
        }
        System.out.print("\n");
        List<Integer> sorted = quickSort(unsorted, 0, unsorted.size() - 1);
        for (Integer i : sorted) {
            System.out.print(i + " - ");
        }
    }

    private static class NotFoundException extends Exception {
        public NotFoundException(String message) {
            super(message);
        }
    }
}