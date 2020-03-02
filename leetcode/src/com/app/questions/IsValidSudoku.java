package com.app.questions;

public class IsValidSudoku {
	private static boolean isSafe(char[][] grid, int row, int col, int num) {
		int n = grid.length;

		// check if any column contains the same number
		for (int c = 0; c < n; c++) {
			if (Character.isDigit(grid[row][c]) && c != col) {
				int curr = grid[row][c] - '0';
				if (curr == num)
					return false;
			}
		}

		// check if any row contains the same number
		for (int r = 0; r < n; r++) {
			if (Character.isDigit(grid[r][col]) && r != row) {
				int curr = grid[r][col] - '0';
				if (curr == num)
					return false;
			}
		}

		int sqrt = (int) Math.sqrt(n);
		int gridRowStart = row - row % sqrt;
		int gridColStart = col - col % sqrt;

		for (int i = gridRowStart; i < (gridRowStart + sqrt); i++) {
			for (int j = gridColStart; j < (gridColStart + sqrt); j++) {
				if(Character.isDigit(grid[i][j]) && (i != row && j != col) && (grid[i][j] - '0') == num)
					return false;
			}
		}
		
		return true;
	}

	private static boolean isValidSudoku(char[][] grid) {
		int n = grid.length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (Character.isDigit(grid[i][j])) {
					if (!isSafe(grid, i, j, grid[i][j] - '0'))
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
		
		System.out.println(isValidSudoku(grid));
		
		

	}

}
