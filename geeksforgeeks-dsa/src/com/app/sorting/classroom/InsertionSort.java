package com.app.sorting.classroom;

import java.util.Arrays;

public class InsertionSort {
	private static void sort(int[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			int j = (i - 1);
			int key = arr[i];
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}

		System.out.println("After sorting the array is ");
		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 9, 3, 6, 7, 2, 1, 10, 23 };
		sort(arr);

		arr = new int[] { 10, 8, 4, 3, 2, 1 };
		sort(arr);
	}

}
