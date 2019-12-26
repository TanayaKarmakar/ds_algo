package com.app.string.practice;

public class IsomorphicString {
	private static boolean isIsomorphic(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;
		int[] count1 = new int[256];
		int[] count2 = new int[256];

		int n = str1.length();
		for (int i = 0; i < n; i++) {
			count1[str1.charAt(i)]++;
			count2[str2.charAt(i)]++;
		}

		for (int i = 0; i < n; i++) {
			if (count1[str1.charAt(i)] != count2[str2.charAt(i)])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String str1 = "aab";
		String str2 = "xxy";
		
		System.out.println("Isomorphic - " + isIsomorphic(str1, str2));
		
		str1 = "aab";
		str2 = "xyz";
		
		System.out.println("Isomorphic - " + isIsomorphic(str1, str2));

	}

}
