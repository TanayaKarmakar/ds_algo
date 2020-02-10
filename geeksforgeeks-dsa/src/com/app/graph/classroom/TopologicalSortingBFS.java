package com.app.graph.classroom;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Kahn's algorithm
public class TopologicalSortingBFS {
	private static int[] buildIndegreeArray(DiGraph dg) {
		List<List<Integer>> adjList = dg.getAdjList();
		int nVertices = dg.size();

		int[] indegree = new int[nVertices];
		for (int i = 0; i < nVertices; i++) {
			List<Integer> nodeList = adjList.get(i);
			for (Integer node : nodeList) {
				indegree[node]++;
			}
		}

		return indegree;
	}

	private static void topologicalSorting(DiGraph dg) {
		int[] indegree = buildIndegreeArray(dg);

		Queue<Integer> nodeQ = new LinkedList<>();
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0) {
				nodeQ.add(i);
			}
		}
		
		while(!nodeQ.isEmpty()) {
			Integer node = nodeQ.poll();
			System.out.print(node + " ");
			List<Integer> nodeList = dg.getEdges(node);
			for(Integer el: nodeList) {
				indegree[el]--;
				if(indegree[el] == 0) {
					nodeQ.add(el);
				}
			}
		}
		
		System.out.println();
	}

	public static void main(String[] args) {
		DiGraph dg = new DiGraph(6);
		dg.addEdge(0, 1);
		dg.addEdge(0, 2);
		dg.addEdge(1, 3);
		dg.addEdge(2, 3);
		dg.addEdge(3, 4);
		dg.addEdge(3, 5);
		
		topologicalSorting(dg);
		
		dg = new DiGraph(5);
		dg.addEdge(0, 2);
		dg.addEdge(0, 3);
		dg.addEdge(1, 3);
		dg.addEdge(1, 4);
		
		topologicalSorting(dg);
	}

}
