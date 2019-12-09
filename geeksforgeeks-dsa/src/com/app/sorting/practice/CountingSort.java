package com.app.sorting.practice;

import java.util.Arrays;

public class CountingSort {
	private static void sortArray(int[] arr) {
		int minVal = Integer.MAX_VALUE;
		int maxVal = Integer.MIN_VALUE;

		int n = arr.length;

		for (int i = 0; i < n; i++) {
			if (arr[i] > maxVal) {
				maxVal = arr[i];
			}
			if (arr[i] < minVal) {
				minVal = arr[i];
			}
		}

		int[] count = new int[maxVal + 1];

		for (int i = 0; i < n; i++) {
			int item = arr[i];
			count[item]++;
		}

		int[] tmp = new int[n];
		int j = 0;
		for (int i = minVal; i <= maxVal; i++) {
			int item = count[i];
			while (item > 0) {
				tmp[j++] = i;
				item--;
			}
		}

		System.out.println("After sorting, the array is");
		System.out.println(Arrays.toString(tmp));

	}

	public static void main(String[] args) {
		int[] arr = { 9, 4, 1, 7, 9, 1, 2, 0 };
		sortArray(arr);

	}

}
