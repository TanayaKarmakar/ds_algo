package com.app.practice;

public class MinimumSizeSubarraySumLeetcode209 {
	private static int minsizeSubarray(int[] nums, int target) {
		int preSum = 0;
		int n = nums.length;

		int l = 0;
		int r = 0;
		int minLen = n;

		while (r < n) {
			preSum += nums[r];
			while (l <= r && preSum >= target) {
				if (minLen > (r - l + 1))
					minLen = r - l + 1;
				preSum -= nums[l];
				l++;
			}
			r++;
		}
		return minLen == n ? 0 : minLen;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 2, 4, 3 };
		int s = 7;
		
		System.out.println(minsizeSubarray(nums, s));
	}

}
