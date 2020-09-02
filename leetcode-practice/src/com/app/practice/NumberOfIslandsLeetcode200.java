package com.app.practice;

public class NumberOfIslandsLeetcode200 {
	private static void move(char[][] grid, int i, int j, int m, int n) {
		if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0')
			return;
		grid[i][j] = '0';
		move(grid, i - 1, j, m, n);
		move(grid, i + 1, j, m, n);
		move(grid, i, j - 1, m, n);
		move(grid, i, j + 1, m, n);
	}

	private static int numIslands(char[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1') {
					move(grid, i, j, m, n);
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TC1
		char[][] grid = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '0', '0', '0' } };

		int count = numIslands(grid);

		System.out.println(count);

		grid = new char[][] { { '1', '1', '0', '0', '0' }, { '1', '0', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };
				
		count = numIslands(grid);

		System.out.println(count);
	}

}
