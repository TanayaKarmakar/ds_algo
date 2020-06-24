package com.app.problems.gfg.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StepsByKnight {
	private static boolean isSafe(int[][] grid, int i, int j, int n) {
		return (i >= 0 && i < n && j >= 0 && j < n && grid[i][j] != -1);
	}

	private static int minMoveCount(int[][] grid, int[] start, int[] end, int n) {
		int[][] moves = { { 2, -1 }, { 2, 1 }, { -2, -1 }, { -2, 1 }, { 1, -2 }, { 1, 2 }, { -1, -2 }, { -1, 2 } };

		Queue<int[]> q = new LinkedList<>();

		q.add(start);
		q.add(null);

		grid[start[0]][start[1]] = -1;

		int count = 0;

		while (!q.isEmpty()) {
			int[] point = q.poll();
			if (point == null) {
				if (q.peek() != null) {
					q.add(null);
				}
				count++;
				continue;
			}
			if (point[0] == end[0] && point[1] == end[1])
				return count;

			for (int i = 0; i < 8; i++) {
				int newRow = point[0] + moves[i][0];
				int newCol = point[1] + moves[i][1];
				if (isSafe(grid, newRow, newCol, n)) {
					q.add(new int[] { newRow, newCol });
					grid[newRow][newCol] = -1;
				}
			}
		}
		return Integer.MAX_VALUE;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();

		while (nTestCases-- > 0) {
			int n = scanner.nextInt();
			int[][] grid = new int[n][n];

			int[] start = new int[2];
			int[] end = new int[2];

			int sX = scanner.nextInt();
			int sY = scanner.nextInt();

			int eX = scanner.nextInt();
			int eY = scanner.nextInt();

			start[0] = sX - 1;
			start[1] = sY - 1;

			end[0] = eX - 1;
			end[1] = eY - 1;

			int moveCount = minMoveCount(grid, start, end, n);
			System.out.println(moveCount);
		}

		scanner.close();
	}

}
