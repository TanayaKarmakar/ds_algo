package com.app.array.practice;

public class MaximumIndex {
	private static int findMaximumIndex(int[] arr) {
		int n = arr.length;

		int[] lMin = new int[n];
		int[] rMax = new int[n];

		lMin[0] = arr[0];
		for (int i = 1; i < n; i++) {
			lMin[i] = Integer.min(arr[i], lMin[i - 1]);
		}

		rMax[n - 1] = arr[n - 1];
		for (int j = n - 2; j >= 0; j--) {
			rMax[j] = Integer.max(arr[j], rMax[j + 1]);
		}

		int i = 0, j = 0, maxDiff = Integer.MIN_VALUE;

		while (i < n && j < n) {
			if (lMin[i] <= rMax[j]) {
				maxDiff = Integer.max(maxDiff, j - i);
				j++;
			} else {
				i++;
			}
		}

		return maxDiff;
	}

	public static void main(String[] args) {
		int[] arr = { 34, 8, 10, 3, 2, 80, 30, 33, 1 };
		
		System.out.println("Max Diff - " + findMaximumIndex(arr));
	}

}
