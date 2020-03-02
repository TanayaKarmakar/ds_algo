package com.app.backtracking.classroom;

import java.util.Arrays;

public class HamiltonianCycle {
	private static boolean isSafe(int[][] graph, int[] path, int pos, int v) {
		if (graph[path[pos - 1]][v] == 0)
			return false;

		for (int i = 0; i < pos; i++) {
			if (path[i] == v)
				return false;
		}

		return true;
	}

	private static boolean hamCycleUtil(int[][] graph, int[] path, int pos) {
		if (pos == graph.length) {
			if (graph[path[pos - 1]][path[0]] == 1)
				return true;
			else
				return false;
		}
		for (int v = 1; v < graph.length; v++) {
			if (isSafe(graph, path, pos, v)) {
				path[pos] = v;

				if (hamCycleUtil(graph, path, pos + 1))
					return true;
				path[pos] = -1;
			}
		}

		return false;
	}

	private static boolean hamCycle(int[][] graph, int v) {
		int[] path = new int[v];
		Arrays.fill(path, -1);
		path[0] = 0;

		if (!hamCycleUtil(graph, path, 1)) {
			System.out.println("Solution does not exist");
			return false;
		}
		// print solution
		printSolution(path);
		return true;
	}

	private static void printSolution(int[] path) {
		for (int i = 0; i < path.length; i++) {
			System.out.print(path[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[][] graph = { { 0, 1, 0, 1, 0 }, { 1, 0, 1, 1, 1 }, { 0, 1, 0, 0, 1 }, { 1, 1, 0, 0, 1 },
				{ 0, 1, 1, 1, 0 } };

		hamCycle(graph, graph.length);

		graph = new int[][] { { 0, 1, 0, 1, 0 }, { 1, 0, 1, 1, 1 }, { 0, 1, 0, 0, 1 }, { 1, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 0 } };
				
		hamCycle(graph, graph.length);
	}

}
