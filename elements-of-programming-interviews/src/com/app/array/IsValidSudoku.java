package com.app.array;

public class IsValidSudoku {
	private static final int GRID_SIZE = 9;

	private static boolean isSafe(int[][] matrix, int i, int j) {
		int num = matrix[i][j];

		for (int c = 0; c < GRID_SIZE; c++) {
			if (c != j && matrix[i][c] == num)
				return false;
		}

		for (int r = 0; r < GRID_SIZE; r++) {
			if (r != i && matrix[r][j] == num)
				return false;
		}

		int sqrt = 3;
		int rowStart = i - (i % sqrt);
		int colStart = j - (j % sqrt);
		for (int r = rowStart; r < (rowStart + sqrt); r++) {
			for (int c = colStart; c < (colStart + sqrt); c++) {
				if (r != i && c != j && matrix[r][c] == num)
					return false;
			}
		}

		return true;
	}

	private static boolean isValidSudoku(int[][] matrix) {
		for (int i = 0; i < GRID_SIZE; i++) {
			for (int j = 0; j < GRID_SIZE; j++) {
				if (matrix[i][j] != 0) {
					if (!isSafe(matrix, i, j))
						return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 5, 3, 0, 0, 7, 0, 0, 0, 0 }, { 6, 0, 0, 1, 9, 5, 0, 0, 0 }, { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
				{ 8, 0, 0, 0, 6, 0, 0, 0, 3 }, { 4, 0, 0, 8, 0, 3, 0, 0, 1 }, { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
				{ 0, 6, 0, 0, 0, 0, 2, 8, 0 }, { 0, 0, 0, 4, 1, 9, 0, 0, 5 }, { 0, 0, 0, 0, 8, 0, 0, 7, 9 } };
		boolean ans = isValidSudoku(matrix);
		
		System.out.println(ans);
	}

}
