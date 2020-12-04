package com.app.practice.sort;

import java.util.Arrays;

public class SortColorsLeetcode75 {
	private static void swap(int[] nums, int i1, int i2) {
		int tmp = nums[i1];
		nums[i1] = nums[i2];
		nums[i2] = tmp;
	}

	private static void sortColors(int[] nums) {
		int n = nums.length;
		int low = 0;
		int mid = 0;
		int high = n - 1;

		while (mid <= high) {
			int val = nums[mid];

			switch (val) {
			case 0:
				swap(nums, low, mid);
				low++;
				mid++;
				break;

			case 1:
				mid++;
				break;

			case 2:
				swap(nums, mid, high);
				high--;
				break;
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = { 2, 0, 1 };
		
		sortColors(nums);
		
		System.out.println(Arrays.toString(nums));

	}

}
