package com.app.practice.dp;

public class TargetSumLeetcode494 {
	private static int findTargetSumWays(int[] nums, int S) {
		int totalSum = 0;
		for (int el : nums) {
			totalSum += el;
		}

		if (totalSum < S)
			return 0;
		if ((totalSum + S) % 2 != 0)
			return 0;

		int targetSum = (totalSum + S) / 2;
		int[][] dp = new int[nums.length + 1][targetSum + 1];
		dp[0][0] = 1;

		for (int i = 1; i <= nums.length; i++) {
			for (int j = 0; j <= targetSum; j++) {
				if (j >= nums[i - 1])
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
				else
					dp[i][j] = dp[i - 1][j];
			}
		}
		return dp[nums.length][targetSum];
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 1, 1 };
		int targetSum = 3;
		int ans = findTargetSumWays(nums, targetSum);
		
		System.out.println(ans);
	}

}
