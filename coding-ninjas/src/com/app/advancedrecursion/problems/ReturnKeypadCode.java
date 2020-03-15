package com.app.advancedrecursion.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReturnKeypadCode {
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

	private static List<String> getKeypad(int n, List<String> res) {
		if (n == 0) {
			res.add("");
			return res;
		}
		int remainder = n % 10;
		int smallNumber = n / 10;
		List<String> smallOutput = getKeypad(smallNumber, res);
		List<String> output = new ArrayList<>();
		String keyVal = keyMap.get(remainder);
		int len = keyVal.length();

		for (int i = 0; i < len; i++) {
			char ch = keyVal.charAt(i);
			for (String el : smallOutput) {
				output.add(el + ch);
			}
		}

		return output;
	}

	private static String[] keypad(int n) {
		initMap();
		List<String> res = new ArrayList<>();
		res = getKeypad(n, res);
		
		
		String[] finalOutput = new String[res.size()];
		int indx = 0;
		for(String el: res) {
			finalOutput[indx++] = el;
		}
		
		return finalOutput;
	}

	public static void main(String[] args) {
		int n = 23;
		
		String[] output = keypad(n);
		System.out.println(Arrays.toString(output));
	}

}
