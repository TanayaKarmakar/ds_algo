package com.app.questions.practice;

public class MinimumSizeSubarraySum {
	private static int minSizeSubarraySum(int[] nums, int sum) {
		int n = nums.length;
		int res = Integer.MAX_VALUE;

		int l = 0;
		int r = 0;
		int currSum = 0;
		while (r < n) {
			currSum += nums[r];

			while (l <= r && currSum >= sum) {
				res = Integer.min((r - l + 1), res);
				currSum -= nums[l];
				l++;
			}
			r++;
		}
		return res;

	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 2, 4, 3 };
		int sum = 7;
		
		int minWindowSize = minSizeSubarraySum(nums, sum);
		
		System.out.println(minWindowSize);

	}

}
