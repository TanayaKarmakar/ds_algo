package com.app.practice;

import java.util.Arrays;

public class SortColorsLeetcode75 {
	private static void swap(int[] nums, int i1, int i2) {
		int temp = nums[i1];
		nums[i1] = nums[i2];
		nums[i2] = temp;
	}

	private static void sortColors(int[] nums) {
		int n = nums.length;
		int low = 0;
		int mid = 0;
		int high = n - 1;
		while (mid <= high) {
			switch (nums[mid]) {
			case 0:
				swap(nums, low, mid);
				low++;
				mid++;
				continue;
			case 1:
				mid++;
				continue;
			case 2:
				swap(nums, mid, high);
				high--;
				continue;
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = { 2, 0, 2, 1, 1, 0 };
		
		sortColors(nums);
		
		System.out.println(Arrays.toString(nums));

	}

}
