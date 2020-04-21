package com.app.questions.practice;

public class NumberOfIslandsLeetCode200 {
	private static void move(char[][] grid, int i, int j, int row, int col) {
		if(i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == '0')
			return;
		grid[i][j] = '0';
		move(grid, i - 1, j, row, col);
		move(grid, i + 1, j, row, col);
		move(grid, i, j - 1, row, col);
		move(grid, i, j + 1, row, col);
	}
	
	private static int getTotalIslands(char[][] grid) {
		int total = 0;
		int row = grid.length;
		int col = grid[0].length;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == '1') {
					total++;
					move(grid, i, j, row, col);
				}
			}
		}
		return total;
	}

	public static void main(String[] args) {
		char[][] grid = {
				{'1','1','1','1','0'},
				{'1','1','0','1','0'},
				{'1','1','0','0','0'},
				{'0','0','0','0','0'}
		};

		int numIslands = getTotalIslands(grid);
		
		System.out.println(numIslands);
	}

}
