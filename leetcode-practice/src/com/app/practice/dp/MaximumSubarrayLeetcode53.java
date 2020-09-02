package com.app.practice.dp;

public class MaximumSubarrayLeetcode53 {
	private static int maxSum(int[] nums) {
		int n = nums.length;
		int maxSum = Integer.MIN_VALUE;
		int currentSum = 0;
		for (int i = 0; i < n; i++) {
			currentSum += nums[i];
			maxSum = Integer.max(maxSum, currentSum);
			if (currentSum < 0)
				currentSum = 0;
		}

		return maxSum;
	}

	public static void main(String[] args) {
		int[] nums = { -1 };
		
		System.out.println(maxSum(nums));

	}

}
