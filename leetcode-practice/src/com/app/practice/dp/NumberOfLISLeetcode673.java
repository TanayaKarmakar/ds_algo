package com.app.practice.dp;

import java.util.Arrays;

public class NumberOfLISLeetcode673 {
	private static int findNumberOfLIS(int[] nums) {
		int n = nums.length;
		int[] lis = new int[n];
		int[] count = new int[n];

		Arrays.fill(lis, 1);
		Arrays.fill(count, 1);

		int maxLen = 1;

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					if (lis[j] >= lis[i]) {
						lis[i] = lis[j] + 1;
						count[i] = count[j];
					} else if (lis[j] + 1 == lis[i]) {
						count[i] += count[j];
					}
					maxLen = Integer.max(maxLen, lis[i]);
				}
			}
		}

		int totalCount = 0;
		for (int i = 0; i < n; i++) {
			if (lis[i] == maxLen)
				totalCount += count[i];
		}
		
		return totalCount;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, 5, 4, 7 };

		int count = findNumberOfLIS(nums);
		System.out.println(count);

	}

}
