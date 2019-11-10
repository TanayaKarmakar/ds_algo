package com.strings.basic;

public class PangramChecking {
	private static boolean isPangram(String str) {
		boolean[] characters = new boolean[26];
		int index = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
				index = str.charAt(i) - 'A';
			} else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
				index = str.charAt(i) - 'a';
			}
			characters[index] = true;
		}

		for (int i = 0; i < 26; i++) {
			if(characters[i] == false)
				return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		System.out.println("Pangram - " + isPangram("A Quick Brown fox jumps over the lazy dog"));
		System.out.println("Pangram - " + isPangram("A Quick brown jumps over the dog"));

	}

}
