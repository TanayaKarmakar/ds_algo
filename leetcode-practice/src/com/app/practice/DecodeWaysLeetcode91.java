package com.app.practice;

public class DecodeWaysLeetcode91 {
	private static int decodeWays(String digits) {
		int n = digits.length();
		
		int []dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = digits.charAt(0) == '0'? 0: 1;
		
		for(int i = 2; i <= n; i++) {
			if(digits.charAt(i - 1) > '0') {
				dp[i] = dp[i - 1];
			}
			if(digits.charAt(i - 2) == '1' 
					|| (digits.charAt(i - 2) == '2' && digits.charAt(i - 1) < '7')) {
				dp[i] += dp[i - 2];
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		System.out.println(decodeWays("12"));
		System.out.println(decodeWays("226"));

	}

}
