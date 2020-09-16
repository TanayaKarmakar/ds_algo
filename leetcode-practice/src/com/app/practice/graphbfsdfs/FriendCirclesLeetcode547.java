package com.app.practice.graphbfsdfs;

public class FriendCirclesLeetcode547 {
	private static void dfs(int[][] M, boolean[] visited, int v, int n) {
		visited[v] = true;
		for(int i = 0; i < n; i++) {
			if(M[v][i] == 1 && !visited[i])
				dfs(M, visited, i, n);
		}
	}

	private static int findCircleNum(int[][] M) {
		int n = M.length;
		boolean[] visited = new boolean[n];

		int count = 0;
		for (int i = 0; i < n; i++) {
			if(!visited[i]) {
				dfs(M, visited, i, n);
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[][] M = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		int count = findCircleNum(M);
		System.out.println(count);

	}

}
