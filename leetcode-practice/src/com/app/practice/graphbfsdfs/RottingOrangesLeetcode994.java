package com.app.practice.graphbfsdfs;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOrangesLeetcode994 {
	private static final int[] rDir = { -1, 1, 0, 0 };
	private static final int[] cDir = { 0, 0, -1, 1 };

	private static int orangesRotting(int[][] grid) {
		int timesRemaining = -1;

		Queue<int[]> q = new LinkedList<>();

		int m = grid.length;
		int n = grid[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 2) {
					q.add(new int[] { i, j });
				}
			}
		}
		q.add(null);

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			if (curr == null) {
				timesRemaining++;
				if (q.peek() != null) {
					q.add(null);
				}
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int newRow = curr[0] + rDir[i];
				int newCol = curr[1] + cDir[i];

				if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || grid[newRow][newCol] != 1)
					continue;
				grid[newRow][newCol] = 2;
				q.add(new int[] { newRow, newCol });
			}
		}

		return timesRemaining;
	}

	public static void main(String[] args) {
		int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		
		int timesRemaining = orangesRotting(grid);
		
		System.out.println(timesRemaining);
	}

}
