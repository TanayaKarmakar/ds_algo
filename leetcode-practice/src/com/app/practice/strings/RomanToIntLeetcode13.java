package com.app.practice.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RomanToIntLeetcode13 {
	private static Map<Character, Integer> map;

	private static void initMap() {
		map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
	}

	private static int romanToInt(String s) {
		if(s.length() == 0)
			return 0;
		initMap();
		if(s.length() == 1)
			return map.get(s.charAt(0));
		int n = s.length();
		
		int sum = map.get(s.charAt(n - 1));
		for(int i = n - 2; i >= 0; i--) {
			int val = map.get(s.charAt(i));
			int prev = map.get(s.charAt(i + 1));
			
			if(val < prev)
				sum = sum - val;
			else
				sum = sum + val;
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String s = scanner.next();
		
		int result = romanToInt(s);
		
		System.out.println(result);
		
		scanner.close();
	}

}
