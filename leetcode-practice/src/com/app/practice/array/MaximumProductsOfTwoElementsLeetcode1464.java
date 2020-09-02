package com.app.practice.array;

import java.util.Arrays;

public class MaximumProductsOfTwoElementsLeetcode1464 {
	private static int maxProduct(int[] nums) {
		Arrays.sort(nums);

		int n = nums.length;
		int maxProduct = (nums[n - 1] - 1) * (nums[n - 2] - 1);
		return maxProduct;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 4, 5, 2 };
		int maxProduct = maxProduct(nums);
		
		System.out.println(maxProduct);

	}

}
