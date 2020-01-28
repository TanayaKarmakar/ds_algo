package com.app.questions;

import java.util.Arrays;

public class RemoveDuplicates {
	private static int removeDuplicatesEfficient(int[] nums) {
		if (nums.length <= 1)
			return nums.length;
		int currentNumber = nums[0];
		int j = 1;
		int n = nums.length;
		int len = 1;

		while (j < n) {
			if (nums[j] == currentNumber)
				j++;
			else {
				currentNumber = nums[j];
				nums[len] = nums[j];
				len++;
			}
		}
		return len;
	}

	private static int removeDuplicates(int[] nums) {
		if (nums.length == 1)
			return 0;
		int n = nums.length;
		int i = 0;
		int j = i + 1;
		int k = j;
		int modCount = 0;
		while (i < n) {
			j = i + 1;
			k = j;
			while (j < n && nums[i] == nums[j]) {
				nums[j] = Integer.MIN_VALUE;
				// k = j;
				j++;
				// nums[k] = nums[j];
				modCount++;
			}
			i = j;
		}

		return n - modCount;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2 };

		System.out.println(removeDuplicates(nums));
		System.out.println(Arrays.toString(nums));
		
		nums = new int[] {1,1,2};
		System.out.println(removeDuplicatesEfficient(nums));

		System.out.println(Arrays.toString(nums));

		nums = new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };

		System.out.println(removeDuplicates(nums));
		
		System.out.println(Arrays.toString(nums));
		
		nums = new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		
		System.out.println(removeDuplicatesEfficient(nums));

		System.out.println(Arrays.toString(nums));

	}

}
