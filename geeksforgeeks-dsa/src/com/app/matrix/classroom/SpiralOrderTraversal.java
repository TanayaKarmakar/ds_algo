package com.app.matrix.classroom;

public class SpiralOrderTraversal {
	private static void spiralTraversal(int[][] mat) {
		int nRow = mat.length;

		int nTraversal = 2 * nRow - 1;

		int endR = nRow - 1;
		int endC = mat[0].length - 1;
		int startR = 0;
		int startC = 0;
		for (int i = 0; i < nTraversal; i++) {
			for (int j = startC; j <= endC; j++) {
				System.out.print(mat[startR][j] + "\t");
			}

			startR++;
			for (int j = startR; j <= endR; j++) {
				System.out.print(mat[j][endC] + "\t");
			}

			endC--;
			for (int j = endC; j >= startC; j--) {
				System.out.print(mat[endR][j] + "\t");
			}

			endR--;
			for (int j = endR; j >= startR; j--) {
				System.out.print(mat[j][startC] + "\t");
			}

			startC++;
		}

		System.out.println();
	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		spiralTraversal(mat);
	}

}
