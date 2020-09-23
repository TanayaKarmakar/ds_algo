package com.app.practice.graphbfsdfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrixLeetcode542 {
	private static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	private static int[][] updateMatrix(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		boolean[][] visited = new boolean[m][n];
		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					q.add(new int[] { i, j });
					visited[i][j] = true;
				}
			}
		}

		while (!q.isEmpty()) {
			int[] el = q.poll();

			for (int i = 0; i < 4; i++) {
				int newRow = el[0] + dir[i][0];
				int newCol = el[1] + dir[i][1];
				if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || visited[newRow][newCol])
					continue;
				matrix[newRow][newCol] = matrix[el[0]][el[1]] + 1;
				q.add(new int[] { newRow, newCol });
				visited[newRow][newCol] = true;
			}
		}

		return matrix;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };

		matrix = updateMatrix(matrix);

		System.out.println(Arrays.deepToString(matrix));
	}

}
