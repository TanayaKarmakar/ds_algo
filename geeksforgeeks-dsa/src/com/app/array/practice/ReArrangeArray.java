package com.app.array.practice;

import java.util.Arrays;

public class ReArrangeArray {
	private static void reArrangeArray(int[] arr) {
		int n = arr.length;

		for (int i = 0; i < n; i++) {
			arr[i] = arr[i] + (arr[arr[i]] % n) * n;
		}

		for (int i = 0; i < n; i++) {
			arr[i] = arr[i] / n;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 4, 0, 2, 1, 3 };
		reArrangeArray(arr);

		System.out.println(Arrays.toString(arr));
	}

}
