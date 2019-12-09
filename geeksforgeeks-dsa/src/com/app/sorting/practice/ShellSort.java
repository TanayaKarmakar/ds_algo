package com.app.sorting.practice;

import java.util.Arrays;

public class ShellSort {
	private static void sortArray(int[] arr) {
		int n = arr.length;

		for (int gap = n / 2; gap >= 1; gap = gap / 2) {
			for (int j = gap; j < n; j++) {
				for (int i = j - gap; i >= 0; i = i - gap) {
					if (arr[i + gap] > arr[i]) {
						break;
					} else {
						swap(arr, i + gap, i);
					}
				}
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void main(String[] args) {
		int[] arr = { 23, 29, 15, 19, 31, 7, 9, 5, 2 };

		sortArray(arr);

		System.out.println("After sorting, the array is");
		System.out.println(Arrays.toString(arr));

	}

}
