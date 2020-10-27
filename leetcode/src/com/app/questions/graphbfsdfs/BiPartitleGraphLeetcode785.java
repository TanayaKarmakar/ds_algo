package com.app.questions.graphbfsdfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BiPartitleGraphLeetcode785 {
	private static boolean isBipartite(int start, int[][] graph, int[] colors) {
		Queue<Integer> q = new LinkedList<>();

		q.add(start);
		colors[start] = 1;

		while (!q.isEmpty()) {
			int node = q.poll();
			int currentColor = colors[node];

			int[] neighbors = graph[node];

			for (int nei : neighbors) {
				if (colors[nei] == -1) {
					q.add(nei);
					colors[nei] = 1 - currentColor;
				} else if (colors[nei] == currentColor)
					return false;
			}
		}

		return true;
	}

	private static boolean isBipartite(int[][] graph) {
		int n = graph.length;
		int[] colors = new int[n];

		Arrays.fill(colors, -1);

		for (int i = 0; i < n; i++) {
			if (colors[i] == -1) {
				if (!isBipartite(i, graph, colors))
					return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		int[][] graph = { { 1, 2, 3 }, { 0, 2 }, { 0, 1, 3 }, { 0, 2 } };

		System.out.println(isBipartite(graph));
	}

}
