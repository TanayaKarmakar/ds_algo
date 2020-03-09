package com.app.timecomplexity.problems;

public class MaximumProductSubarray {
	private static int maxProduct(int[] arr, int n) {
		int maxEndingHere = 1;
		int minEndingHere = 1;
		int maxSoFar = 0;

		for (int i = 0; i < n; i++) {
			if (arr[i] > 0) {
				maxEndingHere = maxEndingHere * arr[i];
				minEndingHere = Integer.min(1, minEndingHere * arr[i]);
			} else if (arr[i] == 0) {
				maxEndingHere = 1;
				minEndingHere = 1;
			} else {
				int temp = maxEndingHere;
				maxEndingHere = Integer.max(1, minEndingHere * arr[i]);
				minEndingHere = temp * arr[i];
			}

			maxSoFar = Integer.max(maxSoFar, maxEndingHere);
		}

		return maxSoFar;
	}

	public static void main(String[] args) {
		int[] arr = { -1, 9, -3, -4, 6, 7, -8 };
		System.out.println(maxProduct(arr, arr.length));

	}

}
