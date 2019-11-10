package com.app.problems;

import java.util.Arrays;

public class MultiplyAllNumbersExceptPosition {
	private static void transformArray(int[] arr) {
		int n = arr.length;
		int[] temp = new int[n];
		int left = 1;
		for (int i = 0; i < n; i++) {
			temp[i] = left;
			left = left * arr[i];
		}

		int right = 1;
		for(int i = n - 1;i>=0;i--) {
			temp[i] = temp[i] * right;
			right = right * arr[i];
		}
		System.out.println(Arrays.toString(temp));
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4, 5 };
		transformArray(arr);
	}

}
