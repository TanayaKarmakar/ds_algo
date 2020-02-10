package com.app.graph.classroom;

import java.util.List;
import java.util.Stack;

public class TopologicalSortDFS {
	private static void topologicalSortRec(DiGraph dg, int vertex, boolean[] visited, Stack<Integer> stack) {
		visited[vertex] = true;
		List<Integer> nodeList = dg.getEdges(vertex);
		for (Integer el : nodeList) {
			if (!visited[el])
				topologicalSortRec(dg, el, visited, stack);
		}
		stack.push(vertex);
	}

	private static void topologicalSort(DiGraph dg) {
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[dg.size()];

		for (int i = 0; i < dg.size(); i++) {
			if (!visited[i])
				topologicalSortRec(dg, i, visited, stack);
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int nVertices = 6;
		DiGraph dg = new DiGraph(nVertices);
		dg.addEdge(5, 0);
		dg.addEdge(5, 2);
		dg.addEdge(4, 0);
		dg.addEdge(4, 1);
		dg.addEdge(2, 3);
		dg.addEdge(1, 3);
		
		
		topologicalSort(dg);

	}

}
