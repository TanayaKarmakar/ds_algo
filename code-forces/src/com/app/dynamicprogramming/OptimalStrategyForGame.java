package com.app.dynamicprogramming;

public class OptimalStrategyForGame {
	private static int maxScore(int[] nums) {
		int n = nums.length;
		int[][] dp = new int[n][n];

		for (int g = 0; g < dp.length; g++) {
			for (int i = 0, j = g; j < dp.length; i++, j++) {
				if (g == 0) {
					dp[i][j] = nums[i];
				} else if (g == 1) {
					dp[i][j] = Integer.max(dp[i][j - 1], dp[i + 1][j]);
				} else {
					int option1 = nums[i] + Integer.min(dp[i + 2][j], dp[i + 1][j - 1]);
					int option2 = nums[j] + Integer.min(dp[i + 1][j - 1], dp[i][j - 2]);
					dp[i][j] = Integer.max(option1, option2);
				}
			}
		}

		return dp[0][dp.length - 1];
	}

	public static void main(String[] args) {
		int[] nums = { 20, 30, 2, 10 };
		
		int ans = maxScore(nums);
		
		System.out.println(ans);

	}

}
