package com.structures.algorithms;

import com.structures.map.HashMap;
import com.structures.map.Map;


public class StringAlgorithms {

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
			System.out.println("char: " + c + "; count: " + map.get(c));
		}
		return ' ';
	}

	public static void main(String[] args) {
		char c = firstNonRepeated("STRESS");
		System.out.println("First non repeated: " + c);
	}

}
