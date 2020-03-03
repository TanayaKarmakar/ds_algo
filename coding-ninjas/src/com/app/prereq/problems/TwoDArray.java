package com.app.prereq.problems;

public class TwoDArray {
	private static void printMatrix(int[][] grid) {
		int n = grid.length;
		boolean rev = false;
		for (int col = 0; col < n; col++) {
			if (!rev) {
				for (int row = 0; row < n; row++) {
					System.out.print(grid[row][col] + " ");
				}
			} else {
				for (int row = n - 1; row >= 0; row--) {
					System.out.print(grid[row][col] + " ");
				}
			}
			rev = !rev;
		}
	}

	public static void main(String[] args) {
		int[][] mat = { { 11, 12, 13, 14 }, { 21, 22, 23, 24 }, { 31, 32, 33, 34 }, { 41, 42, 43, 44 } };
		
		printMatrix(mat);
	}

}
