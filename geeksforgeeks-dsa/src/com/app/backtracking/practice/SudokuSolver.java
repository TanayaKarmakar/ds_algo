package com.app.backtracking.practice;

public class SudokuSolver {
	private static boolean isSafe(int[][] grid, int row, int col, int num) {
		// check if any other column has same number
		for (int i = 0; i < grid.length; i++) {
			if (grid[row][i] == num)
				return false;
		}

		// check if any other row has the same number
		for (int i = 0; i < grid.length; i++) {
			if (grid[i][col] == num)
				return false;
		}

		int sqrt = (int) Math.sqrt(grid.length);

		int subGridRowStart = row - row % sqrt;
		int subGridColStart = col - col % sqrt;

		for (int i = subGridRowStart; i < (subGridRowStart + sqrt); i++) {
			for (int j = subGridColStart; j < (subGridColStart + sqrt); j++) {
				if (grid[i][j] == num)
					return false;
			}
		}

		return true;
	}

	private static boolean solveSudoku(int[][] grid) {
		boolean isEmpty = true;
		int row = -1;
		int col = -1;
		int n = grid.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 0) {
					isEmpty = false;
					row = i;
					col = j;
					break;
				}
			}
			if (!isEmpty)
				break;
		}

		if (isEmpty)
			return true;

		for (int num = 1; num <= 9; num++) {
			if (isSafe(grid, row, col, num)) {
				grid[row][col] = num;
				if (solveSudoku(grid))
					return true;
				grid[row][col] = 0;
			}
		}

		return false;
	}

	private static void printGrid(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] grid = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
				{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
				{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

		boolean isPossible = solveSudoku(grid);
		if(isPossible) {
			printGrid(grid);
		}

	}

}
