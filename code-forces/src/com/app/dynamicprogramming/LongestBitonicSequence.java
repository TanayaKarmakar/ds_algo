package com.app.dynamicprogramming;

public class LongestBitonicSequence {
	private static int findLBS(int[] nums) {
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

		int[] lds = new int[n];
		lds[n - 1] = 1;
		for (int i = n - 2; i >= 0; i--) {
			lds[i] = 1;
			for (int j = i + 1; j < n; j++) {
				if (nums[j] < nums[i]) {
					lds[i] = Integer.max(lds[i], lds[j] + 1);
				}
			}
		}

		int maxLBS = 1;
		for (int i = 0; i < n; i++) {
			maxLBS = Integer.max(maxLBS, lis[i] + lds[i] - 1);
		}

		return maxLBS;
	}

	public static void main(String[] args) {
		int[] nums = { 10, 22, 9, 33, 21, 50, 41, 60, 80, 3 };
		int ans = findLBS(nums);
		
		System.out.println(ans);
	}

}
