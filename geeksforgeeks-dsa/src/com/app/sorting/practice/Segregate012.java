package com.app.sorting.practice;

import java.util.Arrays;

public class Segregate012 {
	private static void segregate012(int[] arr) {
		int n = arr.length;

		int low = 0;
		int mid = 0;
		int high = n - 1;

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
			}
		}
	}

	private static void swap(int[] arr, int indx1, int indx2) {
		int tmp = arr[indx1];
		arr[indx1] = arr[indx2];
		arr[indx2] = tmp;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 0, 1, 1, 0, 0, 2, 2, 1 };
		segregate012(arr);
		
		System.out.println("After sorting, the array is ");
		System.out.println(Arrays.toString(arr));
	}

}
