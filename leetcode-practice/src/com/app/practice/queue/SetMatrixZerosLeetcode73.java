package com.app.practice.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SetMatrixZerosLeetcode73 {
	private static void setZeroes(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					q.add(new int[] { i, j });
				}
			}
		}

		while (!q.isEmpty()) {
			int[] pos = q.poll();
			int r = pos[0];
			int c = pos[1];

			for (int i = 0; i < n; i++) {
				if (matrix[r][i] == 0)
					continue;
				matrix[r][i] = 0;
			}

			for (int i = 0; i < m; i++) {
				if (matrix[i][c] == 0)
					continue;
				matrix[i][c] = 0;
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		
		setZeroes(matrix);
		
		System.out.println(Arrays.deepToString(matrix));

	}

}
