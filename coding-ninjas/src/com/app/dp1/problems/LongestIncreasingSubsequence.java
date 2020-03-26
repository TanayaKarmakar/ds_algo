package com.app.dp1.problems;

public class LongestIncreasingSubsequence {
	private static int lis(int[] nums, int size) {
		int[] dp = new int[size];

		dp[0] = 1;
		for (int i = 1; i < size; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = Integer.max(dp[i], dp[j] + 1);
				}
			}
		}

		int ans = 0;
		for (int i = 0; i < size; i++) {
			ans = Integer.max(ans, dp[i]);
		}

		return ans;
	}

	public static void main(String[] args) {
		int[] nums = { 4, 3, 5, 6, 1, 7, 8, 2 };
		int lis = lis(nums, nums.length);

		System.out.println("LIS - " + lis);
	}

}
