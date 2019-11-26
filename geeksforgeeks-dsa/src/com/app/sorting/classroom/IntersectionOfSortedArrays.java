package com.app.sorting.classroom;

public class IntersectionOfSortedArrays {
	private static void printIntersection(int[] arrA, int[] arrB) {
		int m = arrA.length;
		int n = arrB.length;

		int i = 0;
		int j = 0;

		while (i < m && j < n) {
			if (i > 0 && arrA[i - 1] == arrA[i]) {
				i++;
				continue;
			}
			if (arrA[i] == arrB[j]) {
				System.out.print(arrA[i] + " ");
				i++;
				j++;
			} else if (arrA[i] < arrB[j]) {
				i++;
			} else {
				j++;
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arrA = { 2, 3, 3, 3, 4, 4, 6, 6, 7, 8 };
		int[] arrB = { 1, 2, 3, 4, 4, 4, 4, 4, 8, 8, 8, 10 };
		printIntersection(arrA, arrB);

	}

}
