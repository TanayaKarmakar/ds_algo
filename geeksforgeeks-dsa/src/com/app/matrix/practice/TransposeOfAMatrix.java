package com.app.matrix.practice;

import java.util.Arrays;

public class TransposeOfAMatrix {
	private static void transpose(int[][] mat) {
		int row = mat.length;
		int col = mat[0].length;

		for (int i = 0; i < row; i++) {
			for (int j = i; j < col; j++) {
				swap(mat, i, j);
			}
		}

		System.out.println(Arrays.deepToString(mat));
	}

	private static void swap(int[][] mat, int i, int j) {
		int tmp = mat[i][j];
		mat[i][j] = mat[j][i];
		mat[j][i] = tmp;
	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 1, 1, 1 }, { 2, 2, 2, 2 }, { 3, 3, 3, 3 }, { 4, 4, 4, 4 } };
		transpose(mat);
	}

}
