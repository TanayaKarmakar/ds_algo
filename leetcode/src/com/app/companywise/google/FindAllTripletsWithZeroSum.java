package com.app.companywise.google;

import java.util.Arrays;

public class FindAllTripletsWithZeroSum {
	private static void zeroSum(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length;
		for (int i = 0; i < n - 1; i++) {
			int k = nums[i];
			int start = i + 1;
			int end = n - 1;
			while (start < end) {
				int sum = nums[start] + nums[end];
				if (sum + k == 0) {
					System.out.println(k + " " + nums[start] + " " + nums[end]);
					start++;
					end--;
				} else if (k + sum < 0)
					start++;
				else
					end--;
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = {0, -1, 2, -3, 1};
		zeroSum(nums);

	}

}
