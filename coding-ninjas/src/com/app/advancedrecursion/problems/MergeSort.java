package com.app.advancedrecursion.problems;

import java.util.Arrays;

public class MergeSort {
	private static void merge(int[] arr, int low, int mid, int high) {
		int n1 = (mid - low + 1);
		int n2 = (high - mid);
		int[] l1 = new int[n1];
		int[] l2 = new int[n2];

		int k = 0;
		for (int i = low; i <= mid; i++) {
			l1[k++] = arr[i];
		}

		k = 0;
		for (int i = mid + 1; i <= high; i++) {
			l2[k++] = arr[i];
		}

		int i = 0;
		int j = 0;
		k = low;

		while (i < n1 && j < n2) {
			if (l1[i] <= l2[j]) {
				arr[k++] = l1[i++];
			} else {
				arr[k++] = l2[j++];
			}
		}

		while (i < n1) {
			arr[k++] = l1[i++];
		}

		while (j < n2) {
			arr[k++] = l2[j++];
		}
	}

	private static void mergeSort(int[] arr, int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid + 1, high);
			merge(arr, low, mid, high);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 25, 10, 1, 2, 5, 3, 17, 18, 16, 15 };
		
		mergeSort(arr, 0, arr.length - 1);
		
		System.out.println(Arrays.toString(arr));

	}

}
