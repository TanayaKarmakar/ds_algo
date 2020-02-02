package com.app.questions;

import java.util.Arrays;

public class RemoveElement {
	private static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	private static int removeElement(int[] nums, int val) {
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0] != val ? nums.length : 0;
		int n = nums.length;
		int pivot = n - 1;
		int i = -1;
	
		for (int j = 0; j < n; j++) {
			if (nums[j] != val) {
				i++;
				swap(nums, i, j);
			}
		}

		if (i < (n - 1) && nums[pivot] != val) {
			swap(nums, i + 1, pivot);
		}

		return i + 1;
	}

	public static void main(String[] args) {
		int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };

		int len = removeElement(nums, 2);

		System.out.println(len);

		System.out.println(Arrays.toString(nums));

		nums = new int[] { 3, 2, 2, 3 };

		len = removeElement(nums, 3);

		System.out.println(len);

		System.out.println(Arrays.toString(nums));

		nums = new int[] { 3, 3 };

		len = removeElement(nums, 3);

		System.out.println(len);

		System.out.println(Arrays.toString(nums));

		nums = new int[] { 5, 5 };

		len = removeElement(nums, 3);

		System.out.println(len);

		System.out.println(Arrays.toString(nums));
	}

}
