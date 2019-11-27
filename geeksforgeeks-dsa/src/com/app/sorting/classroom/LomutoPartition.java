package com.app.sorting.classroom;

import java.util.Arrays;

public class LomutoPartition {
	private static void partitionArray(int[] arr, int low, int high) {
		int i = low - 1;
		int pivot = arr[high];

		for (int j = low; j <= high - 1; j++) {
			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, (i + 1), high);
	}

	private static void swap(int[] arr, int indx1, int indx2) {
		int tmp = arr[indx1];
		arr[indx1] = arr[indx2];
		arr[indx2] = tmp;
	}

	public static void main(String[] args) {
		int[] arr = { 10, 30, 80, 20, 40, 90, 50, 70 };
		partitionArray(arr, 0, arr.length - 1);

		System.out.println("After partitioning");
		System.out.println(Arrays.toString(arr));

	}

}
