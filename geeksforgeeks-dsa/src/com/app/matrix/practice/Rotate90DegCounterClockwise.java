package com.app.matrix.practice;

import java.util.Arrays;

public class Rotate90DegCounterClockwise {
	private static void rotate90Deg(int[][] mat) {
		int row = mat.length;
		int col = mat[0].length;

		for (int i = 0; i < row; i++) {
			for (int j = i; j < col; j++) {
				swap(mat, i, j);
			}
		}

		int start = 0;
		int end = row - 1;

		while (start <= end) {
			int[] tmp = mat[start];
			mat[start] = mat[end];
			mat[end] = tmp;
			start++;
			end--;
		}
	}

	private static void swap(int[][] mat, int i, int j) {
		int tmp = mat[i][j];
		mat[i][j] = mat[j][i];
		mat[j][i] = tmp;
	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotate90Deg(mat);

		System.out.println("After rotation, the matrix is ");
		System.out.println(Arrays.deepToString(mat));

	}

}
