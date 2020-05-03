package com.app.questions.read;

import java.util.HashSet;
import java.util.Set;

public class MaxAreaOfIslandLeetcode695 {
	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
	}

	private static int count = 0;

	private static void solve(int[][] grid, int i, int j, int m, int n, Set<Point> visited) {
		if (i < 0 || i >= m || j < 0 || j >= n)
			return;
		if (grid[i][j] == 0 || visited.contains(new Point(i, j)))
			return;
		count++;
		visited.add(new Point(i, j));
		solve(grid, i - 1, j, m, n, visited);
		solve(grid, i + 1, j, m, n, visited);
		solve(grid, i, j - 1, m, n, visited);
		solve(grid, i, j + 1, m, n, visited);
	}

	private static int maxAreaOfIsland(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		Set<Point> visited = new HashSet<>();

		int maxCount = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					count = 0;
					solve(grid, i, j, m, n, visited);
					maxCount = Integer.max(count, maxCount);
				}
			}
		}
		return maxCount;
	}

	public static void main(String[] args) {
		int[][] mat = { 
				{ 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
		
		int maxArea = maxAreaOfIsland(mat);
		
		System.out.println(maxArea);

	}

}
