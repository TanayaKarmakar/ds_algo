package com.app.questions.read;

public class PalindromicSubstringLeetcode647 {
	private static int palindromicSubstrings(String str) {
		int n = str.length();
		int count = 0;
		boolean[][] dp = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			dp[i][i] = true;
			count++;
		}
		
		for(int i = 1; i < n; i++) {
			if(str.charAt(i - 1) == str.charAt(i)) {
				dp[i - 1][i] = true;
				count++;
			}
		}
		
		for(int j = 2; j < n; j++) {
			for(int i = 0; i < j; i++) {
				if(str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1]) {
					dp[i][j] = true;
					count++;
				}
			}
		}
		
		return count;
	}

	public static void main(String[] args) {
		String str = "aaa";
		
		int count = palindromicSubstrings(str);
		
		System.out.println(count);

	}

}
