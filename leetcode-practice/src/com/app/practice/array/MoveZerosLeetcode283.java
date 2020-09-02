package com.app.practice.array;

import java.util.Arrays;

public class MoveZerosLeetcode283 {
	private static void moveZeros(int[] nums) {
		if(nums.length <= 1)
			return;
		int n = nums.length;
		int i = -1;
		for (int j = 0; j < n; j++) {
			if (nums[j] != 0) {
				i++;
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = { 0, 1, 0, 3, 12 };
		moveZeros(nums);
		
		System.out.println(Arrays.toString(nums));
		
	}

}
