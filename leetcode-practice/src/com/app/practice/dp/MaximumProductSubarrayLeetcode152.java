package com.app.practice.dp;

public class MaximumProductSubarrayLeetcode152 {
	private static int maximumProductSubarray(int[] nums) {
		int n = nums.length;
		int[] max = new int[n];
		int[] min = new int[n];

		max[0] = nums[0];
		min[0] = nums[0];

		for (int i = 1; i < n; i++) {
			if (nums[i] > 0) {
				max[i] = Integer.max(nums[i], nums[i] * max[i - 1]);
				min[i] = Integer.min(nums[i], nums[i] * min[i - 1]);
			} else {
				max[i] = Integer.max(nums[i], nums[i] * min[i - 1]);
				min[i] = Integer.max(nums[i], nums[i] * max[i - 1]);
			}
		}

		int totalMax = 0;
		for (int i = 0; i < n; i++) {
			totalMax = Integer.max(totalMax, max[i]);
		}

		return totalMax;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, -2, 4 };
		
		int max = maximumProductSubarray(nums);
		
		System.out.println(max);

	}

}
