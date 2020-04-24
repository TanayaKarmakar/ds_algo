package com.app.questions.practice;

public class CountNegativeNumbersInSortedMatrixLeetcode1351 {
	private static int countNegatives(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		int count = 0;
		for (int i = m - 1; i >= 0; i--) {
			if (grid[i][0] < 0) {
				count += n;
				continue;
			}

			int j = n - 1;
			while (j >= 0 && grid[i][j] < 0) {
				count++;
				j--;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[][] mat = { { 4, 3, 2, -1 }, { 3, 2, 1, -1 }, { 1, 1, -1, -2 }, { -1, -1, -2, -3 } };

		int countNeg = countNegatives(mat);

		System.out.println(countNeg);

		mat = new int[][] { { 3, 2 }, { 1, 0 } };

		countNeg = countNegatives(mat);

		System.out.println(countNeg);
		
		

	}

}
