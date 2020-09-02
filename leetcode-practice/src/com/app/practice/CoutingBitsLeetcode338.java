package com.app.practice;

import java.util.Arrays;

public class CoutingBitsLeetcode338 {
	private static int[] countingBits(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;

		for (int i = 3; i <= n; i++) {
			if (i % 2 == 0) {
				dp[i] = dp[i / 2];
			} else {
				dp[i] = 1 + dp[i - 1];
			}
		}
		return dp;
	}

	public static void main(String[] args) {
		int n = 2;
		System.out.println(Arrays.toString(countingBits(n)));
		
		n = 5;
		
		System.out.println(Arrays.toString(countingBits(n)));
	}

}
