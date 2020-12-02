package com.app.practice.graphbfsdfs;

public class MaxAreaOfIslandLeetcode695 {
	private static int maxCount = 0;
	private static int currentCount = 0;

	private static void dfs(int[][] grid, boolean[][] visited, int i, int j) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visited[i][j])
			return;
		currentCount++;
		visited[i][j] = true;
		dfs(grid, visited, i + 1, j);
		dfs(grid, visited, i - 1, j);
		dfs(grid, visited, i, j - 1);
		dfs(grid, visited, i, j + 1);
	}

	private static int maxAreaOfIsland(int[][] grid) {
		if (grid.length == 0)
			return 0;
		int m = grid.length;
		int n = grid[0].length;

		boolean[][] visited = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1 && !visited[i][j]) {
					currentCount = 0;
					dfs(grid, visited, i, j);
					maxCount = Integer.max(currentCount, maxCount);
				}
			}
		}

		return maxCount;
	}

	public static void main(String[] args) {
		int[][] grid = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };

		int maxArea = maxAreaOfIsland(grid);

		System.out.println(maxArea);
	}

}
