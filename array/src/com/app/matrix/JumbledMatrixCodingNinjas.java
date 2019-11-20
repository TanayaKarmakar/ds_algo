package com.app.matrix;

import java.util.Arrays;

public class JumbledMatrixCodingNinjas {
	private static int[][] buildMatrix(int n) {
		int[][] mat = new int[n][n];
		int count = 1;
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				mat[row][col] = count++;
			}
		}

		return mat;
	}

	private static void jumbleMatrix(int n) {
		int[][] mat = buildMatrix(n);

		int[][] tmp = new int[n][n];

		for (int col = 0; col < n; col++) {
			tmp[0][col] = mat[0][col];
		}

		int count = 1;
		for (int row = 2; row < n; row = 2 * row) {
			for (int col = 0; col < n; col++) {
				tmp[count][col] = mat[row][col];
			}
			count++;
		}

		for (int row = calculateStart(n); row >= 1; row -= 2) {
			if (count < n) {
				for (int col = 0; col < n; col++) {
					tmp[count][col] = mat[row][col];
				}
			}
			count++;
		}

		System.out.println(Arrays.deepToString(tmp));
	}

	private static int calculateStart(int n) {
		return n % 2 == 0 ? (n - 1) : (n - 2);
	}

	public static void main(String[] args) {
		jumbleMatrix(6);
	}

}
