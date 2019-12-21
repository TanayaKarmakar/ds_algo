package com.app.string.classroom;

public class AnagramEfficient {
	private static boolean isAnagramEfficient(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;
		int[] freq = new int[256];

		int n = str1.length();
		for (int i = 0; i < n; i++) {
			int charVal = (int) str1.charAt(i);
			freq[charVal]++;
		}

		for (int i = 0; i < n; i++) {
			int charVal = (int) str2.charAt(i);
			freq[charVal]--;
		}

		for (int i = 0; i < 256; i++) {
			if (freq[i] != 0)
				return false;
		}

		return true;

	}

	public static void main(String[] args) {
		System.out.println("Is Anagram " + isAnagramEfficient("geeks", "ekegs"));
		System.out.println("Is Anagram " + isAnagramEfficient("aabcd", "abbcd"));

	}

}
