package com.app.dynamicprogramming.classroom;

public class OptimalStrategyForAGameBottomUp {
	private static int getMaxValue(int[] nums) {
		int n = nums.length;
		int[][] dp = new int[n][n];
		
		int i, j;

		for (i = 0; i < n - 1; i++) {
			dp[i][i + 1] = Integer.max(nums[i], nums[i + 1]);
		}

		for (int gap = 0; gap < n; gap++) {
			for (i = 0, j = gap; j < n; i++, j++) {
				int x = 0;
				int y = 0;
				int z = 0;
				if(i + 2 <= j) {
					x = dp[i + 2][j];
				}
				if(i + 1 <= j - 1) {
					y = dp[i + 1][j - 1];
				}
				if(i <= j - 2) {
					z = dp[i][j - 2];
				}
				int option1 = nums[i] + Integer.min(x, y);
				int option2 = nums[j] + Integer.min(y, z);
				dp[i][j] = Integer.max(option1, option2);
			}
		}
		return dp[0][n - 1];
	}

	public static void main(String[] args) {
		int[] nums = { 8, 15, 3, 7 };
		int maxValue = getMaxValue(nums);
		
		System.out.println(maxValue);
	}
}
