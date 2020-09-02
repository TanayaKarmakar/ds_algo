package com.app.practice.slidingwindow;

public class MinimumWindowSubsequenceLeetcode727 {
	private static String minWindow(String S, String T) {
		int i = 0;
		int j = 0;
		
		int m = S.length();
		int n = T.length();
		
		String minWindow = "";
		int minLen = Integer.MAX_VALUE;
		
		for(i = 0; i < m; i++) {
			if(S.charAt(i) == T.charAt(j)) {
				j++;
				
				if(j == n) {
					int end = i + 1;
					j--;
					
					while(j >= 0) {
						if(S.charAt(i) == T.charAt(j))
							j--;
						i--;
					}
					
					i++;
					j++;
					
					if(minLen > (end - i)) {
						minLen = (end - i);
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
		
		System.out.println(minWindow(S, T));
	}

}
