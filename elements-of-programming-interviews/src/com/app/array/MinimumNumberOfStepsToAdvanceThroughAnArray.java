package com.app.array;

import java.util.Arrays;

public class MinimumNumberOfStepsToAdvanceThroughAnArray {
	private static int minJumps(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 1; i < n; i++) {
			int subRes = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				if (j + nums[j] >= i) {
					subRes = Integer.min(dp[j], subRes);
				}
			}
			if (subRes != Integer.MAX_VALUE)
				dp[i] = Integer.min(dp[i], subRes + 1);
		}
		return dp[n - 1];
	}

	public static void main(String[] args) {
		int[] nums = { 3, 3, 1, 0, 2, 0, 1 };
		int ans = minJumps(nums);
		
		System.out.println(ans);

	}

}
