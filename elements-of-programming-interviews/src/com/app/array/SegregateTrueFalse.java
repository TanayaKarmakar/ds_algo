package com.app.array;

import java.util.Arrays;

public class SegregateTrueFalse {
	private static void swap(boolean[] arr, int i, int j) {
		boolean tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	private static void segregateTrueFalse(boolean[] arr) {
		int n = arr.length;
		int i = -1;
		for (int j = 0; j < n; j++) {
			if (arr[j] == false) {
				i++;
				swap(arr, i, j);
			}
		}
	}

	public static void main(String[] args) {
		boolean[] arr = { true, false, false, true, true, false, true, false };
		segregateTrueFalse(arr);
		
		System.out.println(Arrays.toString(arr));
	}

}
