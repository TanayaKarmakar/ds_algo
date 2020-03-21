package com.app.questions;

public class MaximumProductSubarrayLeetcode152 {
	private static int maxProduct(int[] nums) {
		if(nums.length == 1)
			return nums[0];
		int n = nums.length;
		int min = 0;
		int max = 0;
		int totalMax = 0;

		for (int i = 0; i < n; i++) {
			int num = nums[i];
			int prevMin = min * num;
			int prevMax = max * num;

			min = Integer.min(num, Integer.min(prevMax, prevMin));
			max = Integer.max(num, Integer.max(prevMax, prevMin));

			totalMax = Integer.max(totalMax, max);
		}

		return totalMax;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, -2, 4 };
		
		System.out.println(maxProduct(nums));
	}

}
