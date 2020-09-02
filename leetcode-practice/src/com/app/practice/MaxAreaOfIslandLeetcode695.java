package com.app.practice;

import java.util.HashSet;
import java.util.Set;

public class MaxAreaOfIslandLeetcode695 {
	private static int count = 0;

	private static void solve(int[][] grid, int i, int j, int m, int n, Set<Point> visited) {
		if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 || visited.contains(new Point(i, j)))
			return;
		visited.add(new Point(i, j));
		count++;
		solve(grid, i - 1, j, m, n, visited);
		solve(grid, i + 1, j, m, n, visited);
		solve(grid, i, j - 1, m, n, visited);
		solve(grid, i, j + 1, m, n, visited);
	}

	private static int maxAreaOfIsland(int[][] grid) {
		Set<Point> visited = new HashSet<>();
		int m = grid.length;
		int n = grid[0].length;

		int maxCount = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					solve(grid, i, j, m, n, visited);
					maxCount = Integer.max(maxCount, count);
					count = 0;
				}
			}
		}
		return maxCount;
	}

	public static void main(String[] args) {
		int[][] grid = { 
				{ 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
		
		int maxArea = maxAreaOfIsland(grid);
		
		System.out.println(maxArea);

	}

}
