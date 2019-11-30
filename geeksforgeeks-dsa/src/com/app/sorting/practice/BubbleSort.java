package com.app.sorting.practice;

import java.util.Arrays;

public class BubbleSort {
	private static void sort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (arr[j - 1] > arr[j]) {
					int tmp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 29, 25, 45, 10, 23, 26, 8, 1, 2, 3 };
		sort(arr);
		
		System.out.println("After sorting, the array is "); 
		System.out.println(Arrays.toString(arr));

	}

}
