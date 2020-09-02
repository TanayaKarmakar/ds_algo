package com.app.practice;

public class MaximumSubarrayLeetcode53 {
	private static int maxSubArray(int[] nums) {
		int maxSum = Integer.MIN_VALUE;
		int currentSum = 0;

		int n = nums.length;
		for (int i = 0; i < n; i++) {
			currentSum += nums[i];
			if (currentSum < 0)
				currentSum = 0;
			maxSum = Integer.max(currentSum, maxSum);
		}

		return maxSum;
	}

	public static void main(String[] args) {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int maxSum = maxSubArray(nums);
		
		System.out.println(maxSum);

	}

}
