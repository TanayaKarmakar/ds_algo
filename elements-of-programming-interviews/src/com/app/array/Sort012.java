package com.app.array;

import java.util.Arrays;

public class Sort012 {
	private static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	private static void sort(int[] nums) {
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
		int[] nums = { 1, 0, 2, 2, 1, 0, 0, 1 };
		sort(nums);
		
		System.out.println(Arrays.toString(nums));
	}

}
