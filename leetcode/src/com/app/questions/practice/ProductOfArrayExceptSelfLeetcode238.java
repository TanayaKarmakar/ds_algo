package com.app.questions.practice;

import java.util.Arrays;

public class ProductOfArrayExceptSelfLeetcode238 {
	private static int[] productOfArrayExceptSelf(int[] nums) {
		int n = nums.length;

		int[] product = new int[n];
		int leftProduct = 1;
		for (int i = 0; i < n; i++) {
			product[i] = leftProduct;
			leftProduct = leftProduct * nums[i];
		}

		int rightProduct = 1;
		for (int i = n - 1; i >= 0; i--) {
			product[i] = product[i] * rightProduct;
			rightProduct = rightProduct * nums[i];
		}

		return product;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		int[] product = productOfArrayExceptSelf(nums);
		
		System.out.println(Arrays.toString(product));

	}

}
