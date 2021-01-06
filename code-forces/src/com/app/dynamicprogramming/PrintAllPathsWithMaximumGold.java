package com.app.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintAllPathsWithMaximumGold {
	static class PathNode {
		int val;
		int row;
		int col;
		String pathSoFar;

		public PathNode(int val, int row, int col, String pathSoFar) {
			this.val = val;
			this.row = row;
			this.col = col;
			this.pathSoFar = pathSoFar;
		}
	}

	private static List<String> printAllPaths(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		int[][] dp = new int[m][n];

	
		for (int i = 0; i < m; i++) {
			dp[i][n - 1] = grid[i][n - 1];
		}

		for (int i = 0; i < m; i++) {
			for (int j = n - 1; j >= 0; j--) {

				int option1 = ((i - 1) >= 0 && (j + 1) < n) ? dp[i - 1][j + 1] : 0;
				int option2 = (j + 1) < n ? dp[i][j + 1] : 0;
				int option3 = ((i + 1) < m && (j + 1) < n) ? dp[i + 1][j + 1] : 0;
				dp[i][j] = grid[i][j] + Integer.max(option1, Integer.max(option2, option3));

			}
		}

		int max = 0;
		for (int i = 0; i < m; i++) {
			max = Integer.max(max, dp[i][0]);
		}

		System.out.println("Max Gold - " + max);
		System.out.println("DP - " + Arrays.deepToString(dp));

		Queue<PathNode> q = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			if (dp[i][0] == max) {
				q.add(new PathNode(grid[i][0], i, 0, grid[i][0] + ""));
			}
		}

		List<String> results = new ArrayList<>();
		while (!q.isEmpty()) {
			PathNode pNode = q.poll();

			int cRow = pNode.row;
			int cCol = pNode.col;

			if (cCol == n - 1) {
				results.add(pNode.pathSoFar);
				continue;
			}

			int option1 = ((cRow - 1) >= 0 && (cCol + 1) < n) ? dp[cRow - 1][cCol + 1] : 0;
			int option2 = (cCol + 1) < n ? dp[cRow][cCol + 1] : 0;
			int option3 = ((cRow + 1) < m && (cCol + 1) < n) ? dp[cRow + 1][cCol + 1] : 0;

			int cMax = Integer.max(option1, Integer.max(option2, option3));

			if (option1 == cMax) {
				q.add(new PathNode(grid[cRow - 1][cCol + 1], cRow - 1, cCol + 1,
						pNode.pathSoFar + "->" + grid[cRow - 1][cCol + 1]));
			}

			if (option2 == cMax) {
				q.add(new PathNode(grid[cRow][cCol + 1], cRow, cCol + 1,
						pNode.pathSoFar + "->" + grid[cRow][cCol + 1]));
			}

			if (option3 == cMax) {
				q.add(new PathNode(grid[cRow + 1][cCol + 1], cRow + 1, cCol + 1,
						pNode.pathSoFar + "->" + grid[cRow + 1][cCol + 1]));
			}
		}
		return results;
	}

	public static void main(String[] args) {
		int[][] grid = { { 3, 2, 3, 1 }, { 2, 4, 6, 0 }, { 5, 0, 1, 3 }, { 9, 1, 5, 1 } };

		List<String> results = printAllPaths(grid);

		System.out.println(results);

	}

}
