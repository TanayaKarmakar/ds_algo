package com.app.practice;

import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;

public class WallsAndGatesLeetcode286 {
	private static int[] rDir = { -1, 1, 0, 0 };
	private static int[] cDir = { 0, 0, -1, 1 };

	private static final int EMPTY = Integer.MAX_VALUE;
	private static final int GATE = 0;

	private static void wallsAndGates(int[][] grid) {
		Queue<int[]> q = new LinkedList<>();
		int m = grid.length;
		int n = grid[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == GATE) {
					q.add(new int[] { i, j });
				}
			}
		}

		while (!q.isEmpty()) {
			int[] coord = q.poll();
			int row = coord[0];
			int col = coord[1];

			for (int i = 0; i < 4; i++) {
				int newRow = row + rDir[i];
				int newCol = col + cDir[i];

				if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length
						|| grid[newRow][newCol] != EMPTY)
					continue;
				grid[newRow][newCol] = grid[row][col] + 1;
				q.add(new int[] { newRow, newCol });
			}
		}
	}

	public static void main(String[] args) {
		int[][] grid = { { EMPTY, -1, 0, EMPTY }, 
				{ EMPTY, EMPTY, EMPTY, -1 }, 
				{ EMPTY, -1, EMPTY, -1 },
				{ 0, -1, EMPTY, EMPTY } };
		
		wallsAndGates(grid);
		
		System.out.println(Arrays.deepToString(grid));

	}

}
