package com.app.matrix.practice;

public class SumOfUpperAndLowerTriangle {
	private static void sumOfUpperAndLowerTriangle(int[][] mat) {
		int row = mat.length;
		int col = mat[0].length;

		int j = 0;

		int utSum = 0;
		int ltSum = 0;

		for (int i = 0; i < row; i++) {
			for (j = i; j < col; j++) {
				utSum += mat[i][j];
			}

			for (j = 0; j <= i; j++) {
				ltSum += mat[i][j];
			}
		}
		
		System.out.println(utSum + " " + ltSum);
	}

	public static void main(String[] args) {
		int[][] mat = { { 6, 5, 4 }, { 1, 2, 5 }, { 7, 9, 7 } };
		sumOfUpperAndLowerTriangle(mat);
	}

}
