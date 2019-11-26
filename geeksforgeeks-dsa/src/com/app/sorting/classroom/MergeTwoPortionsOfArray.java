package com.app.sorting.classroom;

import java.util.Arrays;

public class MergeTwoPortionsOfArray {
	private static void mergeTwoPortions(int[] arr, int l, int m, int r) {
		int n1 = (m - l) + 1;
		int n2 = (r - m);

		int[] part1 = new int[n1];
		int[] part2 = new int[n2];

		int i = 0;
		int j = 0;

		for (i = l; i <= m; i++) {
			part1[i] = arr[i];
		}

		int k = 0;
		for (i = m + 1 ; i <= r; i++) {
			part2[k++] = arr[i];
		}

		k = l;
		i = 0;
		j = 0;
		while (i < n1 && j < n2) {
			if (part1[i] < part2[j]) {
				arr[k++] = part1[i++];
			} else {
				arr[k++] = part2[j++];
			}
		}

		while (i < n1) {
			arr[k++] = part1[i++];
		}

		while (j < n2) {
			arr[k++] = part2[j++];
		}

		System.out.println("After merging");
		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {
		int[] arr = { 1, 4, 5, 6, 7, 20, 3, 8, 11, 15, 28 };

		mergeTwoPortions(arr, 0, 5, arr.length - 1);

	}

}
