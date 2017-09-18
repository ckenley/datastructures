package com.structures.algorithms;

/**
 * Simple Timer class to keep track of algorithm execution times.
 */
public class Timer {

    private static final Timer instance = new Timer();
    private long start;
    private long stop;

    public void start() {
        start = System.currentTimeMillis();
    }

    public void stop() {
        stop = System.currentTimeMillis();
    }

    public long getTime() {
        return stop - start;
    }
}
