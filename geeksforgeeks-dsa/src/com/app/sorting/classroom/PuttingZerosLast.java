package com.app.sorting.classroom;

import java.util.Arrays;

public class PuttingZerosLast {
	private static void sortArray(int[] arr) {
		int n = arr.length;

		int i = -1;
		for (int j = 0; j < n; j++) {
			if (arr[j] > 0) {
				i++;
				swap(arr, i, j);
			}
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void main(String[] args) {
		int[] arr = { 0, 1, 0, 2, 0, 0, 0, 4, 6, 2, 8, 0, 10, 8, 0, 2, 6, 7 };
		sortArray(arr);
		
		System.out.println("After sorting");
		System.out.println(Arrays.toString(arr));
	}

}
