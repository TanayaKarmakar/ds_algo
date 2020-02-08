package com.app.graph.classroom;

import java.util.List;

public class DFSSimpleGraph {
	private static void dfsRec(Graph g, boolean[] visited, int vertex) {
		visited[vertex] = true;
		System.out.print(vertex + " ");
		List<Integer> nodes = g.getEdges(vertex);
		for (Integer node : nodes) {
			if (!visited[node]) {
				dfsRec(g, visited, node);
			}
		}
	}

	private static void dfs(Graph g, int source) {
		boolean[] visited = new boolean[g.getNumVertices()];
		dfsRec(g, visited, source);
	}

	public static void main(String[] args) {
		int nVertices = 5;
		Graph g = new Graph(nVertices);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(2, 3);
		g.addEdge(2, 3);
		
		dfs(g, 0);

	}
}
