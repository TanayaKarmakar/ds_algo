package com.app.practice.dp;

import java.util.Arrays;

public class CountingBitsLeetcode338 {
	private static int[] countBits(int num) {
		int[] dp = new int[num + 1];
		dp[0] = 0;

		for (int i = 1; i <= num; i++) {
			if (i % 2 == 0) {
				dp[i] = dp[i / 2];
			} else {
				dp[i] = dp[i - 1] + 1;
			}
		}

		return dp;
	}

	public static void main(String[] args) {
		int num = 5;

		int[] dp = countBits(num);

		System.out.println(Arrays.toString(dp));

	}

}
