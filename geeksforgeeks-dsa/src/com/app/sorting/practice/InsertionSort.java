package com.app.sorting.practice;

import java.util.Arrays;

public class InsertionSort {
	private static void sortArray(int[] arr) {
		int n = arr.length;

		for (int i = 1; i < n; i++) {
			int j = i - 1;
			int key = arr[i];

			while (j >= 0 && key < arr[j]) {
				arr[j + 1] = arr[j];
				j--;
			}

			arr[j + 1] = key;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 10, 2, 3, 8, 9, 7, 11 };

		sortArray(arr);

		System.out.println("After sorting, the array is");
		System.out.println(Arrays.toString(arr));

		arr = new int[] { 4, 1, 3, 7, 9 };
		sortArray(arr);
		System.out.println("After sorting, the array is");
		System.out.println(Arrays.toString(arr));

	}

}
