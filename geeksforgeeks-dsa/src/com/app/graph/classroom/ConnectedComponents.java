package com.app.graph.classroom;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ConnectedComponents {
	private static void bfs(Graph g, int vertex, boolean[] visited) {
		visited[vertex] = true;

		Queue<Integer> nodeQ = new LinkedList<>();
		nodeQ.add(vertex);

		//System.out.print(vertex + " ");

		while (!nodeQ.isEmpty()) {
			int node = nodeQ.poll();

			ArrayList<Integer> edges = g.getEdges(node);
			for (Integer el : edges) {
				if (visited[el] == false) {
					visited[el] = true;
					nodeQ.add(el);
				}
			}
		}
	}

	private static int noOfConnectedComponents(Graph g) {
		int nVertices = g.getNumVertices();
		boolean[] visited = new boolean[nVertices];
		int count = 0;

		for (int i = 0; i < nVertices; i++) {
			if(visited[i] == false) {
				count++;
				bfs(g, i, visited);
			}
		}
		return count;
	}


	public static void main(String[] args) {
		int nVertices = 7;
		Graph g = new Graph(nVertices);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 3);
		g.addEdge(4, 5);
		g.addEdge(4, 6);
		g.addEdge(5, 6);
		
		System.out.println("No of connected components - " 
		+ noOfConnectedComponents(g));

	}

}
