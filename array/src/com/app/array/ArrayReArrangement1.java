package com.app.array;

import java.util.Arrays;

//Rearrange an array in order – smallest, largest, 2nd smallest, 2nd largest, ..
public class ArrayReArrangement1 {
	private static void reArrange(int[] arr) {
		Arrays.sort(arr);
		int start = 0;
		int end = arr.length - 1;
		int indx = 0;
		while (start <= end) {
			if (indx % 2 == 0) {
				System.out.print(arr[start] + "\t");
				start++;
			} else {
				System.out.print(arr[end] + "\t");
				end--;
			}
			indx++;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 5, 8, 1, 4, 2, 9, 3, 7, 6 };
		reArrange(arr);
	}

}
