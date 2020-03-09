package com.app.questions;

public class NumberOfIslands {
	private static void move(char[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
			return;

		grid[i][j] = '0';
		move(grid, i - 1, j);
		move(grid, i + 1, j);
		move(grid, i, j - 1);
		move(grid, i, j + 1);
	}

	private static int numIslands(char[][] grid) {
//		int row = grid.length;
//		int col = grid[0].length;
		int total = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					total++;
					move(grid, i, j);
				}
			}
		}

		return total;
	}

	public static void main(String[] args) {
		char[][] grid = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '0', '0', '0' } };
		System.out.println(numIslands(grid));

		grid = new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };
		System.out.println(numIslands(grid));

		grid = new char[][] { { '1' }, { '1' } };
		System.out.println(numIslands(grid));

	}

}
