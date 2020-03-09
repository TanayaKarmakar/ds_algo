package com.app.dynamicprogramming.classroom;

//approach1 -- O(n^2)
public class LongestIncreasingSubsequence {
	private static int lis(int[] nums) {
		int n = nums.length;
		int[] lis = new int[n];
		lis[0] = 1;
		for (int i = 1; i < n; i++) {
			lis[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i])
					lis[i] = Integer.max(lis[i], lis[j] + 1);
			}
		}

		int res = lis[0];
		for (int i = 1; i < n; i++) {
			res = Integer.max(res, lis[i]);
		}

		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 4, 2, 8, 10 };
		
		System.out.println("LIS - " + lis(nums));

	}

}
