package com.app.dynamicprogramming;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintSubsetsWithTargetSum {
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

	private static List<String> printAllPath(int[] nums, int target) {
		int m = nums.length;
		boolean[][] dp = new boolean[m + 1][target + 1];
		dp[0][0] = true;

		for (int i = 1; i <= m; i++) {
			for (int j = 0; j <= target; j++) {
				if (j == 0)
					dp[i][j] = true;
				else {
					dp[i][j] = dp[i - 1][j];
					if (j >= nums[i - 1]) {
						dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
					}
				}
			}
		}

		if (!dp[m][target])
			return new ArrayList<>();

		List<String> results = new ArrayList<>();
		Queue<PathNode> q = new LinkedList<>();
		q.add(new PathNode(m, target, ""));

		while (!q.isEmpty()) {
			PathNode pNode = q.poll();
			int cRow = pNode.row;
			int cCol = pNode.col;

			if (cRow == 0 && cCol == 0) {
				results.add(pNode.pathSoFar);
				continue;
			}

			boolean option1 = dp[cRow - 1][cCol];
			if (option1) {
				q.add(new PathNode(cRow - 1, cCol, pNode.pathSoFar));
			}

			if (cCol >= nums[cRow - 1]) {
				boolean option2 = dp[cRow - 1][cCol - nums[cRow - 1]];
				if (option2) {
					q.add(new PathNode(cRow - 1, cCol - nums[cRow - 1],
							nums[cRow - 1] + " " + pNode.pathSoFar));
				}
			}
		}
		return results;
	}

	public static void main(String[] args) {
		int[] nums = { 4, 2, 7, 1, 3 };
		int target = 10;
		
		List<String> results = printAllPath(nums, target);
		
		System.out.println(results);

	}

}
