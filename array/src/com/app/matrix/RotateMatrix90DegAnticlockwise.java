package com.app.matrix;

import java.util.Arrays;

//using constant space
//applicable for square matrix
public class RotateMatrix90DegAnticlockwise {
	// transpose and reverse approach
	private static void rotateMatrix(int[][] mat) {
		int nRows = mat.length;
		int nCols = mat[0].length;

		int row = 0;
		int col = 0;
		// transpose
		while (row < nRows && col < nCols) {
			int currCol = col + 1;
			int currRow = row + 1;
			while (currRow < nRows && currCol < nCols) {
				int tmp = mat[row][currCol];
				mat[row][currCol] = mat[currRow][col];
				mat[currRow][col] = tmp;
				currRow++;
				currCol++;
			}
			row++;
			col++;
		}

		// now reverse matrix rowwise
		int start = 0;
		int stop = nRows - 1;
		while (start < stop) {
			int[] tmp = mat[start];
			mat[start] = mat[stop];
			mat[stop] = tmp;
			start++;
			stop--;
		}
	}

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		rotateMatrix(arr);
		System.out.println("After Rotation");
		System.out.println(Arrays.deepToString(arr));

		arr = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		rotateMatrix(arr);
		System.out.println("After Rotation");
		System.out.println(Arrays.deepToString(arr));

		// using layer by layer rotation approach
	}

}
