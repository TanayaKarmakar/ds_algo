package com.app.problems.gfg.backtracking;

import java.util.Scanner;

public class RatMazeWithMultipleJumps {
	private static boolean isSafe(int[][] maze, int i, int j, int n) {
		return (i >= 0 && i < n && j >= 0 && j < n && maze[i][j] != 0);
	}

	private static boolean solve(int[][] maze, int n, int i, int j, int[][] sol) {
		if (i == n - 1 && j == n - 1) {
			sol[i][j] = 1;
			// printsolution
			printSolution(sol, n);
			return true;
		}

		if (isSafe(maze, i, j, n)) {
			sol[i][j] = 1;
			for (int k = 1; k <= maze[i][j]; k++) {
				if (solve(maze, n, i + k, j, sol) == true)
					return true;

				if (solve(maze, n, i, j + k, sol) == true)
					return true;
			}
			sol[i][j] = 0;
			return false;
		}

		return false;
	}

	private static void printSolution(int[][] sol, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(sol[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void solve(int[][] maze, int n) {
		int[][] sol = new int[n][n];
		boolean solve = solve(maze, n, 0, 0, sol);
		if (!solve) {
			System.out.println("-1");
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();

		while (nTestCases-- > 0) {
			int n = scanner.nextInt();
			int[][] mat = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					mat[i][j] = scanner.nextInt();
				}
			}

			solve(mat, n);
		}

		scanner.close();
	}

}
