package com.app.dynamicprogramming;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Pair {
	String pathSoFar;
	int i;
	int j;

	public Pair(String pathSoFar, int i, int j) {
		this.pathSoFar = pathSoFar;
		this.i = i;
		this.j = j;
	}
}

public class PrintAllMinCostPath {
	private static List<String> printAllMinCostPath(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		int[][] dp = new int[m][n];
		dp[m - 1][n - 1] = grid[m - 1][n - 1];

		for (int i = m - 2; i >= 0; i--) {
			dp[i][n - 1] = grid[i][n - 1] + dp[i + 1][n - 1];
		}

		for (int i = n - 2; i >= 0; i--) {
			dp[m - 1][i] = grid[m - 1][i] + grid[m - 1][i + 1];
		}

		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				dp[i][j] = grid[i][j] + Integer.min(dp[i + 1][j], dp[i][j + 1]);
			}
		}

		List<String> results = new ArrayList<>();
		Deque<Pair> queue = new LinkedList<>();
		queue.add(new Pair("", 0, 0));

		while (!queue.isEmpty()) {
			Pair rem = queue.poll();

			if (rem.i == m - 1 && rem.j == n - 1) {
				results.add(rem.pathSoFar);
				continue;
			} else if (rem.i == m - 1) {
				queue.add(new Pair(rem.pathSoFar + "H", rem.i, rem.j + 1));
			} else if (rem.j == n - 1) {
				queue.add(new Pair(rem.pathSoFar + "V", rem.i + 1, rem.j));
			} else {
				if (dp[rem.i + 1][rem.j] < dp[rem.i][rem.j + 1]) {
					queue.add(new Pair(rem.pathSoFar + "V", rem.i + 1, rem.j));
				} else if (dp[rem.i + 1][rem.j] > dp[rem.i][rem.j + 1]) {
					queue.add(new Pair(rem.pathSoFar + "H", rem.i, rem.j + 1));
				} else {
					queue.add(new Pair(rem.pathSoFar + "H", rem.i, rem.j + 1));
					queue.add(new Pair(rem.pathSoFar + "V", rem.i + 1, rem.j));
				}
			}
		}
		
		System.out.println(dp[0][0]);

		return results;
	}

	public static void main(String[] args) {
		int[][] grid = { { 2, 6, 1, 0, 3 }, { 9, 1, 1, 0, 5 }, { 0, 7, 5, 2, 0 }, { 4, 3, 0, 4, 3 },
				{ 2, 0, 1, 4, 1 } };
		
		List<String> results = printAllMinCostPath(grid);
		
		System.out.println(results);
	}

}
