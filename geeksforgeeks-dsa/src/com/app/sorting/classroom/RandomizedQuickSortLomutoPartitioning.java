package com.app.sorting.classroom;

import java.util.Arrays;
import java.util.Random;

public class RandomizedQuickSortLomutoPartitioning {

	private static int partition(int[] arr, int pIndx, int low, int high) {
		swap(arr, pIndx, high);
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

	private static int partitionRand(int[] arr, int low, int high) {
		Random rand = new Random();
		int pIndx = rand.ints(low, high + 1).findFirst().getAsInt();

		return partition(arr, pIndx, low, high);
	}

	private static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int pIndx = partitionRand(arr, low, high);
			quickSort(arr, low, pIndx - 1);
			quickSort(arr, pIndx + 1, high);
		}
	}

	private static void swap(int[] arr, int indx1, int indx2) {
		int tmp = arr[indx1];
		arr[indx1] = arr[indx2];
		arr[indx2] = tmp;
	}

	public static void main(String[] args) {
		int[] arr = { 10, 2, 7, 4, 3, 6, 18, 9, 11 };
		quickSort(arr, 0, arr.length - 1);

		System.out.println("After sorting, the array is ");
		System.out.println(Arrays.toString(arr));

	}

}
