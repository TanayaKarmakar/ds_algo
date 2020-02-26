package com.app.backtracking.classroom;

public class RatInAMaze {
	private static int[][] sol;

	private static boolean isSafe(int[][] maze, int i, int j, int n) {
		return (i < n && j < n && maze[i][j] == 1);
	}

	private static boolean solveRatMazeRec(int[][] maze, int i, int j, int n) {
		if (i == n - 1 && j == n - 1) {
			sol[i][j] = 1;
			return true;
		} else {
			if (isSafe(maze, i, j, n)) {
				sol[i][j] = 1;
				if (solveRatMazeRec(maze, i + 1, j, n))
					return true;
				else if (solveRatMazeRec(maze, i, j + 1, n))
					return true;
				sol[i][j] = 0;
				return false;
			}
			return false;
		}
	}

	private static boolean solveRatMaze(int[][] maze, int i, int j) {
		int n = maze.length;
		sol = new int[n][n];
		if (!solveRatMazeRec(maze, i, j, n)) {
			return false;
		} else {
			printSolution(n);
			return true;
		}
	}

	private static void printSolution(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(sol[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] maze = { { 1, 0, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		boolean isPossibleSolution = solveRatMaze(maze, 0, 0);
		System.out.println("isPossibleSolution - " + isPossibleSolution);

		maze = new int[][] { { 1, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };	
		isPossibleSolution = solveRatMaze(maze, 0, 0);
		System.out.println("isPossibleSolution - " + isPossibleSolution);

	}

}
