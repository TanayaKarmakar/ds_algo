package com.app.graph.practice;

import java.util.List;
import java.util.Stack;

public class TopologicalSort {
	private static void dfsRec(List<List<Integer>> adjList, int vertex, boolean[] visited, Stack<Integer> stack) {
		visited[vertex] = true;
		List<Integer> nodeList = adjList.get(vertex);
		for (Integer node : nodeList) {
			if (!visited[node]) {
				dfsRec(adjList, node, visited, stack);
			}
		}
		stack.push(vertex);
	}

	private static int[] topoSort(List<List<Integer>> adjList, int v) {
		int[] result = new int[v];
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[v];
		for (int i = 0; i < v; i++) {
			if (!visited[i]) {
				dfsRec(adjList, i, visited, stack);
			}
		}

		int i = 0;
		while (!stack.isEmpty()) {
			result[i++] = stack.pop();
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
