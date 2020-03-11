package com.app.questions;

public class LongestIncreasingSubsequence {
	private static int lengthOfLIS(int[] nums) {
		if (nums.length <= 1)
			return nums.length;
		int n = nums.length;
		int[] lis = new int[n];

		lis[0] = 1;
		for (int i = 1; i < n; i++) {
			lis[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					lis[i] = Integer.max(lis[i], lis[j] + 1);
				}
			}
		}

		int res = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			res = Integer.max(res, lis[i]);
		}

		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };

		System.out.println(lengthOfLIS(nums));
	}

}
