package com.app.dynamicprogramming.classroom;

public class MaximumSubSubarrayConstraint2 {
	private static int getMaxSum(int[] nums) {
		int n = nums.length;

		int[] dp = new int[n];
		dp[0] = nums[0];
		dp[1] = Integer.max(nums[0], Integer.max(nums[1], nums[0] + nums[1]));
		dp[2] = Integer.max(dp[1], Integer.max(dp[0] + nums[2], nums[1] + nums[2]));

		for (int i = 3; i < n; i++) {
			dp[i] = Integer.max(nums[i] + nums[i - 1] + dp[i - 3], 
					Integer.max(nums[i] + dp[i - 2], dp[i - 1]));
		}

		return dp[n - 1];
	}

	public static void main(String[] args) {
		int[] nums = { 2, 13, 16, 100, 4, 5 };
		
		int maxSum = getMaxSum(nums);
		
		System.out.println("MaxSum - " + maxSum);

	}

}
