package com.app.problems.gfg.dp;

public class SkipTheWork {
	private static int findMin(int[] nums) {
		int n = nums.length;
		int incl = nums[0];
		int excl = 0;

		for (int i = 1; i < n; i++) {
			int inclNew = nums[i] + Integer.min(excl, incl);
			int exclNew = incl;

			incl = inclNew;
			excl = exclNew;
		}
		return Integer.min(incl, excl);
	}

	public static void main(String[] args) {
		int[] nums = { 10, 5, 2, 4, 8, 6, 7, 10 };
		int min = findMin(nums);
		
		System.out.println(min);
	}
}
