package com.app.sorting.practice;

import java.util.Arrays;

public class SortByAbsoluteDifference {
	private static void merge(int[] arr, int low, int mid, int high, int k) {
		int n1 = (mid - low) + 1;
		int n2 = (high - mid);

		int[] part1 = new int[n1];
		int[] part2 = new int[n2];

		int k1 = 0;
		for (int i = low; i <= mid; i++) {
			part1[k1++] = arr[i];
		}

		k1 = 0;
		for (int i = mid + 1; i <= high; i++) {
			part2[k1++] = arr[i];
		}

		int i = 0;
		int j = 0;
		k1 = low;

		int diff1 = 0;
		int diff2 = 0;

		while (i < n1 && j < n2) {
			diff1 = Math.abs(k - part1[i]);
			diff2 = Math.abs(k - part2[j]);

			if (diff1 <= diff2) {
				arr[k1++] = part1[i++];
			} else {
				arr[k1++] = part2[j++];
			}
		}

		while (i < n1) {
			arr[k1++] = part1[i++];
		}

		while (j < n2) {
			arr[k1++] = part2[j++];
		}
	}

	private static void sortByDifference(int[] arr, int low, int high, int k) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			sortByDifference(arr, low, mid, k);
			sortByDifference(arr, mid + 1, high, k);
			merge(arr, low, mid, high, k);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 10, 5, 3, 9, 2 };
		sortByDifference(arr, 0, arr.length - 1, 7);

		System.out.println("After sorting, the array is ");
		System.out.println(Arrays.toString(arr));

		arr = new int[] { 1, 2, 3, 4, 5 };
		sortByDifference(arr, 0, arr.length - 1, 5);

		System.out.println("After sorting, the array is ");
		System.out.println(Arrays.toString(arr));

		arr = new int[] { 2, 6, 8, 3 };
		sortByDifference(arr, 0, arr.length - 1, 5);

		System.out.println("After sorting, the array is ");
		System.out.println(Arrays.toString(arr));

	}

}
