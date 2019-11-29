package com.app.sorting.classroom;

public class UnionOfTwoSortedArrays {
	private static void union(int[] arrA, int[] arrB) {
		int m = arrA.length;
		int n = arrB.length;

		int i = 0;
		int j = 0;

		while (i < m && j < n) {
			if (i > 0 && arrA[i - 1] == arrA[i]) {
				i++;
				continue;
			}
			if (j > 0 && arrB[i - 1] == arrB[j]) {
				j++;
				continue;
			}

			if (arrA[i] < arrB[j]) {
				System.out.print(arrA[i] + " ");
				i++;
			} else if (arrA[i] > arrB[j]) {
				System.out.print(arrB[j] + " ");
				j++;
			} else {
				System.out.print(arrA[i] + " ");
				i++;
				j++;
			}
		}

		while (i < m) {
			if (i > 0 && arrA[i - 1] == arrA[i]) {
				i++;
				continue;
			}
			System.out.print(arrA[i] + " ");
			i++;
		}

		while (j < n) {
			if (j > 0 && arrB[j - 1] == arrB[j]) {
				j++;
				continue;
			}
			System.out.print(arrB[j] + " ");
			j++;
		}

		System.out.println();
	}

	public static void main(String[] args) {
		int[] arrA = { 1, 1, 2, 3, 4, 5, 5, 5, 6 };
		int[] arrB = { 8, 8, 8, 9, 9, 10, 11 };

		union(arrA, arrB);

	}

}
