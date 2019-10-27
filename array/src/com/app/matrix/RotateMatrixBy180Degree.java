package com.app.matrix;

import java.util.Arrays;

public class RotateMatrixBy180Degree {
	private static void rotateMatrix(int[][] mat) {
		int nRows = mat.length;
		int nCols = mat[0].length;

		// reverse row
		int i = 0;
		int j = nRows - 1;
		int k = 0;
		while (i < j) {
			int[] tmp = mat[j];
			mat[j] = mat[i];
			mat[i] = tmp;
			i++;
			j--;
		}
		// reverse column
		i = 0;
		while(i < nRows) {
			int[] row = mat[i];
			k = 0;
			j = nCols - 1;
			while(k < j) {
				int tmp = row[k];
				row[k] = row[j];
				row[j] = tmp;
				k++;
				j--;
			}
			i++;
		}
	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotateMatrix(mat);
		System.out.println(Arrays.deepToString(mat));
	}

}
