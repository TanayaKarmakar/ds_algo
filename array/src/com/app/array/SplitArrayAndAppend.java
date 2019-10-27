package com.app.array;

import java.util.Arrays;

public class SplitArrayAndAppend {
	private static void reverseArray(int[] arr, int start, int end) {
		while (start <= end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;

			start++;
			end--;
		}
	}

	private static void splitAndAppend(int[] arr, int k) {
		int n = arr.length - 1;
		reverseArray(arr, 0, n);
		reverseArray(arr, 0, (n - k));
		reverseArray(arr, (n - k) + 1, n);
	}

	public static void main(String[] args) {
		int[] arr = { 12, 10, 5, 6, 52, 36 };
		System.out.println("Before Rotation");
		System.out.println(Arrays.toString(arr));
		
		splitAndAppend(arr, 2);
		
		System.out.println("After Rotation");
		System.out.println(Arrays.toString(arr));

	}

}
