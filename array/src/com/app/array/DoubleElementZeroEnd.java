package com.app.array;

import java.util.Arrays;

//Given an array of integers of size n. 
//Assume ‘0’ as invalid number and all other 
//as valid number. Convert the array in such a 
//way that if next number is a valid number and same as 
//current number, double its value and replace the next 
//number with 0. After the modification, rearrange the array such that all 0’s are shifted to the end. 
public class DoubleElementZeroEnd {
	private static void reArrangeArray(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			if (arr[i] != 0) {
				if ((i + 1) < n && arr[i] == arr[i + 1]) {
					arr[i] = 2 * arr[i];
					arr[i + 1] = 0;
				}
			}
		}

		int count = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] != 0) {
				arr[count++] = arr[i];
			}
		}

		while (count < n) {
			arr[count] = 0;
			count++;
		}

		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {
		int[] arr = { 2, 2, 0, 4, 0, 8 };
		reArrangeArray(arr);

		arr = new int[] { 0, 2, 2, 2, 0, 6, 6, 0, 0, 8 };
		reArrangeArray(arr);
	}

}
