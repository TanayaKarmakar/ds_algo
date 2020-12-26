package com.app.dynamicprogramming;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintAllPathForMinimumJumps {
	static class Pair {
		int indx;
		int stepSize;
		int numJumps;
		String pathSoFar;

		public Pair(int indx, int stepSize, int numJumps, String pathSoFar) {
			this.indx = indx;
			this.stepSize = stepSize;
			this.numJumps = numJumps;
			this.pathSoFar = pathSoFar;
		}
	}

	private static List<String> getAllPaths(int[] nums) {
		int n = nums.length;
		Integer[] dp = new Integer[n];

		dp[n - 1] = 0;

		for (int i = n - 2; i >= 0; i--) {
			int steps = nums[i];
			int min = Integer.MAX_VALUE;
			for (int j = 1; i + j < n && j <= steps; j++) {
				if (dp[i + j] != null && dp[i + j] < min) {
					min = dp[i + j];
				}
			}
			if (min != Integer.MAX_VALUE) {
				dp[i] = min + 1;
			}
		}

		List<String> results = new ArrayList<>();
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(0, nums[0], dp[0], 0 + ""));

		while (!queue.isEmpty()) {
			Pair rem = queue.poll();
			if (rem.numJumps == 0) {
				results.add(rem.pathSoFar + " .");
				continue;
			}

			for (int j = 1; j <= rem.stepSize && rem.indx + j < n; j++) {
				int currentIndx = rem.indx + j;
				if (dp[currentIndx] != null && dp[currentIndx] == rem.numJumps - 1) {
					queue.add(new Pair(currentIndx, nums[currentIndx], dp[currentIndx],
							rem.pathSoFar + "->" + currentIndx));
				}
			}
		}

		return results;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 3, 0, 2, 1, 2, 4, 2, 0, 0 };
		
		List<String> results = getAllPaths(nums);
		
		System.out.println(results);
	}
}
