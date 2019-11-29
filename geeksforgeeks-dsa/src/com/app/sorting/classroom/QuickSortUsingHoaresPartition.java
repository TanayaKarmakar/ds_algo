package com.app.sorting.classroom;

import java.util.Arrays;

public class QuickSortUsingHoaresPartition {
	private static int partition(int[] arr, int low, int high) {
		int i = low - 1;
		int j = high + 1;
		int pivot = arr[low];

		while (true) {
			do {
				i++;
			} while (arr[i] < pivot);

			do {
				j--;
			} while (arr[j] > pivot);

			if (i >= j)
				return j;
			swap(arr, i, j);
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	private static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int pIndx = partition(arr, low, high);
			quickSort(arr, low, pIndx);
			quickSort(arr, pIndx + 1, high);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 10, 2, 3, 1, 4, 2, 17, 9, 15, 16, 11 };

		quickSort(arr, 0, arr.length - 1);

		System.out.println("After sorting");
		System.out.println(Arrays.toString(arr));

	}

}
