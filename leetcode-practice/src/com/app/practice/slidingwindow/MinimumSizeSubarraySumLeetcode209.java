package com.app.practice.slidingwindow;

public class MinimumSizeSubarraySumLeetcode209 {
	private static int minSubArrayLen(int s, int[] nums) {
		int n = nums.length;

		int r = 0;
		int l = 0;
		int maxLen = Integer.MAX_VALUE;

		int currentSum = 0;
		while (r < n) {
			currentSum += nums[r];

			while (l <= r && currentSum >= s) {
				if ((r - l + 1) < maxLen) {
					maxLen = (r - l + 1);
				}
				currentSum -= nums[l];
				l++;
			}
			r++;
		}

		return maxLen == Integer.MAX_VALUE ? 0 : maxLen;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 2, 4, 3 };
		int s = 7;

		int maxLen = minSubArrayLen(s, nums);

		System.out.println(maxLen);

	}

}
