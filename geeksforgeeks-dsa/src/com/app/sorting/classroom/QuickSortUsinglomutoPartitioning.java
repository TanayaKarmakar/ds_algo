package com.app.sorting.classroom;

import java.util.Arrays;

public class QuickSortUsinglomutoPartitioning {
	private static int partition(int[] arr, int low, int high) {
		int i = low - 1;
		int pivot = arr[high];
		for (int j = low; j <= high - 1; j++) {
			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, (i + 1), high);
		return (i + 1);
	}

	private static void swap(int[] arr, int indx1, int indx2) {
		int tmp = arr[indx1];
		arr[indx1] = arr[indx2];
		arr[indx2] = tmp;
	}

	private static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int pIndx = partition(arr, low, high);
			quickSort(arr, low, pIndx - 1);
			quickSort(arr, pIndx + 1, high);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 10, 2, 3, 6, 7, 15, 8, 18, 24, 20, 9 };
		quickSort(arr, 0, arr.length - 1);

		System.out.println("After sorting, array is ");
		System.out.println(Arrays.toString(arr));

	}

}
