package com.app.matrix.classroom;

import java.util.Arrays;

public class RotateMatrix90DegCounterClockwise {
	private static void rotateMatrix(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = i; j < mat[i].length; j++) {
				int tmp = mat[i][j];
				mat[i][j] = mat[j][i];
				mat[j][i] = tmp;
			}
		}

		int start = 0;
		int end = mat.length - 1;

		while (start <= end) {
			int[] tmp = mat[start];
			mat[start] = mat[end];
			mat[end] = tmp;
			start++;
			end--;
		}

		System.out.println("After rotation, the matrix is ");
		System.out.println(Arrays.deepToString(mat));
	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotateMatrix(mat);

	}

}
