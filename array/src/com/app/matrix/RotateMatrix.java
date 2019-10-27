package com.app.matrix;

import java.util.Arrays;

public class RotateMatrix {
	private static void rotateMatrix(int[][] mat) {
		int nRows = mat.length;
		int nCols = mat[0].length;

		int row = 0, col = 0;
		int prev, curr;

		while (row < nRows && col < nCols) {
			if (row + 1 == nRows || col + 1 == nCols)
				break;

			prev = mat[row + 1][col];

			for (int i = col; i < nCols; i++) {
				curr = mat[row][i];
				mat[row][i] = prev;
				prev = curr;
			}

			row++;

			for (int i = row; i < nRows; i++) {
				curr = mat[i][nCols - 1];
				mat[i][nCols - 1] = prev;
				prev = curr;
			}

			nCols--;

			if (row < nRows) {
				for (int i = nCols - 1; i >= col; i--) {
					curr = mat[nRows - 1][i];
					mat[nRows - 1][i] = prev;
					prev = curr;
				}
			}
			nRows--;

			if (col < nCols) {
				for (int i = nRows - 1; i >= row; i--) {
					curr = mat[i][col];
					mat[i][col] = prev;
					prev = curr;
				}
			}
			col++;
		}
	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		System.out.println("Before Rotation");
		System.out.println(Arrays.deepToString(mat));
		rotateMatrix(mat);
		
		System.out.println("After Rotation");
		System.out.println(Arrays.deepToString(mat));
	}
}
