package com.app.graph.classroom;

import java.util.List;

public class CycleDetectionDirectedGraph {
	private static boolean dfsRec(DiGraph dg, int vertex, boolean[] visited, boolean[] recSt) {
		visited[vertex] = true;
		recSt[vertex] = true;

		List<Integer> nodeList = dg.getEdges(vertex);
		for (Integer node : nodeList) {
			if (!visited[node] && dfsRec(dg, node, visited, recSt))
				return true;
			else if (recSt[node])
				return true;
		}
		recSt[vertex] = false;
		return false;
	}

	private static boolean hasCycle(DiGraph g) {
		boolean[] visited = new boolean[g.size()];
		boolean[] recSt = new boolean[g.size()];

		int nVertices = g.size();
		for (int i = 0; i < nVertices; i++) {
			if (!visited[i])
				if (dfsRec(g, i, visited, recSt))
					return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int nVertices = 6;
		DiGraph dg = new DiGraph(nVertices);
		dg.addEdge(0, 1);
		dg.addEdge(2, 1);
		dg.addEdge(2, 3);
		dg.addEdge(3, 4);
		dg.addEdge(4, 5);
		dg.addEdge(5, 3);

		System.out.println(hasCycle(dg));

		dg = new DiGraph(nVertices);
		dg.addEdge(0, 1);
		dg.addEdge(1, 2);
		dg.addEdge(2, 3);
		dg.addEdge(3, 4);
		dg.addEdge(4, 5);

		System.out.println(hasCycle(dg));
	}

}
