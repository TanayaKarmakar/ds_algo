package com.app.practice;

public class FriendCirclesLeetcode547 {
	private static void dfs(int[][] M, boolean[] visited, int v, int n) {
		visited[v] = true;
		for (int i = 0; i < n; i++) {
			if (M[v][i] == 1 && !visited[i]) {
				dfs(M, visited, i, n);
			}
		}
	}

	private static int findCircleNum(int[][] M) {
		int count = 0;
		int n = M.length;
		boolean[] visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				dfs(M, visited, i, n);
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		int count = findCircleNum(mat);

		System.out.println(count);

		mat = new int[][] { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } };
		count = findCircleNum(mat);

		System.out.println(count);
	}

}
