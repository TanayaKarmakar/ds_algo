package com.app.graph.classroom;

import java.util.List;

public class CycleDetectionUndirectedGraph {
	private static boolean dfsRec(Graph g, int source, boolean[] visited, int parent) {
		visited[source] = true;
		List<Integer> nodes = g.getEdges(source);
		for (Integer node : nodes) {
			if (!visited[node]) {
				if (dfsRec(g, node, visited, source) == true)
					return true;
			}
			else if (node != parent)
				return true;
		}
		return false;
	}

	private static boolean hasCycle(Graph g, int source) {
		boolean[] visited = new boolean[g.getNumVertices()];
		for (int i = 0; i < g.getNumVertices(); i++) {
//			if (dfsRec(g, i, visited, -1) == true)
//				return true;
			//if(!visited[i]) {
				if(dfsRec(g, i, visited, -1))
					return true;
			//}
		}
		return false;
	}

	public static void main(String[] args) {
		int nVertices = 6;
		Graph g = new Graph(nVertices);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(4, 5);
		
		System.out.println("HasCycle - " + hasCycle(g, 0));
		
		nVertices = 4;
		g = new Graph(nVertices);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		
		System.out.println("HasCycle - " + hasCycle(g, 0));
		
		nVertices = 4;
		g = new Graph(nVertices);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(2, 3);
		
		System.out.println("HasCycle - " + hasCycle(g, 0));
	}

}
