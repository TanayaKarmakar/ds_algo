package com.app.graph.classroom;

import java.util.List;

//when no source is given and the graph might be disconnected
public class DFSDisconnectedGraph {
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

	private static void dfs(Graph g) {
		boolean[] visited = new boolean[g.getNumVertices()];

		for (int i = 0; i < g.getNumVertices(); i++) {
			if (!visited[i])
				dfsRec(g, visited, i);
		}
	}

	public static void main(String[] args) {
		int nVertices = 5;
		Graph g = new Graph(nVertices);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(3, 4);
		
		dfs(g);
	}

}
