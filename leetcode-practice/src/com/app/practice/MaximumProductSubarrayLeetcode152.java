package com.app.practice;

public class MaximumProductSubarrayLeetcode152 {
	private static int maximumProduct(int[] nums) {
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
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
				min[i] = Integer.min(nums[i], nums[i] * max[i - 1]);
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
		int maxSum = maximumProduct(nums);

		System.out.println(maxSum);
		nums = new int[] { -2, 0, -1 };
		
		maxSum = maximumProduct(nums);

		System.out.println(maxSum);
	}

}
