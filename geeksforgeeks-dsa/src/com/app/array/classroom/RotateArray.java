package com.app.array.classroom;

import java.util.Arrays;

public class RotateArray {
	private static void reverseArray(int[] arr, int start, int end) {
		while (start <= end) {
			int tmp = arr[start];
			arr[start] = arr[end];
			arr[end] = tmp;
			start++;
			end--;
		}
	}

	private static void rotateArray(int[] arr, int d) {
		reverseArray(arr, 0, d - 1);
		reverseArray(arr, d, arr.length - 1);
		reverseArray(arr, 0, arr.length - 1);
	}

	public static void main(String[] args) {
		int[] arr = { 5, 8, 10, 12, 13 };
		rotateArray(arr, 2);
		
		System.out.println("Array is ");
		System.out.println(Arrays.toString(arr));
	}

}
