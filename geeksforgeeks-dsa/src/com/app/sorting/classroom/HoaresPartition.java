package com.app.sorting.classroom;

import java.util.Arrays;

public class HoaresPartition {
	private static int partitionArray(int[] arr, int low, int high) {
		int pivot = arr[low];
		int i = low - 1;
		int j = high + 1;

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

	public static void main(String[] args) {
		int[] arr = { 5, 1, 8, 6, 3, 2, 10, 12, 11 };
		int partitionIndx = partitionArray(arr, 0, arr.length - 1);
		
		System.out.println("After partitioning");
		System.out.println(Arrays.toString(arr));
		System.out.println("Partition Index - " + partitionIndx);

	}

}
