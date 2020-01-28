package com.app.questions;

public class MinimumSizeSubArraySum {
	// without sorting
	private static int minSum(int s, int[] nums) {
		int start = 0;
		int end = 0;
		int n = nums.length;

		int res = Integer.MAX_VALUE;

		int currSum = 0;
		for (end = 0; end < n; end++) {
			currSum += nums[end];

			while (currSum >= s && start <= end) {
				res = Integer.min(res, end - start + 1);
				currSum -= nums[start];
				start++;
			}
		}
		return res == Integer.MAX_VALUE ? 0 : res;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 2, 4, 3 };
		System.out.println(minSum(7, nums));

	}

}
