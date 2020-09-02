package com.app.practice;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayLeetcode26 {
	private static int removeDuplicates(int[] nums) {
		int n = nums.length;
		int i = 0;

		int currentNumber = nums[0];
		int len = 1;
		while(i < n) {
			if(nums[i] == currentNumber)
				i++;
			else {
				currentNumber = nums[i];
				nums[len] = currentNumber;
				len++;
			}
		}

		return len;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2 };

		int len = removeDuplicates(nums);

		System.out.println(len);

		System.out.println(Arrays.toString(nums));

		nums = new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		
		len = removeDuplicates(nums);

		System.out.println(len);

		System.out.println(Arrays.toString(nums));
	}

}
