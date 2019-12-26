package com.app.string.practice;

public class IsogramString {
	private static boolean isIsogram(String str) {
		int[] freq = new int[26];

		int n = str.length();
		for (int i = 0; i < n; i++) {
			int indx = str.charAt(i) - 'a';
			freq[indx]++;
		}

		for (int i = 0; i < n; i++) {
			int indx = str.charAt(i) - 'a';
			if (freq[indx] > 1)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String str1 = "machine";
		System.out.println("Isogram - " + isIsogram(str1));
		
		str1 = "geeks";
		System.out.println("Isogram - " + isIsogram(str1));
	}

}
