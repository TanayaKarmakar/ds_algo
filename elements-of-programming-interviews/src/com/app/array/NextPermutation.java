package com.app.array;

import java.util.Arrays;

public class NextPermutation {
	private static int[] nextPermutation(int[] nums) {
		int n = nums.length;
		int k = -1;
		for (int i = n - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				k = i;
				break;
			}
		}

		if (k == -1)
			return new int[] {};
		for (int i = k + 1; i < n; i++) {
			if (nums[i] < nums[k]) {
				int tmp = nums[i - 1];
				nums[i - 1] = nums[k];
				nums[k] = tmp;
				break;
			}
		}

		int start = k + 1;
		int end = n - 1;
		while (start < end) {
			int tmp = nums[start];
			nums[start] = nums[end];
			nums[end] = tmp;
			start++;
			end--;
		}

		return nums;
	}

	public static void main(String[] args) {
		int[] nums = { 6, 2, 1, 5, 4, 3, 0 };
		nums = nextPermutation(nums);

		System.out.println(Arrays.toString(nums));

		nums = new int[] { 0, 1, 2, 3, 4, 5, 6 };
		
		nums = nextPermutation(nums);

		System.out.println(Arrays.toString(nums));

	}

}
