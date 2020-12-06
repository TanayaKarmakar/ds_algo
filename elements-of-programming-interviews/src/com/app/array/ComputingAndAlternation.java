package com.app.array;

import java.util.Arrays;

public class ComputingAndAlternation {
	private static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	private static void computeAlternation(int[] nums) {
		Arrays.sort(nums);

		int n = nums.length;
		for (int i = 1; i < n; i += 2) {
			swap(nums, i - 1, i);
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 5, 3, 2, 4 };

		computeAlternation(nums);

		System.out.println(Arrays.toString(nums));

	}

}
