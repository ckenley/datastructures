package com.structures.algorithms;

public class GeneralAlgoritms {

	/*
	 * Iterative Fibonacci algorithm. Returns the final value in the sequence.
	 * Faster than recursive.
	 */
	public static long fibonacci(int n) {
		long n1 = 1;
		long n2 = 1;
		long n3 = -1;
		for (int i = 3; i <= n; i++) {
			n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
		}
		return n3;
	}

	/*
	 * Recursive Fibonacci algorithm
	 */
	public static long fibonacciR(int n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else
			return fibonacciR(n - 1) + fibonacciR(n - 2);
	}

	public static void main(String[] args) {
		System.out.println(fibonacciR(50));
	}
}
