package com.app.practice.dp;

public class IncreasingTripletSubsequence334 {
	private static boolean increasingTriplet(int[] nums) {
		int n = nums.length;
		int small = Integer.MAX_VALUE;
		int big = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			if (nums[i] <= small)
				small = nums[i];
			else if (nums[i] <= big)
				big = nums[i];
			else
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5 };
		boolean ans = increasingTriplet(nums);

		System.out.println(ans);
	}

}
