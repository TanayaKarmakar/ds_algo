package com.app.search;

import java.util.Arrays;

public class SearchInA2DSortedArray {
	private static int[] searchElement(int[][] matrix, int el) {
		int m = matrix.length;
		int n = matrix[0].length;

		int i = 0;
		int j = n - 1;
		while (i < m && j >= 0) {
			if (matrix[i][j] == el) {
				return new int[] { i, j };
			} else if (matrix[i][j] > el) {
				j--;
			} else {
				i++;
			}
		}
		return new int[] { -1, -1 };
	}

	public static void main(String[] args) {
		int[][] matrix = { { -1, 2, 4, 4, 6 }, { 1, 5, 5, 9, 21 }, { 3, 6, 6, 9, 22 }, { 3, 6, 8, 10, 24 },
				{ 6, 8, 9, 12, 25 }, { 8, 10, 12, 13, 40 } };
		int el = 15;
		
		int[] result = searchElement(matrix, el);
		
		System.out.println(Arrays.toString(result));

	}

}
