package com.structures.test;

import com.structures.algorithms.GenericSortingAlgorithms;
import com.structures.algorithms.Timer;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenericSortingAlgorithmsTest extends TestCase {

    private List<Integer> unsorted;
    private Random rand;
    private Timer timer;

    public void setUp() {
        unsorted = new ArrayList<Integer>();
        rand = new Random();
        int counter = 0;
        while (counter++ < 9999) {
            unsorted.add(rand.nextInt(9999));
        }
        timer = new Timer();
        timer.start();
    }

    public void tearDown() {
        unsorted = null;
        rand = null;
        timer = null;
    }

    public void testMergeSort() {
        List<Integer> sorted = GenericSortingAlgorithms.mergeSort(unsorted);
        timer.stop();
        int last = sorted.get(0);
        for (int i = 1; i < sorted.size(); i++) {
            assertTrue(sorted.get(i).compareTo(last) >= 0);
            last = sorted.get(i);
        }
        System.out.println("MergeSort took " + timer.getTime() + " ms");
    }

    public void testBubbleSort() {
        List<Integer> sorted = GenericSortingAlgorithms.bubbleSort(unsorted);
        timer.stop();
        int last = sorted.get(0);
        for (int i = 1; i < sorted.size(); i++) {
            assertTrue(sorted.get(i).compareTo(last) >= 0);
            last = sorted.get(i);
        }
        System.out.println("BubbleSort took " + timer.getTime() + " ms");
    }

    public void testInsertionSort() {
        List<Integer> sorted = GenericSortingAlgorithms.insertionSort(unsorted);
        timer.stop();
        int last = sorted.get(0);
        for (int i = 1; i < sorted.size() - 1; i++) {
            assertTrue(sorted.get(i).compareTo(last) >= 0);
            last = sorted.get(i);
        }
        System.out.println("InsertionSort took " + timer.getTime() + " ms");
    }

    public void testQuickSort() {
        List<Integer> sorted = GenericSortingAlgorithms.quickSort(unsorted, 0, unsorted.size() - 1);
        timer.stop();
        int last = sorted.get(0);
        for (int i = 1; i < sorted.size() - 1; i++) {
            assertTrue(sorted.get(i).compareTo(last) >= 0);
            last = sorted.get(i);
        }
        System.out.println("QuickSort took " + timer.getTime() + " ms");
    }

}
