package com.app.questions.practice;

import java.util.HashMap;
import java.util.Map;

public class RomanToIntegerLeetcode13 {
	private static void initMap(Map<Character, Integer> map) {
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
	}
	
	private static int romanToInt(String str) {
		Map<Character, Integer> map = new HashMap<>();
		initMap(map);
		
		int n = str.length();
		
		int sum = map.get(str.charAt(n - 1));
		
		for(int i = n - 2; i >= 0; i--) {
			int curr = map.get(str.charAt(i));
			int prev = map.get(str.charAt(i + 1));
			if(curr >= prev) {
				sum += curr;
			} else {
				sum -= curr;
			}
		}
		
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(romanToInt("MCMXCIV"));
		System.out.println(romanToInt("LVIII"));
		System.out.println(romanToInt("IX"));
		System.out.println(romanToInt("IV"));
		System.out.println(romanToInt("III"));
	}

}
