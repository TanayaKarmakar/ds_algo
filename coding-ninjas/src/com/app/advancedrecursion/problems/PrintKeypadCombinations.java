package com.app.advancedrecursion.problems;

import java.util.HashMap;
import java.util.Map;

public class PrintKeypadCombinations {
	private static Map<Integer, String> keyMap = new HashMap<>();

	private static void initMap() {
		keyMap.put(2, "abc");
		keyMap.put(3, "def");
		keyMap.put(4, "ghi");
		keyMap.put(5, "jkl");
		keyMap.put(6, "mno");
		keyMap.put(7, "pqrs");
		keyMap.put(8, "tuv");
		keyMap.put(9, "wxyz");
	}

	private static void printKeypad(int input, String output) {
		if (input == 0) {
			System.out.println(output);
			return;
		}
		int remainder = input % 10;
		int smallInput = input / 10;
		String key = keyMap.get(remainder);

		int n = key.length();
		for (int i = 0; i < n; i++) {
			printKeypad(smallInput, key.charAt(i) + output);
		}
	}

	private static void printKeypad(int input) {
		initMap();
		printKeypad(input, "");
	}

	public static void main(String[] args) {
		int n = 23;
		printKeypad(n);

	}

}
