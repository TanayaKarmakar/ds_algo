package com.app.practice.array;

import java.util.Arrays;

public class ArrayPartitionILeetcode561 {
	private static int arrayPairSum(int[] nums) {
		Arrays.sort(nums);

		int sum = 0;
		for (int i = 0; i < nums.length; i += 2) {
			sum += nums[i];
		}

		return sum;
	}

	public static void main(String[] args) {
		int[] nums = { 6, 2, 6, 5, 1, 2 };
		int sum = arrayPairSum(nums);
		
		System.out.println(sum);
	}

}
