package com.app.practice.array;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayIILeetcode80 {
	private static int removeDuplicates(int[] nums) {
		int n = nums.length;

		for (int i = 0; i < n;) {
			int j = i + 1;
			int count = 0;
			while (j < n && nums[i] == nums[j]) {
				count++;
				j++;
			}

			count++;
			if (count > 2) {
				for (int k = i + 2; k < j; k++) {
					nums[k] = Integer.MAX_VALUE;
				}
			}

			i = j;
		}

		int i = -1;
		for (int j = 0; j < n; j++) {
			if (nums[j] != Integer.MAX_VALUE) {
				i++;
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
			}
		}

		System.out.println(Arrays.toString(nums));

		return (i + 1);
	}

	public static void main(String[] args) {
		int[] nums = { 0, 0, 1, 1, 1, 1, 2, 3, 3 };

		int len = removeDuplicates(nums);

		System.out.println(len);

		nums = new int[] { 1, 1, 1, 2, 2, 3 };
		
		len = removeDuplicates(nums);

		System.out.println(len);

	}

}
