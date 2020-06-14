package com.app.questions.read;

import java.util.LinkedList;
import java.util.Queue;

public class TallestPossibleBuilding {
	private static int tallestPossibleBuilding(char[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		int[] rDir = { -1, 1, 0, 0 };
		int[] cDir = { 0, 0, -1, 1 };
		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 'P') {
					q.add(new int[] { i, j });
				}
			}
		}
		q.add(null);

		int maxVal = 0;
		int count = 1;

		while (!q.isEmpty()) {
			int[] point = q.poll();
			if(point == null) {
				count++;
				if(q.peek() != null) {
					q.add(null);
				}
				continue;
			}

			int row = point[0];
			int col = point[1];

			for (int i = 0; i < 4; i++) {
				int newRow = row + rDir[i];
				int newCol = col + cDir[i];

				if (newRow < 0 || newRow >= m || newCol < 0 
						|| newCol >= n || grid[newRow][newCol] != '-')
					continue;
				grid[newRow][newCol] = (char)(count + '0');
				maxVal = Integer.max(maxVal, count);
				q.add(new int[] { newRow, newCol });
			}
		}

		return maxVal;
	}

	public static void main(String[] args) {
		char[][] grid = { { '-', '-', '-' }, { '-', '-', '-' }, { '-', '-', 'P' } };

		int tallestBuilding = tallestPossibleBuilding(grid);

		System.out.println(tallestBuilding);

		grid = new char[][] { { '-', '-', 'P' }, { '-', '-', '-' }, { '-', '-', 'P' } };

		tallestBuilding = tallestPossibleBuilding(grid);

		System.out.println(tallestBuilding);

	}

}
