package com.app.questions;

import java.util.HashSet;
import java.util.Set;

public class FriendCirclesLeetcode547 {
	private static void dfs(int[][] M, int node, Set<Integer> visited, int n) {
		visited.add(node);
		for (int j = 0; j < n; j++) {
			if (node != j && M[node][j] == 1 && !visited.contains(j)) {
				visited.add(j);
				dfs(M, j, visited, n);
			}
		}
	}

	private static int friendCircleNum(int[][] M) {
		int count = 0;
		int n = M.length;
		Set<Integer> visited = new HashSet<>();
		for (int i = 0; i < n; i++) {
			if (!visited.contains(i)) {
				dfs(M, i, visited, n);
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[][] M = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };

		int count = friendCircleNum(M);

		System.out.println(count);

		M = new int[][] { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } };

		count = friendCircleNum(M);

		System.out.println(count);

	}

}
