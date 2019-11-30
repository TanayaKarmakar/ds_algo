package com.app.sorting.classroom;

import java.util.Arrays;

public class ChocolateDistributionProblem {
	private static int findMinDiff(int[] arr, int m) {
		int n = arr.length;
		if (m > n)
			return -1;
		Arrays.sort(arr);
		int minDiff = arr[m - 1] - arr[0];
		int minStartIndx = 0;
		for (int i = 1; (i + m - 1) < n; i++) {
			if (arr[i + m - 1] - arr[i] < minDiff) {
				minDiff = arr[i + m - 1] - arr[i];
				minStartIndx = i;
			}
		}

		return minStartIndx;
	}

	public static void main(String[] args) {
		int[] arr = { 7, 12, 2, 4, 56, 9, 6, 10 };
		int minStartIndx = findMinDiff(arr, 3);
		
		System.out.println("After sorting, the array is ");
		System.out.println(Arrays.toString(arr));
		
		System.out.println("minStartIndx - " + minStartIndx);

	}

}
