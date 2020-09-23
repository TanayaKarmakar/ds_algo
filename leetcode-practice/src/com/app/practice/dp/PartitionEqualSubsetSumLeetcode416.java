package com.app.practice.dp;

public class PartitionEqualSubsetSumLeetcode416 {
	private static boolean canPartition(int[] nums) {
		int totalSum = 0;
		for (int el : nums) {
			totalSum += el;
		}

		if (totalSum % 2 != 0)
			return false;
		int targetSum = totalSum / 2;
		int n = nums.length;
		boolean[][] dp = new boolean[n][targetSum + 1];

		for (int i = 0; i < n; i++) {
			dp[i][0] = true;
		}

		for (int j = 1; j <= targetSum; j++) {
			if (j == nums[0])
				dp[0][j] = true;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= targetSum; j++) {
				if (dp[i - 1][j])
					dp[i][j] = dp[i - 1][j];
				if (j >= nums[i])
					dp[i][j] = dp[i][j] | dp[i - 1][j - nums[i]];
			}
		}
		return dp[n - 1][targetSum];
	}

	public static void main(String[] args) {
		int[] nums = { 1, 5, 11, 5 };

		boolean ans = canPartition(nums);

		System.out.println(ans);

		nums = new int[] { 1, 2, 3, 5 };
		
		ans = canPartition(nums);

		System.out.println(ans);
	}

}
