package com.app.practice.array;

import java.util.Arrays;

public class SpiralMatrixIILeetcode59 {
	private static final int[][] SHIFT = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	private static int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];

		int val = 1;
		int total = (n * n);
		int x = 0;
		int y = 0;

		int dir = 0;
		while (val <= total) {
			matrix[x][y] = val++;

			int nextX = x + SHIFT[dir][0];
			int nextY = y + SHIFT[dir][1];

			if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n 
					|| matrix[nextX][nextY] != 0) {
				dir = (dir + 1) % 4;
				nextX = x + SHIFT[dir][0];
				nextY = y + SHIFT[dir][1];
			}

			x = nextX;
			y = nextY;
		}

		return matrix;
	}

	public static void main(String[] args) {
		int n = 3;
		int[][] matrix = generateMatrix(n);
		
		System.out.println(Arrays.deepToString(matrix));

	}

}
