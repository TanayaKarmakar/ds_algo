package com.app.problems.gfg.backtracking;

import java.util.Scanner;

public class MColoringProblem {
	private static boolean isSafe(int[][] grid, int row, int m, int n, int[] sol) {
		for (int c = 0; c < n; c++) {
			if (grid[row][c] == 1 && sol[c] == m) {
				return false;
			}
		}
		return true;
	}

	private static boolean solve(int[][] grid, int n, int[] sol, int row, int m) {
		if (row == n) {
			//System.out.println(Arrays.toString(sol));
			return true;
		}
		for (int i = 1; i <= m; i++) {
			if (isSafe(grid, row, i, n, sol)) {
				sol[row] = i;
				if (solve(grid, n, sol, row + 1, m) == true)
					return true;
				sol[row] = 0;
				return false;
			}
		}
		return false;
	}

	private static boolean solve(int[][] grid, int n, int m) {
		int[] sol = new int[n];
		return solve(grid, n, sol, 0, m);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();

		while (nTestCases-- > 0) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			int e = scanner.nextInt();

			int[][] grid = new int[n][n];

			for (int i = 0; i < e; i++) {
				int v1 = scanner.nextInt();
				int v2 = scanner.nextInt();

				grid[v1 - 1][v2 - 1] = 1;
				grid[v2 - 1][v1 - 1] = 1;
			}

			if (solve(grid, n, m))
				System.out.println("1");
			else
				System.out.println("0");
		}
		scanner.close();

	}

}
