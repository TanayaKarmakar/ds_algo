package com.app.practice.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMatrixZerosLeetcode73 {
	private static void setZeroes(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		Set<int[]> set = new HashSet<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					set.add(new int[] { i, j });
				}
			}
		}

		for (int[] el : set) {
			int r = el[0];
			int c = el[1];

			for (int j = 0; j < n; j++) {
				matrix[r][j] = 0;
			}

			for (int i = 0; i < m; i++) {
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
