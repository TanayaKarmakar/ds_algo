package com.app.practice;

public class PartitionEqualSubsetSumLeetcode416 {
	private static boolean partitionEqualSubsetSum(int[] nums) {
		int totalSum = 0;
		for (int num : nums) {
			totalSum += num;
		}

		if (totalSum % 2 != 0)
			return false;

		int targetSum = totalSum / 2;
		int n = nums.length;
		boolean[][] dp = new boolean[n][targetSum + 1];
		for (int i = 0; i < n; i++) {
			dp[i][0] = true;
		}

		for (int i = 1; i <= targetSum; i++) {
			if (i == nums[0])
				dp[0][i] = true;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= targetSum; j++) {
				if(dp[i - 1][j])
					dp[i][j] = dp[i - 1][j];
				else if (j >= nums[i]) {
					dp[i][j] = dp[i - 1][j - nums[i]];
				}
			}
		}

		return dp[n - 1][targetSum];
	}

	public static void main(String[] args) {
		int[] nums = { 1, 5, 11, 5 };

		System.out.println(partitionEqualSubsetSum(nums));

		nums = new int[] { 1, 2, 3, 5 };
		
		System.out.println(partitionEqualSubsetSum(nums));

	}

}
