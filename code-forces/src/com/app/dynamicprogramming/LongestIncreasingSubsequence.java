package com.app.dynamicprogramming;

public class LongestIncreasingSubsequence {
	private static int findLIS(int[] nums) {
		int maxLen = 1;
		int n = nums.length;
		int[] lis = new int[n];
		lis[0] = 1;

		for (int i = 1; i < n; i++) {
			lis[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					lis[i] = Integer.max(lis[j] + 1, lis[i]);
				}
			}
			maxLen = Integer.max(maxLen, lis[i]);
		}

		return maxLen;
	}

	public static void main(String[] args) {
		int[] nums = { 10, 22, 9, 33, 21, 50, 41, 60, 80, 1 };
		int maxLen = findLIS(nums);
		
		System.out.println(maxLen);

	}

}
