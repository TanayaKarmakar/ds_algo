package com.app.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfAPhoneNumberLeetcode17 {
	private static Map<Character, String> map = new HashMap<>();
	
	private static void initMap() {
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
	}
	
	private static List<String> letterCombinations(String digits, int i) {
		if(i == digits.length()) {
			List<String> res = new ArrayList<>();
			res.add("");
			return res;
		}
		List<String> output = letterCombinations(digits, i + 1);
		List<String> newOutput = new ArrayList<>();
		String value = map.get(digits.charAt(i));
		for(String str: output) {
			for(int j = 0; j < value.length(); j++) {
				newOutput.add(value.charAt(j) + str);
			}
		}
		return newOutput;
	}
	
	private static List<String> letterCombinations(String digits) {
		if(digits.equals(""))
			return new ArrayList<>();
		initMap();
		return letterCombinations(digits, 0);
	}

	public static void main(String[] args) {
		String str = "23";
		
		List<String> res = letterCombinations(str);
		
		System.out.println(res);

	}

}
