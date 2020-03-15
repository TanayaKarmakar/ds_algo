package com.app.advancedrecursion.problems;

import java.util.Arrays;

public class QuickSort {
	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	private static int partition(int[] arr, int low, int high) {
		int i = low - 1;
		int pivot = arr[high];
		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return (i + 1);
//		int pivot = arr[low];
//		int i = low - 1;
//		int j = high + 1;
//		while(true) {
//			do {
//				i++;
//			} while(arr[i] < pivot);
//			
//			do {
//				j--;
//			} while(arr[j] > pivot);
//			
//			if(i >= j)
//				return j;
//			swap(arr, i, j);
//		}
	}

	private static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int pIndx = partition(arr, low, high);
			quickSort(arr, low, pIndx - 1);
			quickSort(arr, pIndx + 1, high);
		}
	}

	public static void main(String[] args) {
		int[] nums = { 5, 7, 1, 9, 3, 8, 2, 5 };
		quickSort(nums, 0, nums.length - 1);

		System.out.println(Arrays.toString(nums));

	}

}
