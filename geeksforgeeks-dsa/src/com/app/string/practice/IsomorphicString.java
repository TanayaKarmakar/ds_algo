package com.app.string.practice;

public class IsomorphicString {
	private static boolean isIsomorphic(String str1, String str2) {
		char[] s = str1.toCharArray();
		char[] t = str2.toCharArray();
		int[] smap = new int[256];
		int[] tmap = new int[256];
		for (int i = 0; i < s.length; i++) {
			if (smap[s[i]] == 0 && tmap[t[i]] == 0) {
				smap[s[i]] = t[i];
				tmap[t[i]] = s[i];
			} else if (smap[s[i]] != t[i])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		/*String str1 = "aab";
		String str2 = "xxy";

		System.out.println("Isomorphic - " + isIsomorphic(str1, str2));

		str1 = "aab";
		str2 = "xyz";

		System.out.println("Isomorphic - " + isIsomorphic(str1, str2));*/

		String str1 = "abba";
		String str2 = "abab";

		System.out.println("Isomorphic - " + isIsomorphic(str1, str2));

	}

}
