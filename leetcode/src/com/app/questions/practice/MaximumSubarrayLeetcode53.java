package com.app.questions.practice;

public class MaximumSubarrayLeetcode53 {
	private static int maxSubarray(int[] nums) {
		int currentMax = 0;
		int maxSoFar = Integer.MIN_VALUE;

		int n = nums.length;

		for (int i = 0; i < n; i++) {
			currentMax += nums[i];
			if (currentMax < 0) {
				currentMax = 0;
			}
			if (currentMax > maxSoFar)
				maxSoFar = currentMax;
		}

		return maxSoFar;
	}

	public static void main(String[] args) {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int maxSum = maxSubarray(nums);
		
		System.out.println(maxSum);

	}

}
