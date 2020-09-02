package com.app.practice.dp;

import java.util.Arrays;

public class JumpGameIILeetcode45 {
	private static int jumps(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		Arrays.fill(dp, Integer.MAX_VALUE);

		dp[0] = 0;
		for (int i = 1; i < n; i++) {
			int subRes = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				if (j + nums[j] >= i) {
					subRes = Integer.min(subRes, dp[j]);
				}
			}
			if (subRes != Integer.MAX_VALUE) {
				dp[i] = Integer.min(dp[i], subRes + 1);
			}
		}
		return dp[n - 1];
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 1, 4 };
		int minJumps = jumps(nums);
		
		System.out.println(minJumps);
	}

}
