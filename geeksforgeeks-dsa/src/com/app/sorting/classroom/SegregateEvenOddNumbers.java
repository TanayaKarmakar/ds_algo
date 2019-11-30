package com.app.sorting.classroom;

import java.util.Arrays;

public class SegregateEvenOddNumbers {
	private static void segregateEvenOdd(int[] arr) {
		int n = arr.length;
		int i = -1;
		for (int j = 0; j < n; j++) {
			if (arr[j] % 2 == 0) {
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
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		segregateEvenOdd(arr);
		
		System.out.println("After sorting, the array is ");
		System.out.println(Arrays.toString(arr));
	}

}
