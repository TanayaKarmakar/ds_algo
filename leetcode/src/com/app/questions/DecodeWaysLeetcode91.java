package com.app.questions;

public class DecodeWaysLeetcode91 {
	private static int decodeWays(String s) {
		if(s.length() == 0)
			return 1;
		if(s.length() == 1) {
			return s.charAt(0) == '0' ? 0: 1;
		}
		int n = s.length();
		
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = s.charAt(0) == '0' ? 0 : 1;
		for(int i = 2; i <= n; i++) {
			dp[i] = 0;
			if(s.charAt(i - 1) > '0') {
				dp[i] = dp[i - 1];
			}
			if(s.charAt(i - 2) == '1' || 
					(s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7')) {
				dp[i] += dp[i - 2];
			}
		}
		return dp[n];
	}
	

	public static void main(String[] args) {
//		System.out.println(decodeWays("12"));
//		System.out.println(decodeWays("226"));
//		System.out.println(decodeWays(""));
		System.out.println(decodeWays("01"));

	}

}
