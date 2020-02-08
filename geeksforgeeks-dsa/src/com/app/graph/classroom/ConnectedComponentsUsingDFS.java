package com.app.graph.classroom;

import java.util.List;

public class ConnectedComponentsUsingDFS {
	private static void dfsRec(Graph g, boolean[] visited, int vertex) {
		visited[vertex] = true;
		// System.out.print(vertex + " ");

		List<Integer> nodes = g.getEdges(vertex);
		for (Integer node : nodes) {
			if (!visited[node]) {
				dfsRec(g, visited, node);
			}
		}
	}

	private static int dfs(Graph g) {
		int count = 0;
		boolean[] visited = new boolean[g.getNumVertices()];

		for (int i = 0; i < g.getNumVertices(); i++) {
			if (!visited[i]) {
				++count;
				dfsRec(g, visited, i);
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int nVertices = 6;
		Graph g = new Graph(nVertices);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(3, 4);

		int count = dfs(g);

		System.out.println("Number of connected components in this grpah is " + count);

	}

}
