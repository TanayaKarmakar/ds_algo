package com.app.dp1.problems;

public class LongestBitonicArray {
	private static int longestBitonicArrayLen(int[] nums, int size) {
		int[] lis = new int[size];
		lis[0] = 1;

		for (int i = 1; i < size; i++) {
			lis[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					lis[i] = Integer.max(lis[i], lis[j] + 1);
				}
			}
		}

		int[] lds = new int[size];
		lds[size - 1] = 1;

		for (int i = size - 2; i >= 0; i--) {
			lds[i] = 1;
			for (int j = size - 1; j > i; j--) {
				if (nums[j] < nums[i]) {
					lds[i] = Integer.max(lds[i], lds[j] + 1);
				}
			}
		}

		int ans = 0;
		for (int i = 0; i < size; i++) {
			int curr = lis[i] + lds[i] - 1;
			ans = Integer.max(ans, curr);
		}

		return ans;
	}

	public static void main(String[] args) {
		int[] nums = { 4, 3, 5, 6, 1, 7, 8, 2 };
		
		int len = longestBitonicArrayLen(nums, nums.length);
		
		System.out.println("Len - " + len);

	}

}
