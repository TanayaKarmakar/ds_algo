package com.app.dynamicprogramming.classroom;

public class SubsetSumProblem {
	private static int countSubsets(int[] nums, int sum) {
		int n = nums.length;
		int[][] dp = new int[n + 1][sum + 1];

		for (int i = 0; i <= n; i++) {
			dp[i][0] = 1;
		}

		for (int j = 1; j <= sum; j++) {
			dp[0][j] = 0;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (j < nums[i - 1]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
				}
			}
		}

		return dp[n][sum];
	}

	public static void main(String[] args) {
		int[] nums = { 2, 5, 3 };

		int sum = 5;
		
		int numSubsets = countSubsets(nums, sum);
		
		System.out.println("Number of subsets - " + numSubsets);
	}

}
