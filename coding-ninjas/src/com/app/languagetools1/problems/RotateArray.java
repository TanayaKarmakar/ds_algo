package com.app.languagetools1.problems;

import java.util.Arrays;

public class RotateArray {
	private static void reverseArray(int[] arr, int start, int end) {
		while(start < end) {
			int tmp = arr[start];
			arr[start] = arr[end];
			arr[end] = tmp;
			start++;
			end--;
		}
	}
	
	private static void rotateArray(int[] arr, int d) {
		int n = arr.length - 1;
		if(d > n + 1) {
			d = d % (n + 1);
		}
		reverseArray(arr, 0, n);
		reverseArray(arr, 0, n - d);
		reverseArray(arr, n - d + 1, n);
	}

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7};
		
		rotateArray(nums, 9);
		
		System.out.println(Arrays.toString(nums));

	}

}
