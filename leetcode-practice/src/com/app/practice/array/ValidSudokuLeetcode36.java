package com.app.practice.array;

public class ValidSudokuLeetcode36 {
	private static final int GRID_SIZE = 9;

	private static boolean isSafe(char[][] board, int i, int j) {
		int num = board[i][j] - '0';

		for (int c = 0; c < GRID_SIZE; c++) {
			if (c != j && (board[i][c] - '0') == num)
				return false;
		}

		for (int r = 0; r < GRID_SIZE; r++) {
			if (r != i && (board[r][j] - '0') == num)
				return false;
		}

		int sqrt = 3;
		int rowStart = i - (i % sqrt);
		int colStart = j - (j % sqrt);

		for (int i1 = rowStart; i1 < (rowStart + sqrt); i1++) {
			for (int j1 = colStart; j1 < (colStart + sqrt); j1++) {
				if (i1 != i && j1 != j && (board[i1][j1] - '0') == num)
					return false;
			}
		}

		return true;
	}

	private static boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < GRID_SIZE; i++) {
			for (int j = 0; j < GRID_SIZE; j++) {
				if (board[i][j] != '.') {
					if (!isSafe(board, i, j))
						return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		char [][] grid = {
				{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}
		};
		
		boolean isValid = isValidSudoku(grid);
		
		System.out.println(isValid);
	}

}
