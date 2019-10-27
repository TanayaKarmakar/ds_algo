package com.app.matrix;

import java.util.Arrays;

public class RotateMatrixBy90DegreeClockwise {
	// using layer by layer approach
	private static void rotateMatrix(int[][] mat) {
		int nRows = mat.length - 1;
		for (int i = 0; i <= (nRows / 2); i++) {
			for (int j = i; j < (nRows - i); j++) {
				int p1 = mat[i][j];
				int p2 = mat[j][nRows - i];
				int p3 = mat[nRows - i][nRows - j];
				int p4 = mat[nRows - j][i];

				mat[j][nRows - i] = p1;
				mat[nRows - i][nRows - j] = p2;
				mat[nRows - j][i] = p3;
				mat[i][j] = p4;
			}
		}
	}

	public static void main(String[] args) {
		int[][] arr = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotateMatrix(arr);
		System.out.println("After rotation (layer by layer rotation approach)");
		System.out.println(Arrays.deepToString(arr));

		arr = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		rotateMatrix(arr);
		System.out.println("After rotation (layer by layer rotation approach)");
		System.out.println(Arrays.deepToString(arr));
	}

}
