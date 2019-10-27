package com.array.ideserve;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {
	private static Character firstNonRepeatingChar(String str) {
		int nChars = 26;
		Map<Character, Integer> charMap = new LinkedHashMap<>(nChars);
		str = str.toLowerCase();
		for (int i = 0; i < str.length(); i++) {
			char currentChar = str.charAt(i);
			if(!charMap.containsKey(currentChar)) {
				charMap.put(currentChar, 1);
			} else {
				charMap.put(currentChar, charMap.get(currentChar) + 1);
			}
		}
		
		for(Map.Entry<Character, Integer> entry:charMap.entrySet()) {
			if(entry.getValue() == 1)
				return entry.getKey();
		}
		return null;
	}

	public static void main(String[] args) {
		String str = "Tanaya Karmakar";
		System.out.println("First non repeating character is - " + firstNonRepeatingChar(str));
		
		str = "ADBCGHIEFKJLADTVDERFSWVGHQWCNOPENSMSJWIERTFB";
		System.out.println("First non repeating character is - " + firstNonRepeatingChar(str));
		
	}

}
