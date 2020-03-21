package com.app.questions;

import java.util.Arrays;

public class ProductOfArrayExceptSelfLeetcode238 {
	private static int[] productOfArray(int[] nums) {
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
			rightProduct = nums[i] * rightProduct;
		}

		return product;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };
		int[] product = productOfArray(arr);

		System.out.println(Arrays.toString(product));

	}

}
