package com.app.array;

import java.util.Arrays;

public class ArrayRightRotationReversalAlgorithm {
	private static void reverseArray(int[] arr, int start, int end) {
		while (start <= end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	private static void rotateArray(int[] arr, int k) {
		int n = arr.length - 1;
		reverseArray(arr, 0, (n - k));
		reverseArray(arr, (n - k + 1), n);
		reverseArray(arr, 0, n);
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		rotateArray(arr, 3);
		System.out.println("After rotation ");
		System.out.println(Arrays.toString(arr));

//		arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
//		rotateArray(arr, 11);
//		System.out.println(Arrays.toString(arr));

	}

}
