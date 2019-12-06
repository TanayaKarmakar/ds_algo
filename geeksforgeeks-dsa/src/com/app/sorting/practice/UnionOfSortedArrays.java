package com.app.sorting.practice;

public class UnionOfSortedArrays {
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
			if (j > 0 && arrB[j - 1] == arrB[j]) {
				j++;
				continue;
			}
			if (arrA[i] < arrB[j]) {
				System.out.print(arrA[i] + "\t");
				i++;
			} else if (arrA[i] > arrB[j]) {
				System.out.print(arrB[j] + "\t");
				j++;
			} else {
				System.out.print(arrA[i] + "\t");
				i++;
				j++;
			}
		}

		while (i < m) {
			if (i > 0 && arrA[i - 1] == arrA[i]) {
				i++;
				continue;
			}
			System.out.print(arrA[i] + "\t");
			i++;
		}

		while (j < n) {
			if (j > 0 && arrB[j - 1] == arrB[j]) {
				j++;
				continue;
			}
			System.out.print(arrB[j] + "\t");
			j++;
		}

		System.out.println();
	}

	public static void main(String[] args) {
		int[] arrA = { 1, 2, 2, 4, 4, 5, 6, 7, 7, 8, 9, 9 };
		int[] arrB = { 10, 10, 11, 12, 16, 16, 17, 18 };
		union(arrA, arrB);

		arrA = new int[] { 1, 2, 3, 4, 5 };
		arrB = new int[] { 1, 2, 3 };
		union(arrA, arrB);

	}

}
