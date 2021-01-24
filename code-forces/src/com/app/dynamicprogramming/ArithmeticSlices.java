package com.app.dynamicprogramming;

public class ArithmeticSlices {
	private static int totalAP(int[] nums) {
		int[] dp = new int[nums.length];
		int ans = 0;

		for (int i = 2; i < nums.length; i++) {
			if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
				dp[i] = 1 + dp[i - 1];
				ans += dp[i];
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 5, 9, 12, 15, 18, 22, 26, 30, 34, 36, 38, 40, 41 };
		int ans = totalAP(nums);
		
		System.out.println(ans);

	}

}
