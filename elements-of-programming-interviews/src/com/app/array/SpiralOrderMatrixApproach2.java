package com.app.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderMatrixApproach2 {
	private static final int[][] SHIFT = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	private static List<Integer> getSpiralOrder(int[][] matrix) {
		int dir = 0;
		int x = 0;
		int y = 0;
		List<Integer> res = new ArrayList<>();

		int n = matrix.length;
		for (int i = 0; i < (n * n); i++) {
			res.add(matrix[x][y]);
			matrix[x][y] = 0;
			int nextX = x + SHIFT[dir][0];
			int nextY = y + SHIFT[dir][1];

			if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n || matrix[nextX][nextY] == 0) {
				dir = (dir + 1) % 4;
				nextX = x + SHIFT[dir][0];
				nextY = y + SHIFT[dir][1];
			}

			x = nextX;
			y = nextY;
		}

		return res;

	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		List<Integer> res = getSpiralOrder(matrix);
		
		System.out.println(res);
	}

}
