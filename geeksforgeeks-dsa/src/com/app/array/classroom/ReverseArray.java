package com.app.array.classroom;

import java.util.Arrays;

public class ReverseArray {
	private static void reverseArrayRecursive(int[] arr, int start, int end) {
		if (start > end)
			return;
		int tmp = arr[start];
		arr[start] = arr[end];
		arr[end] = tmp;
		reverseArrayRecursive(arr, start + 1, end - 1);
	}

	private static void reverseArrayIterative(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int tmp = arr[start];
			arr[start] = arr[end];
			arr[end] = tmp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 10, 4 };
		reverseArrayRecursive(arr, 0, arr.length - 1);

		System.out.println(Arrays.toString(arr));

		arr = new int[] { 1, 2, 3, 10, 4 };
		reverseArrayIterative(arr);
		
		System.out.println(Arrays.toString(arr));
	}

}
