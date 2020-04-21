package com.app.questions.practice;

public class SudokuSolverLeetcode37 {
	private static final int GRID_SIZE = 9;

	private static boolean isSafe(char[][] grid, int num, int row, int col) {
		for(int i = 0; i < GRID_SIZE; i++) {
			if(grid[row][i] - '0' == num)
				return false;
		}
		
		for(int i = 0; i < GRID_SIZE; i++) {
			if(grid[i][col] - '0' == num) 
				return false;
		}
		
		int sqrt = 3;
		int subRowStart = row - row % sqrt;
		int subColStart = col - col % sqrt;
		
		for(int i = subRowStart; i < (subRowStart + sqrt); i++) {
			for(int j = subColStart; j < (subColStart + sqrt); j++) {
				if(grid[i][j] - '0' == num)
					return false;
			}
		}
		return true;
	}

	private static boolean canSolve(char[][] grid) {
		boolean isEmpty = false;
		int row = -1;
		int col = -1;
		for (int i = 0; i < GRID_SIZE; i++) {
			for (int j = 0; j < GRID_SIZE; j++) {
				if (grid[i][j] == '.') {
					row = i;
					col = j;
					isEmpty = true;
					break;
				}
			}
			if(isEmpty)
				break;
		}
		if (!isEmpty)
			return true;
		
		for (int num = 1; num <= 9; num++) {
			if(isSafe(grid, num, row, col)) {
				grid[row][col] = (char)(num + '0');
				if(canSolve(grid))
					return true;
				grid[row][col] = '.';
			}
		}
		return false;
	}
	
	private static void solveSudoku(char[][] grid) {
		boolean isPossible = canSolve(grid);
		if (isPossible) {
			printSolution(grid);
		}
	}
	
	private static void printSolution(char[][] grid) {
		for (int i = 0; i < GRID_SIZE; i++) {
			for (int j = 0; j < GRID_SIZE; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
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
