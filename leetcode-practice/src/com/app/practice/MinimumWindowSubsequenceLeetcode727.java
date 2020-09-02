package com.app.practice;

public class MinimumWindowSubsequenceLeetcode727 {
	private static String minWindowSubstring(String S, String T) {
		int m = S.length();
		int n = T.length();
		
		int min = S.length() + 1;
		String minWindow = "";
		
		int j = 0;
		for(int i = 0; i < m; i++) {
			if(S.charAt(i) == T.charAt(j)) {
				j++;
				if(j == n) {
					int end = i + 1;
					j--;
					
					while(j >= 0) {
						if(S.charAt(i) == T.charAt(j)) {
							j--;
						}
						i--;
					}
					i++;
					j++;
					
					if(min > end - i) {
						min = end - i;
						minWindow = S.substring(i, end);
					}
				}
			}
		}
		return minWindow;
	}

	public static void main(String[] args) {
		String S = "abcdebdde";
		String T = "bde";
		
		System.out.println(minWindowSubstring(S, T));

	}

}
