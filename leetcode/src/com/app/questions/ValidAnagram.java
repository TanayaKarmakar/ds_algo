package com.app.questions;

public class ValidAnagram {
	private static boolean isAnagram1(String s, String t) {
		if (s.length() != t.length())
			return false;
		int sFreq[] = new int[256];
		// int tFreq[] = new int[256];

		for (int i = 0; i < s.length(); i++) {
			sFreq[s.charAt(i)]++;
			sFreq[t.charAt(i)]--;
		}

		for (int i = 0; i < 256; i++) {
			if (sFreq[i] != 0)
				return false;
		}

		return true;
	}

	private static boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		int sFreq[] = new int[256];
		int tFreq[] = new int[256];

		for (int i = 0; i < s.length(); i++) {
			sFreq[s.charAt(i)]++;
			tFreq[t.charAt(i)]++;
		}

		for (int i = 0; i < 256; i++) {
			if (sFreq[i] != tFreq[i])
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println("Valid anagram - " + isAnagram("anagram", "nagaram"));
		System.out.println("Valid anagram1 - " + isAnagram1("anagram", "nagaram"));
		System.out.println("Valid anagram - " + isAnagram("rat", "car"));
		System.out.println("Valid anagram1 - " + isAnagram1("rat", "car"));

	}

}
