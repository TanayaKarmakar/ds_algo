package com.app.practice;

import java.util.Arrays;

public class JumpGameLeetcode55 {
	private static boolean canJump(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];

		Arrays.fill(dp, Integer.MAX_VALUE);

		dp[0] = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (j + nums[j] >= i) {
					if (dp[j] != Integer.MAX_VALUE) {
						dp[i] = Integer.min(dp[i], dp[j] + 1);
					}
				}
			}
		}
		return dp[n - 1] == Integer.MAX_VALUE ? false : true;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 1, 4 };

		System.out.println(canJump(nums));

		nums = new int[] { 3, 2, 1, 0, 4 };

		System.out.println(canJump(nums));
	}

}
