package com.app.practice.graphbfsdfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrixLeetcode542 {
	private static final int[] rDir = { -1, 1, 0, 0 };
	private static final int[] cDir = { 0, 0, -1, 1 };

	private static int[][] updateMatrix(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;

		int[][] dist = new int[n][m];
		boolean[][] visited = new boolean[n][m];

		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == 0) {
					q.add(new int[] { i, j });
					visited[i][j] = true;
				}
			}
		}

		while (!q.isEmpty()) {
			int[] pt = q.poll();

			for (int i = 0; i < 4; i++) {
				int newRow = pt[0] + rDir[i];
				int newCol = pt[1] + cDir[i];

				if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= m || visited[newRow][newCol])
					continue;
				dist[newRow][newCol] = 1 + matrix[pt[0]][pt[1]];
				q.add(new int[] { newRow, newCol });
				visited[newRow][newCol] = true;
			}
		}

		return dist;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };

		matrix = updateMatrix(matrix);

		System.out.println(Arrays.deepToString(matrix));

		matrix = new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
	
		matrix = updateMatrix(matrix);

		System.out.println(Arrays.deepToString(matrix));
	}

}
