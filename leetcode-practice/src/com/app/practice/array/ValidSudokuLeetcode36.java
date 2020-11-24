package com.app.practice.array;

public class ValidSudokuLeetcode36 {
	private static boolean isSafe(char[][] board, int row, int col) {
		int num = board[row][col];

		for (int c = 0; c < 9; c++) {
			if (col != c && board[row][c] == num)
				return false;
		}

		for (int r = 0; r < 9; r++) {
			if (row != r && board[r][col] == num)
				return false;
		}

		int startRow = row - (row % 3);
		int startCol = col - (col % 3);

		for (int i = startRow; i < startRow + 3; i++) {
			for (int j = startCol; j < startCol + 3; j++) {
				if (i != row && j != col && board[i][j] == num)
					return false;
			}
		}

		return true;
	}

	private static boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					if (!isSafe(board, i, j))
						return false;
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' }, {},
				{}, {}, {}, {}, {} };

	}

}
