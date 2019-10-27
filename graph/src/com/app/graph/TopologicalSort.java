package com.app.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.stream.IntStream;

import com.app.graph.DiGraph.Vertex;

public class TopologicalSort {
	private static void topologicalSortDFS(DiGraph dg) {
		Set<Integer> visited = new HashSet<>();
		Stack<Integer> stack = new Stack<>();
		Map<Vertex, List<Vertex>> adjList = dg.getAdjList();
		for(Map.Entry<Vertex, List<Vertex>> entry: adjList.entrySet()) {
			if(!visited.contains(entry.getKey().getLabel())) {
				topSortUtil(adjList, entry.getKey(), visited, stack);
			}
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + "\t");
		}
		System.out.println();
	}
	
	private static void topSortUtil(Map<Vertex, List<Vertex>> adjList, Vertex vert, Set<Integer> visited, Stack<Integer> stack) {
		visited.add(vert.getLabel());
		List<Vertex> neighbors = adjList.get(vert);
		for(Vertex vertex: neighbors) {
			if(!visited.contains(vertex.getLabel())) {
				topSortUtil(adjList, vertex, visited, stack);
			}
		}
		stack.push(vert.getLabel());
	}
	
	
	
	// Kahn's Algorithm
	private static void topologicalSortBFS(DiGraph dg) {
		Queue<Integer> zeroInDegQ = new LinkedList<>();
		int nVisitedNodes = 0;
		int[] inDeg = dg.getInDegree();
		for (int i = 0; i < inDeg.length; i++) {
			if (inDeg[i] == 0) {
				zeroInDegQ.add(i);
			}
		}

		while (!zeroInDegQ.isEmpty()) {
			int v = zeroInDegQ.poll();
			nVisitedNodes++;
			System.out.print(v + "\t");
			List<Vertex> neighbors = dg.getAdjVertices(v);
			for (Vertex vert : neighbors) {
				if (--inDeg[vert.getLabel()] == 0) {
					zeroInDegQ.add(vert.getLabel());
				}
			}
		}

		if (nVisitedNodes != inDeg.length) {
			System.out.println("Topological Sort not possible for this graph");
		}
	}

	public static void main(String[] args) {
		DiGraph dg = new DiGraph(6);
		IntStream.range(0, 6).forEach(item -> {
			dg.addVertex(item);
		});

		dg.addEdge(2, 0);
		dg.addEdge(2, 3);
		dg.addEdge(0, 1);
		dg.addEdge(0, 3);
		dg.addEdge(0, 5);
		dg.addEdge(3, 1);
		dg.addEdge(3, 4);
		dg.addEdge(5, 4);

		dg.displayGraph();
		
		System.out.println("Kahn's algo");
		topologicalSortBFS(dg);
		
		System.out.println("\nTopological Sort DFS");
		topologicalSortDFS(dg);
	}

}
