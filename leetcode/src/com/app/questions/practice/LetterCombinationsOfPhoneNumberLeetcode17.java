package com.app.questions.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumberLeetcode17 {
	private static Map<Integer, String> keyMap = new HashMap<>();

	public static void keyMap() {
		keyMap.put(2, "abc");
		keyMap.put(3, "def");
		keyMap.put(4, "ghi");
		keyMap.put(5, "jkl");
		keyMap.put(6, "mno");
		keyMap.put(7, "pqrs");
		keyMap.put(8, "tuv");
		keyMap.put(9, "wxyz");
	}
	
	private static List<String> letterCombinations(String input, int currentIndx) {
		if(currentIndx < 0) {
			List<String> res = new ArrayList<>();
			res.add("");
			return res;
		}
		List<String> res = letterCombinations(input, currentIndx - 1);
		String keyVal = keyMap.get(input.charAt(currentIndx) - '0');
		List<String> newList = new ArrayList<>();
		//newList.addAll(res);
		for(int i = 0; i < keyVal.length(); i++) {
			char ch = keyVal.charAt(i);
			for(String el: res) {
				newList.add(el + ch);
			}
		}
		return newList;
	}
	
	private static List<String> letterCombinations(String input) {
		if(input.isEmpty())
			return new ArrayList<>();
		keyMap();
		int n = input.length() - 1;
		return letterCombinations(input, n);
	}

	public static void main(String[] args) {
		List<String> res = new ArrayList<>();
		
		res = letterCombinations("234");
		
		System.out.println(res);

	}

}
