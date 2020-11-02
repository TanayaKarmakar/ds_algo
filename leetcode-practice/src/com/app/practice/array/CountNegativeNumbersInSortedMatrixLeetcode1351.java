package com.app.practice.array;

public class CountNegativeNumbersInSortedMatrixLeetcode1351 {
	private static int countNegatives(int[][] grid) {
		if (grid.length == 0 || grid[0].length == 0)
			return 0;
		int m = grid.length;
		int n = grid[0].length;

		int count = 0;
		for (int i = 0; i < m; i++) {
			if (grid[i][0] >= 0 && grid[i][n - 1] >= 0)
				continue;
			else if (grid[i][0] < 0 && grid[i][n - 1] < 0)
				count += n;
			else {
				int j = n - 1;
				while (j >= 0 && grid[i][j] < 0) {
					count++;
					j--;
				}
			}
		}

		return count;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 4, 3, 2, -1 }, { 3, 2, 1, -1 }, { 1, 1, -1, -2 }, { -1, -1, -2, -3 } };

		int count = countNegatives(matrix);
		
		System.out.println(count);
	}

}
