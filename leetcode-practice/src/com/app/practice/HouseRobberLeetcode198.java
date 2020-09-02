package com.app.practice;

public class HouseRobberLeetcode198 {
	private static int getMaxMoney(int[] nums) {
		if(nums.length == 0)
			return 0;
		if(nums.length == 1)
			return nums[0];
		int n = nums.length;
		int[] dp = new int[n];
		dp[0] = nums[0];
		dp[1] = Integer.max(nums[0], nums[1]);

		for (int i = 2; i < n; i++) {
			int option1 = dp[i - 1];
			int option2 = nums[i] + dp[i - 2];
			dp[i] = Integer.max(option1, option2);
		}

		return dp[n - 1];
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 1 };

		int maxMoney = getMaxMoney(nums);

		System.out.println(maxMoney);

		nums = new int[] { 2, 7, 9, 3, 1 };
		
		maxMoney = getMaxMoney(nums);
		
		System.out.println(maxMoney);

	}

}
