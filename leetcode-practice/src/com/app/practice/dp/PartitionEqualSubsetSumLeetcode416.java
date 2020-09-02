package com.app.practice.dp;

public class PartitionEqualSubsetSumLeetcode416 {
	private static boolean canPartition(int[] nums) {
		int totalSum = 0;
		for (int num : nums) {
			totalSum += num;
		}

		if (totalSum % 2 != 0)
			return false;

		int target = totalSum / 2;
		int n = nums.length;

		boolean[][] dp = new boolean[n][target + 1];

		for (int i = 0; i < n; i++) {
			dp[i][0] = true;
		}

		for (int j = 1; j <= target; j++) {
			if (j == nums[0])
				dp[0][j] = true;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= target; j++) {
				if (dp[i - 1][j])
					dp[i][j] = dp[i - 1][j];
				else if (j >= nums[i])
					dp[i][j] = dp[i - 1][j - nums[i]];
			}
		}
		return dp[n - 1][target];
	}

	public static void main(String[] args) {
		int[] nums = { 1, 5, 11, 5 };

		boolean canPart = canPartition(nums);

		System.out.println(canPart);

		nums = new int[] { 1, 2, 3, 5 };
		
		canPart = canPartition(nums);

		System.out.println(canPart);

	}

}
