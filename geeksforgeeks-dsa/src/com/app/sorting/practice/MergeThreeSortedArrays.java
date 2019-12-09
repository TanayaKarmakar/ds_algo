package com.app.sorting.practice;

import java.util.Arrays;

public class MergeThreeSortedArrays {
	private static int[] mergeThreeArrays(int[] a, int[] b, int[] c) {
		return merge(a, merge(b, c));
	}

	private static int[] merge(int[] arr1, int[] arr2) {
		int m = arr1.length;
		int n = arr2.length;

		int i = 0;
		int j = 0;

		int[] tmp = new int[m + n];
		int k = 0;
		while (i < m && j < n) {
			if (arr1[i] <= arr2[j]) {
				tmp[k++] = arr1[i++];
			} else {
				tmp[k++] = arr2[j++];
			}
		}

		while (i < m) {
			tmp[k++] = arr1[i++];
		}

		while (j < n) {
			tmp[k++] = arr2[j++];
		}
		return tmp;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4 };
		int[] b = { 1, 2, 3, 4, 5 };
		int[] c = { 1, 2, 3, 4, 5, 6 };

		System.out.println("Merged array ");
		System.out.println(Arrays.toString(mergeThreeArrays(a, b, c)));
	}

}
