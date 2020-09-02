package com.app.practice.array;

public class RemoveElementLeetcode27 {
	private static int removeElement(int[] nums, int val) {
		int n = nums.length;
		int i = -1;
		for (int j = 0; j < n; j++) {
			if (nums[j] != val) {
				i++;
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
			}
		}

		return i + 1;
	}

	public static void main(String[] args) {
		int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };
		int val = 2;
		
		int len = removeElement(nums, val);
		
		for(int i = 0; i < len; i++) {
			System.out.print(nums[i] + " ");
		}
		
		System.out.println();
	}

}
