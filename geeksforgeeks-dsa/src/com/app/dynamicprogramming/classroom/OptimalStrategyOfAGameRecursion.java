package com.app.dynamicprogramming.classroom;

public class OptimalStrategyOfAGameRecursion {
	private static int solve(int[] nums, int i, int j) {
		if (i + 1 == j)
			return Integer.max(nums[i], nums[j]);
		else {
			int option1 = nums[i] + Integer.min(solve(nums, i + 2, j), solve(nums, i + 1, j - 1));

			int option2 = nums[j] + Integer.min(solve(nums, i, j - 2), solve(nums, i + 1, j - 1));
			return Integer.max(option1, option2);
		}
	}

	private static int getMaxValue(int[] nums) {
		return solve(nums, 0, nums.length - 1);
	}

	public static void main(String[] args) {
		int[] nums = { 8, 15, 3, 7 };
		
		int maxValue = getMaxValue(nums);
		
		System.out.println(maxValue);

	}

}
