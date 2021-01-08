package com.app.dynamicprogramming;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintAllPathsFor01Knapsack {
	static class PathNode {
		int row;
		int col;
		String pathSoFar;

		public PathNode(int row, int col, String pathSoFar) {
			this.row = row;
			this.col = col;
			this.pathSoFar = pathSoFar;
		}
	}

	private static List<String> printAllPaths(int[] weights, int[] profits, int maxWt) {
		int n = weights.length;
		int[][] dp = new int[n + 1][maxWt + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= maxWt; j++) {
				int option1 = dp[i - 1][j];
				int option2 = 0;
				if (j >= weights[i - 1]) {
					option2 = profits[i - 1] + dp[i - 1][j - weights[i - 1]];
				}
				dp[i][j] = Integer.max(option1, option2);
			}
		}

		System.out.println("Max Weight - " + dp[n][maxWt]);

		Queue<PathNode> q = new LinkedList<>();
		q.add(new PathNode(n, maxWt, ""));

		List<String> results = new ArrayList<>();

		while (!q.isEmpty()) {
			PathNode pNode = q.poll();
			int cRow = pNode.row;
			int cCol = pNode.col;

			if (cRow == 0 || cCol == 0) {
				results.add(pNode.pathSoFar);
				continue;
			}

			int excVal = dp[cRow - 1][cCol];
			
			if (dp[cRow][cCol] == excVal) {
				q.add(new PathNode(cRow - 1, cCol, pNode.pathSoFar));
			} 
			if(cCol >= weights[cRow - 1]) {
				int incVal = dp[cRow - 1][cCol - weights[cRow - 1]] + profits[cRow - 1];
				if(dp[cRow][cCol] == incVal) {
					q.add(new PathNode(cRow - 1, cCol - weights[cRow - 1], weights[cRow - 1] + " " + pNode.pathSoFar));
				}
			}	
		}

		return results;
	}

	public static void main(String[] args) {
		int[] weights = { 2, 5, 1, 3, 4 };
		int[] profits = { 15, 14, 10, 45, 30 };
		int maxWt = 7;

		List<String> results = printAllPaths(weights, profits, maxWt);

		System.out.println(results);

	}

}
