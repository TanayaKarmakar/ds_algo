package com.app.questions.graphbfsdfs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrixLeetcode1091 {
	private static int shortestPathBinaryMatrix(int[][] grid) {
		int n = grid.length;
		boolean[][] visited = new boolean[n][n];
		
		if(grid[0][0] == 1)
			return -1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1)
					grid[i][j] = Integer.MAX_VALUE;
			}
		}

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0 });
		visited[0][0] = true;

		while (!q.isEmpty()) {
			int[] el = q.poll();

			if (el[0] == n - 1 && el[1] == n - 1)
				return grid[el[0]][el[1]] + 1;

			for (int r = -1; r <= 1; r++) {
				for (int c = -1; c <= 1; c++) {
					int newRow = el[0] + r;
					int newCol = el[1] + c;

					if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= n
							|| grid[newRow][newCol] == Integer.MAX_VALUE || visited[newRow][newCol] == true)
						continue;
					grid[newRow][newCol] = grid[el[0]][el[1]] + 1;
					visited[newRow][newCol] = true;
					q.add(new int[] { newRow, newCol });
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[][] grid = { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } };

		int ans = shortestPathBinaryMatrix(grid);

		System.out.println(ans);

	}

}
