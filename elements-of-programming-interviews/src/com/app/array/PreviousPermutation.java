package com.app.array;

import java.util.Arrays;

public class PreviousPermutation {
	private static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	private static int[] previousPermutation(int[] nums) {
		int n = nums.length;
		int k = -1;

		for (int i = n - 2; i >= 0; i--) {
			if (nums[i] > nums[i + 1]) {
				k = i;
				break;
			}
		}

		if (k == -1)
			return new int[] {};

		for (int i = n - 1; i > k; i--) {
			if (nums[k] > nums[i]) {
				swap(nums, k, i);
				break;
			}
		}

		int start = k + 1;
		int end = n - 1;
		while (start < end) {
			swap(nums, start, end);
			start++;
			end--;
		}

		return nums;
	}

	public static void main(String[] args) {
		int[] nums = { 6, 2, 3, 0, 1, 4, 5 };

		nums = previousPermutation(nums);
		System.out.println(Arrays.toString(nums));

		nums = new int[] { 1, 2, 4, 3 };

		nums = previousPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}

}
