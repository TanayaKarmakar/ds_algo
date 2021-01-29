package com.app.practice.array;

public class MoveZerosLeetCode283 {
	private static void moveZeroes(int[] nums) {
		int i = -1;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != 0) {
				i++;
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
