package com.app.questions;

import java.util.Arrays;

public class SortColourDutchNationalFlag {
	private static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	private static void sortColors(int[] nums) {
		int low = 0;
		int mid = 0;
		int high = nums.length - 1;
		while (mid <= high) {
			switch (nums[mid]) {
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
		int[] arr = { 2, 0, 2, 1, 1, 0 };

		sortColors(arr);

		System.out.println(Arrays.toString(arr));

	}

}
