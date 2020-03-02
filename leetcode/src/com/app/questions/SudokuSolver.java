package com.app.questions;

public class SudokuSolver {
	private static final int GRID_SIZE = 9;

	private static boolean isSafe(char[][] grid, int row, int col, int num) {
		// check if column contains the num
		for (int j = 0; j < GRID_SIZE; j++) {
			if (grid[row][j] - '0' == num)
				return false;
		}

		// check if row contains the sum
		for (int j = 0; j < GRID_SIZE; j++) {
			if (grid[j][col] - '0' == num)
				return false;
		}

		int sqrt = (int) Math.sqrt(GRID_SIZE);
		int gridRowStart = row - row % sqrt;
		int gridColStart = col - col % sqrt;

		for (int i = gridRowStart; i < (gridRowStart + sqrt); i++) {
			for (int j = gridColStart; j < (gridColStart + sqrt); j++) {
				if (grid[i][j] - '0' == num)
					return false;
			}
		}
		return true;
	}

	private static boolean solveSudokuRec(char[][] grid) {
		boolean isEmpty = true;
		int row = -1;
		int col = -1;
		for (int i = 0; i < GRID_SIZE; i++) {
			for (int j = 0; j < GRID_SIZE; j++) {
				if (grid[i][j] == '.') {
					row = i;
					col = j;
					isEmpty = false;
					break;
				}
			}
			if (!isEmpty)
				break;
		}

		if (isEmpty)
			return true;

		for (int n = 1; n <= GRID_SIZE; n++) {
			if (isSafe(grid, row, col, n)) {
				grid[row][col] = (char)(n + '0');
				if (solveSudokuRec(grid))
					return true;
				grid[row][col] = '.';
			}
		}

		return false;
	}

	private static void printSolution(char[][] grid) {
		for (int i = 0; i < GRID_SIZE; i++) {
			for (int j = 0; j < GRID_SIZE; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void solveSudoku(char[][] grid) {
		boolean isPossible = solveSudokuRec(grid);
		if (isPossible) {
			printSolution(grid);
		}
	}

	public static void main(String[] args) {
		char[][] grid = {
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
		
		solveSudoku(grid);

	}

}
