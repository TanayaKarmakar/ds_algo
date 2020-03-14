package com.app.dynamicprogramming.classroom;

//problem statement - find the maximum sum subarray 
//with constraint -- you cannot select contiguous elements
public class MaximumSumSubarrayWithConstraint1 {
	/*
	 * if length == 1 then arr[0] else if length == 2 then return max(arr[0],
	 * arr[1]) else dp[i] = max(dp[i - 1], arr[i] + dp[i - 2])
	 */

	private static int maxSumSubarray(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		dp[0] = nums[0];
		dp[1] = Integer.max(nums[0], nums[1]);

		for (int i = 2; i < n; i++) {
			dp[i] = Integer.max(dp[i - 1], nums[i] + dp[i - 2]);
		}

		return dp[n - 1];
	}

	public static void main(String[] args) {
		int[] nums = { -2, 3, -16, 100, -4, 5 };
		
		int maxSum = maxSumSubarray(nums);
		
		System.out.println("MaxSum - " + maxSum);

	}

}
