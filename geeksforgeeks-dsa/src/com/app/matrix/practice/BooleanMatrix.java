package com.app.matrix.practice;

public class BooleanMatrix {
	private static void modifyMat(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;

		int[] row = new int[m];
		int[] col = new int[n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 1) {
					row[i] = 1;
					col[j] = 1;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (row[i] == 1 || col[j] == 1) {
					mat[i][j] = 1;
				}
			}
		}

		System.out.println("After modification, the matrix is ");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 0, 0 }, { 1, 0, 0 }, { 1, 0, 0 }, { 0, 0, 0 } };
		modifyMat(mat);

	}
	
}
