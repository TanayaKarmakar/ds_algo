package com.app.practice;

public class RemoveElementLeetcode27 {
	private static int removeElement(int[] nums, int val) {
		if(nums.length == 0)
			return 0;
		if(nums.length == 1) {
			if(nums[0] == val)
				return 0;
			else
				return 1;
		}
		int i = -1;
		int n = nums.length;
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
		int[] nums = { 3, 2, 2, 3 };

		int len = removeElement(nums, 3);

		for (int i = 0; i < len; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();

		nums = new int[] { 0, 1, 2, 2, 3, 0, 4, 2 };
		
		len = removeElement(nums, 2);
		
		for (int i = 0; i < len; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
	}

}
