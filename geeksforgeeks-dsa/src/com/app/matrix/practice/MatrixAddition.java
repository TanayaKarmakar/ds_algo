package com.app.matrix.practice;

public class MatrixAddition {
	private static void addMatrix(int[][] mat1, int[][] mat2) {
		int row1 = mat1.length;
		int col1 = mat1[0].length;

		int row2 = mat2.length;
		int col2 = mat2[0].length;

		if (row1 != row2 || col1 != col2) {
			System.out.print("-1");
			return;
		} else {
			for (int i = 0; i < row1; i++) {
				for (int j = 0; j < col1; j++) {
					System.out.print((mat1[i][j] + mat2[i][j]) + " ");
				}
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[][] mat1 = { { 1, 2, 3 }, { 4, 5, 6 } };
		int[][] mat2 = { { 1, 3, 3 }, { 2, 3, 3 } };
		addMatrix(mat1, mat2);
	}

}
