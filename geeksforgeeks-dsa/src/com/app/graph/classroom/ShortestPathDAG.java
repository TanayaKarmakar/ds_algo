package com.app.graph.classroom;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPathDAG {
	private static void topologicalSortRec(WeightedDiGraph wdg, int vertex, boolean[] visited, Stack<Integer> stack) {
		visited[vertex] = true;
		List<Edge> edges = wdg.getEdges(vertex);
		for (Edge edge : edges) {
			if (!visited[edge.getNode()])
				topologicalSortRec(wdg, edge.getNode(), visited, stack);
		}
		stack.push(vertex);
	}

	private static void shortestPath(WeightedDiGraph wdg, int source) {
		boolean visited[] = new boolean[wdg.size()];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < wdg.size(); i++) {
			if (!visited[i])
				topologicalSortRec(wdg, i, visited, stack);
		}

		int[] dist = new int[wdg.size()];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[source] = 0;
		while (!stack.isEmpty()) {
			Integer node = stack.pop();
			if (dist[node] != Integer.MAX_VALUE) {
				List<Edge> edges = wdg.getEdges(node);
				for (Edge edge : edges) {
					if (dist[edge.getNode()] > dist[node] + edge.getWeight()) {
						dist[edge.getNode()] = dist[node] + edge.getWeight();
					}
				}
			}
		}

		for (Integer el : dist) {
			System.out.print(el + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int nVertices = 4;
		WeightedDiGraph wdg = new WeightedDiGraph(nVertices);
		wdg.addEdge(0, 1, 1);
		wdg.addEdge(1, 2, 3);
		wdg.addEdge(1, 3, 2);
		wdg.addEdge(2, 3, 4);

		shortestPath(wdg, 1);

	}

}
