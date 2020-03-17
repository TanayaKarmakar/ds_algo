package com.app.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsPhoneNumber {
	private static Map<String, String> keyMap = new HashMap<>();

	public static void initKeyMap() {
		keyMap.put("2", "abc");
		keyMap.put("3", "def");
		keyMap.put("4", "ghi");
		keyMap.put("5", "jkl");
		keyMap.put("6", "mno");
		keyMap.put("7", "pqrs");
		keyMap.put("8", "tuv");
		keyMap.put("9", "wxyz");
	}

	private static List<String> getCombinations(String digits, int currIndx, List<String> res) {
		if (currIndx < 0) {
			res.add("");
			return res;
		}
		char curr = digits.charAt(currIndx);
		res = getCombinations(digits, currIndx - 1, res);
		String key = keyMap.get(String.valueOf(curr));
		List<String> smallOutput = new ArrayList<>();
		for (int i = 0; i < key.length(); i++) {
			for (String el : res) {
				smallOutput.add(el + key.charAt(i));
			}
		}
		return smallOutput;
	}

	private static List<String> letterCombinations(String digits) {
		initKeyMap();
		int n = digits.length();
		List<String> combinations = new ArrayList<>();
		combinations = getCombinations(digits, n - 1, combinations);
		return combinations;
	}

	public static void main(String[] args) {
		System.out.println(letterCombinations("234"));

	}

}
