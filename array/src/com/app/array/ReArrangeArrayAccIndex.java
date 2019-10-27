package com.app.array;

import java.util.Arrays;

//Given two integer arrays of same size, 
//“arr[]” and “index[]”, reorder elements in “arr[]” 
//according to given index array. It is not allowed to given array arr’s length.
public class ReArrangeArrayAccIndex {
	private static void reArrangeArray(int[] arr, int[] index) {
		int n = index.length;
		int j = 0;
		int tmp = 0;
		for (int i = 0; i < n; i++) {
			if (index[i] != i) {
				j = index[i];
				index[i] = i;
				index[j] = j;
				tmp = arr[j];
				arr[j] = arr[index[i]];
				arr[index[i]] = tmp;
			}
		}
		System.out.println("After rearrangement");
		System.out.println(Arrays.toString(index));
		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {
		int[] index = { 1, 0, 2 };
		int[] arr = { 10, 11, 12 };

		reArrangeArray(arr, index);

		index = new int[] { 3, 0, 4, 1, 2 };
		arr = new int[] { 50, 40, 70, 60, 90 };
		
		reArrangeArray(arr, index);

	}

}
