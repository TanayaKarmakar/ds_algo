package com.app.sorting.practice;

import java.util.Arrays;

public class CountPossibleTriangle {
	private static int countTriangles(int[] arr) {
		Arrays.sort(arr);
		int count = 0;
		int n = arr.length;
		for (int i = n - 1; i >= 1; i--) {
			int l = 0;
			int r = i - 1;
			while (l < r) {
				if (arr[l] + arr[r] > arr[i]) {
					count += (r - l);
					r--;
				} else {
					l++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] arr = { 6, 4, 9, 7, 8 };

		int cnt = countTriangles(arr);

		System.out.println("Count - " + cnt);

		arr = new int[] { 3, 5, 4 };
		cnt = countTriangles(arr);

		System.out.println("Count - " + cnt);

	}

}
