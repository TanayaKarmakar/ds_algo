package com.app.questions;

import java.util.Arrays;

public class ArrayPartitionLeetcode561 {
	private static int arrayPairSum(int[] nums) {
		Arrays.sort(nums);

		int sum = 0;
		for (int i = 0; i < nums.length; i += 2) {
			sum += nums[i];
		}

		return sum;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 4, 3, 2 };
		int sum = arrayPairSum(arr);
		
		System.out.println(sum);
	}

}
