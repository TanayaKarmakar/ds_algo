package com.app.questions.read;

import java.util.Arrays;

public class NextPermutationLeetcode31 {
	private static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	private static void reverse(int[] nums, int start, int end) {
		while (start < end) {
			swap(nums, start, end);
			start++;
			end--;
		}
	}

	private static void nextPermutation(int[] nums) {
		int n = nums.length;
		int k = n - 2;

		while (k >= 0 && nums[k] > nums[k + 1]) {
			k--;
		}

		if (k == -1)
			reverse(nums, 0, n - 1);

		for (int l = n - 1; l > k; l--) {
			if (nums[l] > nums[k]) {
				swap(nums, l, k);
				break;
			}
		}

		reverse(nums, k + 1, n - 1);
	}

	public static void main(String[] args) {
		int[] nums = { 6, 2, 1, 5, 4, 3, 0 };
		
		nextPermutation(nums);
		
		System.out.println(Arrays.toString(nums));
	}

}
