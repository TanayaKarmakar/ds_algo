package com.app.practice.array;

public class IsSubsequenceLeetcode392 {
	private static boolean isSubsequence(String s, String t) {
		if(s.length() == 0)
			return true;
		if(t.length() == 0)
			return false;
		int n = s.length();
		int m = t.length();
		
		int i = 0;
		int j = 0;
		while(i < m && j < n) {
			if(s.charAt(j) == t.charAt(i)) {
				j++;
			}
			i++;
		}
		
		return j == n;
	}

	public static void main(String[] args) {
		String s = "abc";
		String t = "ahbgdc";
		
		System.out.println(isSubsequence(s, t));

	}

}
