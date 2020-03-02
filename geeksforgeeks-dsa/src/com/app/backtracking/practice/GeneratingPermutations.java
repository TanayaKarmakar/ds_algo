package com.app.backtracking.practice;

import java.util.Arrays;

//Generating permutations recursive method
public class GeneratingPermutations {
	private static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	private static void permute(int[] nums, int n) {
		if (n == 1) {
			System.out.println(Arrays.toString(nums));
			return;
		}
		for (int i = 0; i < n; i++) {
			swap(nums, i, n - 1);
			permute(nums, n - 1);
			swap(nums, i, n - 1);
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4};
		permute(nums, nums.length);
	}

}
