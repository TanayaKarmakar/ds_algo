package com.array.ideserve.practice;

import java.util.Arrays;

public class FindNextGreaterElementPractice {
	private static void findNextHigherNumber(int[] arr) {
		int n = arr.length;
		int d1 = 0, d2 = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (i > 0) {
				if (arr[i] > arr[i - 1]) {
					d1 = (i - 1);
					break;
				}
			}
		}

		for (int i = d1 + 1; i < n; i++) {
			if (arr[d1] < arr[i]) {
				d2 = i;
			}
		}

		int tmp = arr[d2];
		arr[d2] = arr[d1];
		arr[d1] = tmp;

		int i = d1 + 1;
		int j = n - 1;
		while (i < j) {
			tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
			i++;
			j--;
		}

		System.out.println("Next Higher Number");
		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };
		findNextHigherNumber(arr);

		arr = new int[] { 3, 2, 8, 4, 1 };
		findNextHigherNumber(arr);
	}
}
