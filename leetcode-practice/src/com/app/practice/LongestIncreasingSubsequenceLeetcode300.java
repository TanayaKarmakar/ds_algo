package com.app.practice;

import java.util.Arrays;

public class LongestIncreasingSubsequenceLeetcode300 {
	private static int lis(int[] nums) {
		if (nums.length <= 1)
			return nums.length;
		int n = nums.length;

		int[] lis = new int[n];
		lis[0] = 1;

		int maxLen = 1;
		for (int i = 1; i < n; i++) {
			lis[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					lis[i] = Integer.max(lis[i], lis[j] + 1);
				}
			}
			maxLen = Integer.max(maxLen, lis[i]);
		}
		return maxLen;
	}

	public static void main(String[] args) {
		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		
		int maxLen = lis(nums);
		System.out.println(maxLen);

	}

}
