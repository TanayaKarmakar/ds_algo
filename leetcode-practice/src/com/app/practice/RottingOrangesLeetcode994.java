package com.app.practice;

import java.util.Queue;
import java.util.LinkedList;

public class RottingOrangesLeetcode994 {
	private static int[] rDir = { -1, 1, 0, 0 };
	private static int[] cDir = { 0, 0, -1, 1 };

	private static int orangesRotting(int[][] grid) {
		Queue<int[]> q = new LinkedList<>();
		int r = grid.length;
		int c = grid[0].length;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (grid[i][j] == 2) {
					q.add(new int[] { i, j });
				}
			}
		}

		q.add(null);
		int times = -1;
		while (!q.isEmpty()) {
			int[] point = q.poll();
			if (point == null) {
				if (q.peek() != null) {
					q.add(null);
				}
				times++;
				continue;
			}
			for (int i = 0; i < 4; i++) {
				int newRow = point[0] + rDir[i];
				int newCol = point[1] + cDir[i];
				if (newRow < 0 || newRow >= r || newCol < 0 
						|| newCol >= c || grid[newRow][newCol] != 1) {
					continue;
				} else {
					grid[newRow][newCol] = 2;
					q.add(new int[] { newRow, newCol });
				}
			}

		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (grid[i][j] == 1)
					return -1;
			}
		}
		return times;
	}

	public static void main(String[] args) {
		int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		
		int times = orangesRotting(grid);
		
		System.out.println(times);
	}

}
