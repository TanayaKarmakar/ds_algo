package com.app.sorting.practice;

public class IntersectionOfSortedArrays {
	private static void findIntersection(int[] arrA, int[] arrB) {
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
				i++;
			} else if (arrA[i] > arrB[j]) {
				j++;
			} else {
				System.out.print(arrA[i] + " ");
				i++;
				j++;
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrA = { 1, 2, 3, 4 };
		int[] arrB = { 2, 4, 6, 7, 8 };
		findIntersection(arrA, arrB);
	}

}
