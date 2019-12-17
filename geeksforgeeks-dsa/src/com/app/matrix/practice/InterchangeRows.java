package com.app.matrix.practice;

public class InterchangeRows {
	private static void interchangeRows(int[][] mat) {
		int row = mat.length;
		int start = 0;
		int end = row - 1;
		while (start <= end) {
			int[] tmp = mat[start];
			mat[start] = mat[end];
			mat[end] = tmp;
			start++;
			end--;
		}

		int col = mat[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		interchangeRows(mat);
	}

}
