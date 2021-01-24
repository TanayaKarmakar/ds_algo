package com.app.practice.array;

public class MaximumSubarrayLeetcode53 {
	private static int maxSubArray(int[] nums) {
		int currentSum = 0;
		int maxSum = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			currentSum += nums[i];
			maxSum = Integer.max(maxSum, currentSum);
			if (currentSum < 0)
				currentSum = 0;
		}

		return maxSum;
	}

	public static void main(String[] args) {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		
		int ans = maxSubArray(nums);
		
		System.out.println(ans);
	}

}
