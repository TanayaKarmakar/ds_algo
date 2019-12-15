package com.app.matrix.practice;

public class ExchangeMatrixColumns {
	private static void exchangeMatrixColumns(int[][] mat) {
		int startCol = 0;
		int lastCol = mat[0].length - 1;
		for (int i = 0; i < mat.length; i++) {
			int tmp = mat[i][startCol];
			mat[i][startCol] = mat[i][lastCol];
			mat[i][lastCol] = tmp;
		}

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j <= lastCol; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		exchangeMatrixColumns(mat);

	}

}
