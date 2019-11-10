package com.array.ideserve.practice;

import java.util.Arrays;

public class MultiplyAllElementsExceptPositionPractice {
	private static int[] convertArray(int[] arr) {
		if (arr.length == 0 || arr.length == 1)
			return arr;
		int n = arr.length;
		int[] temp = new int[n];
		Arrays.fill(temp, 1);
		int left = 1;
		for (int i = 0; i < n; i++) {
			temp[i] = left;
			left = left * arr[i];
		}

		int right = 1;
		for (int i = n - 1; i >= 0; i--) {
			temp[i] = temp[i] * right;
			right = right * arr[i];
		}
		return temp;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		arr = convertArray(arr);
		
		System.out.println(Arrays.toString(arr));
	}

}
