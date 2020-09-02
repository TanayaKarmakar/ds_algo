package com.app.practice.dp;

public class HouseRobberLeetcode198 {
	private static int rob(int[] nums) {
		if(nums.length == 0)
			return 0;
		if(nums.length == 1)
			return nums[0];
		int n = nums.length;
		int[] dp = new int[n];
		dp[0] = nums[0];
		dp[1] = Integer.max(dp[0], nums[1]);

		for (int i = 2; i < n; i++) {
			dp[i] = Integer.max(dp[i - 1], nums[i] + dp[i - 2]);
		}

		return dp[n - 1];
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 1 };
		int maxMoney = rob(nums);
		
		System.out.println(maxMoney);
	}

}
