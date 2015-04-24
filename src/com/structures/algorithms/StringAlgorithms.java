package com.structures.algorithms;

import com.structures.map.HashMap;
import com.structures.map.Map;

public class StringAlgorithms {

	/*
	 * Find all permutations of a String
	 */
	public static Character firstNonRepeated(String input) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		char[] chars = input.toCharArray();
		for (Character c : chars) {
			if (map.containsKey(c)) {
				map.put(c, (map.get(c)) + 1);
			} else {
				map.put(c, 1);
			}
		}
		for (Character c : chars) {
			if (map.get(c) == 1) {
				return c;
			}
		}
		return ' ';
	}

	/*
	 * Recursive print all permutations of a string
	 */
	public static void allPermutations(String prefix, String input) {
		if (input.length() == 1) {
			System.out.println(prefix + input);
		}
		int n = input.length();
		for (int i = 0; i < n; i++) {
			allPermutations(prefix + input.charAt(i), input.substring(0, i) + input.substring(i + 1, n));
		}
	}

	/*
	 * Recursive String reversal
	 */
	public static String reverse(String input) {
		if (input.length() == 1) {
			return input;
		}
		return (input.charAt(input.length() - 1) + reverse(input.substring(0, input.length() - 1)));
	}

	public static void main(String[] args) {
		char c = firstNonRepeated("STRESS");
		System.out.println("First non repeated: " + c);
		System.out.println("All permutations = ");
		allPermutations("", "CHRIS");
		System.out.println("CHRIS reversed: " + reverse("CHRIS"));
	}
}
