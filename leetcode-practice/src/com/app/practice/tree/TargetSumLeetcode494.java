package com.app.practice.tree;

public class TargetSumLeetcode494 {
	private static int numWays(int[] nums, int targetSum) {
		int totalSum = 0;
		for (int num : nums) {
			totalSum += num;
		}

		if (targetSum > totalSum || (totalSum + targetSum) % 2 != 0)
			return 0;
		int target = ((totalSum + targetSum) / 2);
		int[][] dp = new int[nums.length + 1][target + 1];

		dp[0][0] = 1;
		for (int i = 1; i <= nums.length; i++) {
			for (int j = 0; j <= target; j++) {
				if (j >= nums[i - 1]) {
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[nums.length][target];
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 1, 1 };
		int target = 3;
		
		System.out.println(numWays(nums, target));

	}

}
