package com.app.questions;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
	private static int romanToInt(String s) {
		Map<Character, Integer> numMap = new HashMap<>();
		numMap.put('I', 1);
		numMap.put('V', 5);
		numMap.put('X', 10);
		numMap.put('L', 50);
		numMap.put('C', 100);
		numMap.put('D', 500);
		numMap.put('M', 1000);
		
		if(s.length() == 1)
			return numMap.get(s.charAt(0));
		
		int n = s.length();
		int res = numMap.get(s.charAt(0));

		int i = 0;
		while(i < n) {
			int curr = numMap.get(s.charAt(i));
			if((i + 1) < n) {
				int next = numMap.get(s.charAt(i + 1));
				if(curr >= next) {
					res += next;
				} else {
					res -= curr;
					res += Math.abs(curr - next);
				}
			}
			++i;
		}
		return Math.abs(res);
	}

	public static void main(String[] args) {
		String str = "I";
		
		System.out.println(romanToInt(str));
		
		str = "III";
		
		System.out.println(romanToInt(str));
		
		str = "IV";
		
		System.out.println(romanToInt(str));
		
		str = "LVIII";
		
		System.out.println(romanToInt(str));
		
		str = "MCMXCIV";
		
		System.out.println(romanToInt(str));

	}

}
