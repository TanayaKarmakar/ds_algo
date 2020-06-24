package com.app.problems.gfg.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindWhetherPathExists {
	private static boolean isSafe(int[][] grid, int i, int j, int n) {
		return (i >= 0 && i < n && j >= 0 && j < n && grid[i][j] != 0);
	}

	private static boolean isPathExists(int[][] grid, int n) {
		int[] rDir = { -1, 1, 0, 0 };
		int[] cDir = { 0, 0, -1, 1 };

		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					q.add(new int[] { i, j });
					break;
				}
			}
		}

		while (!q.isEmpty()) {
			int[] point = q.poll();
			if (grid[point[0]][point[1]] == 2)
				return true;

			for (int i = 0; i < 4; i++) {
				int newRow = point[0] + rDir[i];
				int newCol = point[1] + cDir[i];

				if (isSafe(grid, newRow, newCol, n)) {
					q.add(new int[] { newRow, newCol });
				}
			}

			grid[point[0]][point[1]] = 0;
		}
		
		return false;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();

		while (nTestCases-- > 0) {
			int n = scanner.nextInt();
			int[][] grid = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					grid[i][j] = scanner.nextInt();
				}
			}
			
			boolean pathExists = isPathExists(grid, n);
			if(pathExists) {
				System.out.println("1");
			} else {
				System.out.println("0");
			}
		}

		scanner.close();

	}

}
