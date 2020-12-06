package com.app.array;

public class RemoveDuplicatesFromSortedArray {
	private static int removeDuplicates(int[] nums) {
		if (nums.length < 2)
			return nums.length;
		int len = 1;
		int current = nums[0];
		int i = 1;
		int n = nums.length;

		while (i < n) {
			if (current == nums[i])
				i++;
			else {
				current = nums[i];
				nums[len] = current;
				len++;
				i++;
			}
		}

		return len;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 5, 5, 7, 11, 11, 11, 13 };
		
		int len = removeDuplicates(nums);
		
		System.out.println(len);
		
		for(int i = 0; i < len; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
	}

}
