package com.app.practice.slidingwindow;

public class MinimumSizeSubarraySumLeetcode209 {
	private static int minSubArrayLen(int s, int[] nums) {
		int n = nums.length;
		int l = 0;
		int r = 0;
		int minLen = n;
		int preSum = 0;
		while (r < n) {
			preSum += nums[r];
			while (l <= r && preSum >= s) {
				if (minLen > (r - l + 1))
					minLen = (r - l + 1);
				preSum -= nums[l];
				l++;
			}
			r++;
		}
		return minLen;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 2, 4, 3 };
		int s = 7;
		
		int len = minSubArrayLen(s, nums);
		System.out.println(len);
	}

}
