package com.app.graph.classroom;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathInUndirectedGraph {
	private static int[] shortestPath(Graph g, int source) {
		boolean[] visited = new boolean[g.getNumVertices()];
		int[] dist = new int[g.getNumVertices()];

		Queue<Integer> vertexQ = new LinkedList<>();
		visited[source] = true;
		dist[source] = 0;

		vertexQ.add(source);

		while (!vertexQ.isEmpty()) {
			int curr = vertexQ.poll();
			List<Integer> nodes = g.getEdges(curr);
			for (Integer node : nodes) {
				if (!visited[node]) {
					visited[node] = true;
					dist[node] = dist[curr] + 1;
					vertexQ.add(node);
				}
			}
		}
		return dist;
	}

	public static void main(String[] args) {
		int nVertices = 4;
		Graph g = new Graph(nVertices);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 3);
		
		int[] dist = shortestPath(g, 0);
		
		System.out.println(Arrays.toString(dist));
	}

}
