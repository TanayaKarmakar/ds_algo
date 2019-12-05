package com.app.matrix.classroom;

import java.util.Arrays;

public class TransposeMatrix {
	private static void findTranspose(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = i; j < mat[i].length; j++) {
				int tmp = mat[i][j];
				mat[i][j] = mat[j][i];
				mat[j][i] = tmp;
			}
		}

		System.out.println("After transpose, the matrix is ");
		System.out.println(Arrays.deepToString(mat));
	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		findTranspose(mat);
	}

}
