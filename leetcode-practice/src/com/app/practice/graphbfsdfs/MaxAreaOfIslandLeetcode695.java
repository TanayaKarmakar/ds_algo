package com.app.practice.graphbfsdfs;

public class MaxAreaOfIslandLeetcode695 {
	private static int count = 0;

	private static void dfs(int[][] grid, int i, int j, boolean[][] visited) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visited[i][j] == true)
			return;
		count++;
		visited[i][j] = true;
		dfs(grid, i + 1, j, visited);
		dfs(grid, i - 1, j, visited);
		dfs(grid, i, j + 1, visited);
		dfs(grid, i, j - 1, visited);
	}

	private static int maxAreaOfIsland(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		int maxCount = 0;
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1 && !visited[i][j]) {
					count = 0;
					dfs(grid, i, j, visited);
					maxCount = Integer.max(maxCount, count);
				}
			}
		}
		return maxCount;
	}

	public static void main(String[] args) {
		int[][] grid = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
		
		int maxCount = maxAreaOfIsland(grid);
		
		System.out.println(maxCount);

	}

}
