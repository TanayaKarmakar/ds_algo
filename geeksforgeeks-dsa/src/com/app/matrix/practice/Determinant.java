package com.app.matrix.practice;

public class Determinant {
	private static int[][] buildMatrix(int[][] mat, int filteredRow, int filteredCol, int nDim) {
		int[][] newMat = new int[nDim - 1][nDim - 1];
		int row = 0;
		int col = 0;
		for (int i = filteredRow + 1; i < nDim; i++) {
			for (int j = 0; j < nDim; j++) {
				if (j != filteredCol) {
					newMat[row][col] = mat[i][j];
					col++;
				}
			}
			col = 0;
			row++;
		}
		return newMat;
	}

	private static int determinant(int[][] mat, int startRow) {
		int nDim = mat.length;
		if (nDim == 2) {
			return (mat[0][0] * mat[1][1] - mat[0][1] * mat[1][0]);
		} else {
			int det = 0;
			int multiplicant = 1;
			for (int i = 0; i < nDim; i++) {
				det += multiplicant * mat[startRow][i] * determinant(buildMatrix(mat, startRow, i, nDim), startRow);
				multiplicant = -multiplicant;
			}
			return det;
		}
	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 10, 9 } };
		System.out.println(determinant(mat, 0));

		mat = new int[][] { { 1, 0, 2, -1 }, { 3, 0, 0, 5 }, 
			{ 2, 1, 4, -3 }, { 1, 0, 5, 0 } };
			
		System.out.println(determinant(mat, 0));


	}

}
