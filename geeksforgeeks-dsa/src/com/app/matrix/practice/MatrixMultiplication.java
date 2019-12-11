package com.app.matrix.practice;

public class MatrixMultiplication {
	private static void multiplyMatrix(int[][] mat1, int[][] mat2) {
		int row1 = mat1.length;
		int col1 = mat1[0].length;
		int row2 = mat2.length;
		int col2 = mat2[0].length;

		if (col1 != row2) {
			System.out.println("Multiplication is not possible");
			return;
		}

		int[][] res = new int[row1][col2];

		for (int i = 0; i < row1; i++) {
			for (int j = 0; j < col1; j++) {
				for (int k = 0; k < row2; k++) {
					res[i][j] += mat1[i][k] * mat2[k][j];
				}
			}
		}

		System.out.println("Result ");
		for (int i = 0; i < row1; i++) {
			for (int j = 0; j < col2; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] mat1 = { { 4, 8 }, { 0, 2 }, { 1, 6 } };
		int[][] mat2 = { { 5, 2 }, { 9, 4 } };
		multiplyMatrix(mat1, mat2);
	}

}
