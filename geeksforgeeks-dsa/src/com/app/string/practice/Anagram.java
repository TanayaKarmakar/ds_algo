package com.app.string.practice;

public class Anagram {
	private static boolean isAnagram(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;

		int[] freq = new int[26];
		int n = str1.length();

		for (int i = 0; i < n; i++) {
			int indx = str1.charAt(i) - 'a';
			freq[indx]++;
		}

		for (int i = 0; i < n; i++) {
			int indx = str2.charAt(i) - 'a';
			freq[indx]--;
		}

		for (int i = 0; i < 26; i++) {
			if (freq[i] != 0)
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		String str1 = "cat";
		String str2 = "act";
		
		System.out.println(isAnagram(str1, str2));
		
		str1 = "java";
		str2 = "oava";
		
		System.out.println(isAnagram(str1, str2));
	}

}
