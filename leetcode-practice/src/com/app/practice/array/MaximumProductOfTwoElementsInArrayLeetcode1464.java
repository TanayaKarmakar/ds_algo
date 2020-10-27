package com.app.practice.array;

import java.util.Arrays;

public class MaximumProductOfTwoElementsInArrayLeetcode1464 {
	private static int maxProduct(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length;
		return (nums[n - 1] - 1) * (nums[n - 2] - 1);
	}

	public static void main(String[] args) {
		int[] nums = { 3, 4, 5, 2 };
		int maxProd = maxProduct(nums);
		
		System.out.println(maxProd);
	}

}
