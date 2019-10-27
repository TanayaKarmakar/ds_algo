package com.app.array;

import java.util.Arrays;

//Given an array of integers, segregate even and odd numbers 
// in the array. All the even numbers should be present first, and then the odd numbers.
public class SegregateOddEven {
	private static void reArrangeArray(int[] arr) {
		int n = arr.length;
		int tmp = 0;
		int i = -1;
		for (int j = 0; j < n; j++) {
			if (arr[j] % 2 == 0) {
				i++;
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 9, 5, 3, 2, 6, 7, 11 };
		reArrangeArray(arr);

		System.out.println("After rearrangement ");
		System.out.println(Arrays.toString(arr));
	}

}
