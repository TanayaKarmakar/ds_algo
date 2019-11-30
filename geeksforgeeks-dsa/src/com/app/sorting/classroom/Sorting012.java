package com.app.sorting.classroom;

import java.util.Arrays;

public class Sorting012 {
	private static void sortArray(int[] arr) {
		int low = 0;
		int mid = 0;
		int high = arr.length - 1;

		while (mid <= high) {
			switch (arr[mid]) {
			case 0:
				swap(arr, low, mid);
				low++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				swap(arr, mid, high);
				high--;
				break;

			}
		}
	}

	private static void swap(int[] arr, int indx1, int indx2) {
		int tmp = arr[indx1];
		arr[indx1] = arr[indx2];
		arr[indx2] = tmp;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 1, 0, 2, 1, 0, 1, 1, 2, 0, 2, 1 };
		sortArray(arr);
		
		System.out.println("After sorting");
		System.out.println(Arrays.toString(arr));

	}

}
