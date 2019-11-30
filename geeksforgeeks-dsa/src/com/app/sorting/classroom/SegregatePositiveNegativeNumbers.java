package com.app.sorting.classroom;

import java.util.Arrays;

public class SegregatePositiveNegativeNumbers {
	private static void segregatePositiveNegative(int[] arr) {
		int n = arr.length;
		int i = -1;
		for (int j = 0; j < n; j++) {
			if (arr[j] < 0) {
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
		int[] arr = {-1,2,-9,3,4,10,-7,-6,-3};
		
		segregatePositiveNegative(arr);
		
		System.out.println("After segregation the array is ");

		System.out.println(Arrays.toString(arr));

	}

}
