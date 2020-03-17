package com.app.backtracking.problems;

public class RatInAMaze {
	private static void printSolution(int[][] sol, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(sol[i][j] + " ");
			}
		}
		System.out.println();
	}

	private static void solveRec(int[][] maze, int[][] sol, int n, int row, int col) {
		if (row == n - 1 && col == n - 1) {
			sol[row][col] = 1;
			printSolution(sol, n);
			return;
		}
		if (row < 0 || row >= n || col < 0 || col >= n || maze[row][col] == 0 || sol[row][col] == 1) {
			return;
		}
		sol[row][col] = 1;
		solveRec(maze, sol, n, row - 1, col);
		solveRec(maze, sol, n, row + 1, col);
		solveRec(maze, sol, n, row, col - 1);
		solveRec(maze, sol, n, row, col + 1);
		sol[row][col] = 0;
	}

	private static void solve(int[][] maze) {
		int n = maze.length;
		int[][] sol = new int[n][n];
		solveRec(maze, sol, n, 0, 0);
	}

	public static void main(String[] args) {
		int[][] maze = { { 1, 1, 0 }, { 1, 1, 1 }, { 1, 1, 1 } };
		solve(maze);
	}

}
