package com.app.practice;

public class FindTheCelebrityLeetcode277 {
	private static int[][] graph;

	private static void initGraph(int[][] g) {
		graph = g;
	}

	private static boolean knows(int a, int b) {
		return graph[a][b] == 1;
	}

	private static int findTheCelebrity(int n) {
		int[] inDeg = new int[n];
		int[] outDeg = new int[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j) {
					if (knows(i, j)) {
						outDeg[i]++;
						inDeg[j]++;
					}
				}
			}
		}

		for (int i = 0; i < n; i++) {
			if (outDeg[i] == 0 && inDeg[i] == n - 1)
				return i;
		}
		return -1;

	}

	public static void main(String[] args) {
		int[][] graph = { { 1, 1, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
		initGraph(graph);

		System.out.println(findTheCelebrity(3));

		graph = new int[][] { { 1, 0, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };

		initGraph(graph);

		System.out.println(findTheCelebrity(3));
	}

}
