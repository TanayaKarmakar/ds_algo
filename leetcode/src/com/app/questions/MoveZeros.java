package com.app.questions;

import java.util.Arrays;

public class MoveZeros {
	private static void moveZeros(int[] nums) {
		if (nums.length <= 1)
			return;
		int indx = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				++indx;
				nums[indx] = nums[i];
			}
		}

		for (int j = indx + 1; j < nums.length; j++) {
			nums[j] = 0;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 0, 0, 1, 0, 0, 2, 0, 3, 4 };
		moveZeros(arr);
		System.out.println(Arrays.toString(arr));
	}

}
