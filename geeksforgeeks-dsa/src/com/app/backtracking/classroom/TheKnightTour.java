package com.app.backtracking.classroom;

public class TheKnightTour {
	private static final int MAX_MOVE = 64;
	private static final int N_ROW = 8;
	private static final int N_COL = 8;
	private static final int[] moveX = { 2, 1, -1, -2, -2, -1, 1, 2 };
	private static final int[] moveY = { 1, 2, 2, 1, -1, -2, -2, -1 };
	

	private static boolean isSafe(int[][] grid, int nextRow, int nextCol) {
		return (nextRow >= 0 && nextRow < N_ROW 
				&& nextCol >= 0 && nextCol < N_COL 
				&& grid[nextRow][nextCol] == 0);
	}

	private static boolean theKnightTour(int[][] grid, int row, int col, int moveCount) {
		if (moveCount == MAX_MOVE) {
			printSolution(grid);
			return true;
		} else {
			for (int i = 0; i < moveX.length; i++) {
				int nextRow = row + moveX[i];
				int nextCol = col + moveY[i];

				if (isSafe(grid, nextRow, nextCol)) {
					moveCount++;
					grid[nextRow][nextCol] = moveCount;
					if (theKnightTour(grid, nextRow, nextCol, moveCount))
						return true;
					moveCount--;
					grid[nextRow][nextCol] = 0;
				}
			}
		}
		return false;
	}

	private static void printSolution(int[][] grid) {
		for (int i = 0; i < N_ROW; i++) {
			for (int j = 0; j < N_COL; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] grid = new int[N_ROW][N_COL];
		
		boolean hasSolution = theKnightTour(grid, 0, 0, 1);
		if(!hasSolution) {
			System.out.println("Solution does not exist");
		}
	}
}
