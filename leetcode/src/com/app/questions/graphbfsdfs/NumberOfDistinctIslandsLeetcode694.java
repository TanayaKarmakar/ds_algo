package com.app.questions.graphbfsdfs;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslandsLeetcode694 {
	private static void dfs(int[][] grid, int i, int j, StringBuilder sb, String str) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
			return;
		}

		sb.append(str);
		grid[i][j] = 0;
		dfs(grid, i + 1, j, sb, "D");
		dfs(grid, i - 1, j, sb, "U");
		dfs(grid, i, j + 1, sb, "R");
		dfs(grid, i, j - 1, sb, "L");
		sb.append("/");
	}

	private static int numDistinctIslands(int[][] grid) {
		if(grid.length == 0)
			return 0;
		int m = grid.length;
		int n = grid[0].length;
		Set<String> uniqueValues = new HashSet<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					StringBuilder sb = new StringBuilder();
					dfs(grid, i, j, sb, ".");
					System.out.println(sb.toString());
					uniqueValues.add(sb.toString());
				}
			}
		}

		return uniqueValues.size();
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 1 } };

		int ans = numDistinctIslands(matrix);

		System.out.println(ans);

		matrix = new int[][] { { 1, 1, 0, 1, 1 }, { 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1 }, { 1, 1, 0, 1, 1 } };
	
		ans = numDistinctIslands(matrix);

		System.out.println(ans);
	}

}
