package com.app.practice.graphbfsdfs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrixLeetcode1091 {
	private static int shortestPathBinaryMatrix(int[][] grid) {
		Queue<int[]> q = new LinkedList<>();

		if (grid[0][0] == 1)
			return -1;
		q.add(new int[] { 0, 0 });

		int n = grid.length;

		boolean[][] visited = new boolean[n][n];
		visited[0][0] = true;

		int pathLen = 1;

		while (!q.isEmpty()) {

			int size = q.size();

			for (int k = 0; k < size; k++) {
				int[] path = q.poll();

				if (path[0] == n - 1 && path[1] == n - 1)
					return pathLen;

				for (int i = -1; i <= 1; i++) {
					for (int j = -1; j <= 1; j++) {
						int newRow = path[0] + i;
						int newCol = path[1] + j;
						if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= n || grid[newRow][newCol] == 1
								|| visited[newRow][newCol])
							continue;
						q.add(new int[] { newRow, newCol });
						visited[newRow][newCol] = true;
					}
				}
			}
			pathLen++;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[][] grid = { { 0, 1 }, { 1, 0 } };
		int ans = shortestPathBinaryMatrix(grid);

		System.out.println(ans);

		grid = new int[][] { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } };

		ans = shortestPathBinaryMatrix(grid);

		System.out.println(ans);

	}

}
