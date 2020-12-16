package com.app.practice.array;

public class ValidSudokuLeetcode36 {
	private static final int GRID_SIZE = 9;

	private static boolean isSafe(char[][] board, int r, int c) {
		char val = board[r][c];

		for (int i = 0; i < GRID_SIZE; i++) {
			if (i != c && board[r][i] == val)
				return false;
		}

		for (int i = 0; i < GRID_SIZE; i++) {
			if (i != r && board[i][c] == val)
				return false;
		}

		int startRow = r - r % 3;
		int startCol = c - c % 3;

		for (int i = startRow; i < startRow + 3; i++) {
			for (int j = startCol; j < startCol + 3; j++) {
				if (i != r && j != c && board[i][j] == val)
					return false;
			}
		}

		return true;
	}

	private static boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < GRID_SIZE; i++) {
			for (int j = 0; j < GRID_SIZE; j++) {
				if (Character.isDigit(board[i][j])) {
					if (!isSafe(board, i, j))
						return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
