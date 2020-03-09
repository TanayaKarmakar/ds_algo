package com.app.timecomplexity.problems;

public class ProductOfAllElementsExceptSelf {
	private static void product(int[] nums, int n) {
		int[] product = new int[n];
		int lp = 1;
		int rp = 1;

		for (int i = 0; i < n; i++) {
			product[i] = lp;
			lp = lp * nums[i];
		}

		for (int i = n - 1; i >= 0; i--) {
			product[i] = product[i] * rp;
			rp = rp * nums[i];
		}

		for (int i = 0; i < n; i++) {
			System.out.print(product[i] + " ");
		}

		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };
		product(arr, arr.length);
	}

}
