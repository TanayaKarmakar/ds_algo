package com.app.questions.practice;

public class RemoveDuplicatesFromSortedArrayLeetcode26 {
	private static int removeDups(int[] nums) {
		int n = nums.length;
		
		int currentNumber = nums[0];
		int j = 1;
		int len = 1;
		
		
		while(j < n) {
			if(nums[j] == currentNumber) {
				j++;
			} else {
				currentNumber = nums[j];
				nums[len] = nums[j];
				len++;
			}
		}
		
		return len;
	}

	private static void printArray(int[] nums, int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(nums[i] + " ");
		}

		System.out.println();
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2 };

		int len = removeDups(nums);

		// System.out.println(len);

		printArray(nums, len);

		nums = new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };

		len = removeDups(nums);

		printArray(nums, len);

		nums = new int[] { 1, 1, 1, 2 };
		
		len = removeDups(nums);
		
		printArray(nums, len);

	}

}
