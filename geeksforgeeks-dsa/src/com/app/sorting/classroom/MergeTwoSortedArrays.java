package com.app.sorting.classroom;

public class MergeTwoSortedArrays {
	private static void mergeTwoSortedArrays(int[] arrA, int[] arrB) {
		int m = arrA.length;
		int n = arrB.length;

		int i = 0;
		int j = 0;
		while (i < m && j < n) {
			if (arrA[i] < arrB[j]) {
				System.out.print(arrA[i] + " ");
				i++;
			} else {
				System.out.print(arrB[j] + " ");
				j++;
			}
		}

		while (i < m) {
			System.out.print(arrA[i] + " ");
			i++;
		}

		while (j < n) {
			System.out.print(arrB[j] + " ");
			j++;
		}
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 3, 5, 6, 7 };
		int[] b = { 4, 4, 8, 9, 9 };

		mergeTwoSortedArrays(a, b);

	}

}
