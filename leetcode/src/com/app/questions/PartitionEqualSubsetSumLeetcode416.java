package com.app.questions;

public class PartitionEqualSubsetSumLeetcode416 {
	private static boolean canPartition(int[] nums) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}

		if (sum % 2 != 0)
			return false;

		int n = nums.length;
		boolean[][] dp = new boolean[n][sum / 2 + 1];

		for (int i = 0; i < n; i++) {
			dp[i][0] = true;
		}

		for (int i = 1; i <= sum / 2; i++) {
			if (i == nums[0]) {
				dp[0][i] = true;
			} else {
				dp[0][i] = false;
			}
		}

		// System.out.println(Arrays.deepToString(dp));

		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= sum / 2; j++) {
				if (dp[i - 1][j]) {
					dp[i][j] = dp[i - 1][j];
				} else if (nums[i] <= j) {
					dp[i][j] = dp[i - 1][j - nums[i]];
				}
			}
		}

		return dp[n - 1][sum / 2];
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
