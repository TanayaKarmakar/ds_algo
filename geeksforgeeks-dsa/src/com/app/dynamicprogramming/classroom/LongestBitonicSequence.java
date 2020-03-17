package com.app.dynamicprogramming.classroom;

public class LongestBitonicSequence {
	private static int longestBitonicSequence(int[] nums) {
		int n = nums.length;
		int[] lis = new int[n];
		int[] lds = new int[n];

		lis[0] = 1;
		for (int i = 1; i < n; i++) {
			lis[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					lis[i] = Integer.max(lis[i], lis[j] + 1);
				}
			}
		}

		lds[n - 1] = 1;
		for (int i = n - 2; i >= 0; i--) {
			lds[i] = 1;
			for (int j = n - 1; j > i; j--) {
				if (nums[i] > nums[j]) {
					lds[i] = Integer.max(lds[i], lds[j] + 1);
				}
			}
		}

		int max = lis[0] + lds[0] - 1;
		for (int i = 1; i < n; i++) {
			int curr = lis[i] + lds[i] - 1;
			max = Integer.max(curr, max);
		}

		return max;
	}

	public static void main(String[] args) {
		int[] nums = { 12, 3, 8, 7, 10, 15, 5, 4 };

		int max = longestBitonicSequence(nums);
		
		System.out.println("Max - " + max);
	}

}
