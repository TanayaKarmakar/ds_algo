package com.app.array;

import java.util.Scanner;

public class GenerateSpiralOrderSquareMatrix {
	private static final int[][] SHIFT = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	private static int[][] getSpiralMatrix(int d) {
		int[][] matrix = new int[d][d];

		int val = 1;
		int x = 0;
		int y = 0;
		int dir = 0;
		for (int i = 0; i < (d * d); i++) {
			matrix[x][y] = val++;
			int nextX = x + SHIFT[dir][0];
			int nextY = y + SHIFT[dir][1];
			if (nextX < 0 || nextX >= d || nextY < 0 || nextY >= d || matrix[nextX][nextY] != 0) {
				dir = (dir + 1) % 4;
				nextX = x + SHIFT[dir][0];
				nextY = y + SHIFT[dir][1];
			}

			x = nextX;
			y = nextY;
		}
		return matrix;
	}
	
	private static void display(int[][] matrix) {
		int n = matrix.length;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int d = scanner.nextInt();

		int[][] matrix = getSpiralMatrix(d);
		display(matrix);
		
		scanner.close();
	}

}
