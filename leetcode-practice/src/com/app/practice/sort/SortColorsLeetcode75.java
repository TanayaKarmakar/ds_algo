package com.app.practice.sort;

import java.util.Arrays;

public class SortColorsLeetcode75 {
	private static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	private static void sortColors(int[] nums) {
		int n = nums.length;
		int low = 0;
		int mid = 0;
		int high = n - 1;

		while (mid < high) {
			int el = nums[mid];
			switch (el) {
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
		int[] nums = { 2, 0, 2, 1, 1, 0 };
		
		sortColors(nums);
		
		System.out.println(Arrays.toString(nums));
	}

}
