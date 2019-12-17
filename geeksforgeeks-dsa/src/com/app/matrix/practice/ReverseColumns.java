package com.app.matrix.practice;

public class ReverseColumns {
	private static void reverseColumn(int[][] mat) {
		int row = mat.length;
		int col = mat[0].length;

		for (int i = 0; i < row; i++) {
			int start = 0;
			int end = col - 1;
			while (start <= end) {
				int tmp = mat[i][start];
				mat[i][start] = mat[i][end];
				mat[i][end] = tmp;
				start++;
				end--;
			}
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 2, 3 }, { 5, 6, 7 }, { 9, 10, 11 }, { 13, 14, 15 } };
		
		reverseColumn(mat);

	}

}
