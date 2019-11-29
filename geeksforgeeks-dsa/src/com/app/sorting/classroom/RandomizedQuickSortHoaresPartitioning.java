package com.app.sorting.classroom;

import java.util.Arrays;
import java.util.Random;

public class RandomizedQuickSortHoaresPartitioning {
	private static int partition(int[] arr, int pIndx, int low, int high) {
		swap(arr, low, pIndx);

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

	private static int partitionRand(int[] arr, int low, int high) {
		Random random = new Random();
		int pIndx = random.ints(low, high + 1).findFirst().getAsInt();

		return partition(arr, pIndx, low, high);
	}

	private static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int pIndx = partitionRand(arr, low, high);
			quickSort(arr, low, pIndx);
			quickSort(arr, pIndx + 1, high);
		}
	}

	private static void swap(int[] arr, int indx1, int indx2) {
		int tmp = arr[indx1];
		arr[indx1] = arr[indx2];
		arr[indx2] = tmp;
	}

	public static void main(String[] args) {
		int[] arr = {1,9,2,3,4,18,17,22,12,5,6};
		
		quickSort(arr, 0, arr.length - 1);
		
		System.out.println("After Sorting, the array is");
		System.out.println(Arrays.toString(arr));

	}

}
