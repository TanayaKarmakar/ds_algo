package com.app.practice;

public class RemoveDuplicatesFromSortedArrayLeetcode80 {
	private static int removeDuplicates(int[] nums) {
		int n = nums.length;
		int i = 0;
		while (i < n) {
			int j = i + 1;
			while (j < n && nums[i] == nums[j])
				j++;
			if ((j - i) <= 2) {
				i = j;
			} else {
				int start = i + 2;
				i = start;
				for (int k = j; k < n; k++) {
					nums[start++] = nums[k];
				}
				n = start;
			}
		}
		return n;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 2, 2, 3 };

		int len = removeDuplicates(nums);

		System.out.println(len);

		nums = new int[] { 0, 0, 1, 1, 1, 1, 2, 3, 3 };
		
		len = removeDuplicates(nums);
		
		System.out.println(len);
	}

}
