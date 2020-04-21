package com.app.questions.practice;

import java.util.Arrays;

public class RemoveElementLeetcode27 {
	private static int removeElement(int[] nums, int target) {
		if (nums.length == 0)
			return nums.length;
		if(nums.length == 1) {
			if(nums[0] == target)
				return 0;
			else
				return 1;
		}
		int n = nums.length;
		int i = -1;
		for (int j = 0; j < n; j++) {
			if (nums[j] != target) {
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

		System.out.println(len);
		System.out.println(Arrays.toString(nums));

		nums = new int[] { 0, 1, 2, 2, 3, 0, 4, 2, 5 };
		
		len = removeElement(nums, 2);

		System.out.println(len);
		System.out.println(Arrays.toString(nums));

	}

}
