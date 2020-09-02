package com.app.practice.array;

public class MaximumSubarrayLeetcode53 {
	private static int maxSubarray(int[] nums) {
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
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int maxSum = maxSubarray(nums);
		
		System.out.println(maxSum);
	}

}
