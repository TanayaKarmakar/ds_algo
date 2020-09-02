package com.app.practice.recursionbacktracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfAPhoneNumber17 {
	private static Map<Character, String> map;
	
	private static void initMap() {
		map = new HashMap<>();
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
		
		List<String> smallOutput = letterCombinations(digits, i + 1);
		String str = map.get(digits.charAt(i));
		List<String> newOutput = new ArrayList<>();
		for(int j = 0; j < str.length(); j++) {
			for(String str1: smallOutput) {
				String newStr = str.charAt(j) + str1;
				newOutput.add(newStr);
			}
		}
		
		return newOutput;
	}
	
	private static List<String> letterCombinations(String digits) {
		initMap();
		return letterCombinations(digits, 0);
	}

	public static void main(String[] args) {
		String digits = "23";
		List<String> output = letterCombinations(digits);
		
		System.out.println(output);

	}

}
