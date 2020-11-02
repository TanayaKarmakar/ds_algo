package com.app.practice.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordPatternLeetcode290 {
	private static boolean wordPattern(String pattern, String s) {
		if(pattern.length() != s.split("\\s+").length)
			return false;
		Map<Character, String> map = new HashMap<>();
		Map<String, Character> revMap = new HashMap<>();

		String[] sArr = s.split("\\s+");
		int n = pattern.length();

		for (int i = 0; i < n; i++) {
			char ch = pattern.charAt(i);
			String sVal = sArr[i];

			if (!map.containsKey(ch)) {
				if(!revMap.containsKey(sVal)) {
					map.put(ch, sVal);
					revMap.put(sVal, ch);
				} else {
					return false;
				}
			} else {
				if (!map.get(ch).equals(sVal))
					return false;
			}

			
		}

		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String pattern = scanner.nextLine();
		String s = scanner.nextLine();
		
		System.out.println(wordPattern(pattern, s));
		
		scanner.close();

	}

}
