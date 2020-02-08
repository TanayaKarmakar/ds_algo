package com.app.questions;

import java.util.Arrays;

//variation of counting sort
public class SortColors {
	private static int getMax(int[] nums) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max) {
				max = nums[i];
			}
		}

		return max;
	}

	private static void sortColors(int[] nums) {
		int max = getMax(nums);

		int[] count = new int[max + 1];
		for (int i = 0; i < nums.length; i++) {
			++count[nums[i]];
		}

		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}

		int[] output = new int[nums.length];
		for (int i = nums.length - 1; i >= 0; i--) {
			int indx = count[nums[i]] - 1;
			output[indx] = nums[i];
			count[nums[i]]--;
		}

		for (int i = 0; i < nums.length; i++) {
			nums[i] = output[i];
		}
	}

	public static void main(String[] args) {
		int[] arr = { 2, 0, 2, 1, 1, 0 };

		sortColors(arr);

		System.out.println(Arrays.toString(arr));
	}

}
