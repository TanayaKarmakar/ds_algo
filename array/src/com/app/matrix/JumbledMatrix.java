package com.app.matrix;

import java.util.Arrays;

public class JumbledMatrix {
	private static int[][] buildMatrix(int n) {
		int[][] mat = new int[n][4];
		int elem = 1;
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < 4; col++) {
				mat[row][col] = elem++;
			}
		}

		return mat;
	}

	private static void jumbleMatrix(int n) {
		int[][] mat = buildMatrix(n);

		System.out.println("Before rearrangement ");
		System.out.println(Arrays.deepToString(mat));

		int start = 1;
		int end = n - 1;
		while (start < end) {
			swapRows(mat, start, end);
			start++;
			end--;
		}

		System.out.println("After rearrangement ");
		System.out.println(Arrays.deepToString(mat));
	}

	private static void swapRows(int[][] mat, int row1, int row2) {
		for (int col = 0; col < 4; col++) {
			int tmp = mat[row1][col];
			mat[row1][col] = mat[row2][col];
			mat[row2][col] = tmp;
		}
	}

	public static void main(String[] args) {
		jumbleMatrix(5);
	}

}
