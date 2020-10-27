package com.app.practice.array;

public class RemoveElementLeetcode72 {
	private static int removeElement(int[] nums, int val) {
		int n = nums.length;
		int i = -1;

		for (int j = 0; j < n; j++) {
			if (nums[j] != val) {
				i++;
				int tmp = nums[j];
				nums[j] = nums[i];
				nums[i] = tmp;
			}
		}

		return (i + 1);
	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 2, 3 };
		int val = 3;
		
		int len = removeElement(nums, val);
		
		for(int i = 0; i < len; i++) {
			System.out.print(nums[i] + " ");
		}
		
		System.out.println();

	}

}
