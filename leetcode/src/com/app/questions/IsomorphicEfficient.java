package com.app.questions;

public class IsomorphicEfficient {
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
		System.out.println(isIsomorphic("egg", "add"));
		System.out.println(isIsomorphic("foo", "bar"));
		System.out.println(isIsomorphic("paper", "title"));
		System.out.println(isIsomorphic("abba", "abab"));

	}

}
