package com.app.array;

import java.util.Arrays;

//using reversal technique
public class ArrayLeftRotation {
	private static int[] reverseArray(int[] arr, int start, int stop) {
		while (start < stop) {
			int tmp = arr[start];
			arr[start] = arr[stop];
			arr[stop] = tmp;
			start++;
			stop--;
		}
		return arr;
	}

	private static int[] leftRotation(int[] arr, int k) {
		int n = arr.length - 1;
		arr = reverseArray(arr, 0, k - 1);
		arr = reverseArray(arr, k, n);
		arr = reverseArray(arr, 0, n);
		return arr;
	}

	public static void main(String[] args) {
		int[] arr = {1,3,5,7,9};
		System.out.println(Arrays.toString(leftRotation(arr, 1)));
		
		arr = new int[]{1,3,5,7,9};
		System.out.println(Arrays.toString(leftRotation(arr, 3)));
		
		arr = new int[]{1,3,5,7,9};
		System.out.println(Arrays.toString(leftRotation(arr, 4)));
		
		arr = new int[]{1,3,5,7,9};
		System.out.println(Arrays.toString(leftRotation(arr, 7)));

	}

}
