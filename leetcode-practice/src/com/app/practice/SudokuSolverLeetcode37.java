package com.app.practice;

public class SudokuSolverLeetcode37 {
	private static final int GRID_SIZE = 9;
	
	private static boolean isSafe(char[][] grid, int row, int col, int number) {
		//check number is present in the same row or not
		for(int i = 0; i < GRID_SIZE; i++) {
			if(grid[row][i] - '0' == number)
				return false;
		}
		
		//check if number is present in the same column
		for(int i = 0; i < GRID_SIZE; i++) {
			if(grid[i][col] - '0' == number)
				return false;
		}
		
		int sqrt = 3;
		int rowStart = row - (row % sqrt);
		int colStart = col - (col % sqrt);
		
		for(int i = rowStart; i < rowStart + sqrt; i++) {
			for(int j = colStart; j < colStart + sqrt; j++) {
				if(grid[i][j] - '0' == number)
					return false;
			}
		}
		
		return true;
	}
	
	private static boolean solveSudokuRec(char[][] grid) {
		int row = -1;
		int col = -1;
		boolean isEmpty = false;
		for(int i = 0; i < GRID_SIZE; i++) {
			for(int j = 0; j < GRID_SIZE; j++) {
				if(grid[i][j] == '.') {
					row = i;
					col = j;
					isEmpty = true;
					break;
				}
			}
			if(isEmpty)
				break;
		}
		
		if(!isEmpty)
			return true;
		
		for(int i = 1; i <= GRID_SIZE; i++) {
			if(isSafe(grid, row, col, i)) {
				grid[row][col] = (char)(i + '0');
				if(solveSudokuRec(grid))
					return true;
				grid[row][col] = '.';
			}
		}
		return false;
	}
	
	private static void printSolution(char[][] grid) {
		for(int i = 0; i < GRID_SIZE; i++) {
			for(int j = 0; j < GRID_SIZE; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private static void solveSudoku(char[][] grid) {
		boolean possible = solveSudokuRec(grid);
		if(possible) {
			printSolution(grid);
		}
	}

	public static void main(String[] args) {
		char[][] grid = {{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}};
		
		solveSudoku(grid);

	}

}
