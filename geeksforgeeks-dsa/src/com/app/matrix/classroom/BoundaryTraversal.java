package com.app.matrix.classroom;

public class BoundaryTraversal {
	private static void boundaryTraversal(int[][] mat) {
		int r = mat.length;
		int c = mat[0].length;

		for (int j = 0; j < c; j++) {
			System.out.print(mat[0][j] + "\t");
		}
		for (int i = 1; i < r; i++) {
			System.out.print(mat[i][c - 1] + "\t");
		}
		for (int j = c - 2; j >= 0; j--) {
			System.out.print(mat[r - 1][j] + "\t");
		}
		for (int i = r - 2; i >= 0; i--) {
			System.out.print(mat[i][0] + "\t");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		boundaryTraversal(mat);
	}

}
