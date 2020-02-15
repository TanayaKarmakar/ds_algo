package com.app.graph.practice;

import java.util.List;

import com.app.graph.classroom.DiGraph;

public class DetectCycleDirectedGraph {
	private static boolean dfsRec(List<List<Integer>> adjList, int vertex, boolean[] visited,
			boolean[] recSt) {
		visited[vertex] = true;
		recSt[vertex] = true;
		List<Integer> nodeList = adjList.get(vertex);
		for (Integer node : nodeList) {
			if (!visited[node]) {
				if (dfsRec(adjList, node, visited, recSt))
					return true;
			} else if (recSt[node] == true)
				return true;
		}

		recSt[vertex] = false;
		return false;
	}

	private static boolean isCycle(List<List<Integer>> adjList, int v) {
		boolean[] visited = new boolean[v];
		boolean[] recSt = new boolean[v];
		for (int i = 0; i < v; i++) {
			if (!visited[i]) {
				if (dfsRec(adjList, i, visited, recSt))
					return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		DiGraph dg = new DiGraph(5);
		dg.addEdge(0, 1);
		dg.addEdge(1, 2);
		dg.addEdge(2, 3);
		dg.addEdge(3, 4);
		dg.addEdge(4, 2);
		
		System.out.println(isCycle(dg.getAdjList(), 5));
		
		dg = new DiGraph(5);
		dg.addEdge(0, 1);
		dg.addEdge(1, 2);
		dg.addEdge(2, 3);
		dg.addEdge(3, 4);
		
		System.out.println(isCycle(dg.getAdjList(), 5));
	}

}
