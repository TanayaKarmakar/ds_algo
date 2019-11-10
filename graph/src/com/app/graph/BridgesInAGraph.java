package com.app.graph;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

import com.app.graph.ParameterizedGraph.Vertex;

public class BridgesInAGraph {
	private static int time = 0;

	private static void performDFS(int node, ParameterizedGraph<Integer> pg, int[] disc, int[] low, boolean[] visited,
			int[] parent) {
		visited[node] = true;
		disc[node] = low[node] = ++time;

		List<Vertex<Integer>> vertices = pg.getAdjList().get(new Vertex<>(node));
		for (Vertex<Integer> vert : vertices) {
			if (!visited[vert.getLabel()]) {
				parent[vert.getLabel()] = node;
				performDFS(vert.getLabel(), pg, disc, low, visited, parent);

				low[node] = Math.min(low[node], low[vert.getLabel()]);

				if (low[vert.getLabel()] > disc[node]) {
					System.out.println(node + " " + vert.getLabel());
				}

			} else if (parent[node] != vert.getLabel()) {
				low[node] = Math.min(low[node], disc[vert.getLabel()]);
			}
		}

//		Stack<Integer> stack = new Stack<>();
//		stack.push(node);
//
//		while (!stack.isEmpty()) {
//			int currentNode = stack.pop();
//			if (!visited[currentNode]) {
//				visited[currentNode] = true;
//				parent[currentNode] = node;
//				disc[currentNode] = low[currentNode] = ++time;
//				List<Vertex<Integer>> vertices = pg.getAdjList().get(new Vertex<>(currentNode));
//				for (Vertex<Integer> vert : vertices) {
//					stack.push(vert.getLabel());
//				}
//				low[node] = Math.min(low[node], low[currentNode]);
//				if (low[currentNode] > disc[node]) {
//					System.out.println(node + " " + currentNode);
//				}
//			} else if (parent[node] != currentNode) {
//				low[node] = Math.min(low[node], disc[currentNode]);
//			}
//		}
	}

	private static void findBridges(ParameterizedGraph<Integer> pg) {
		int nVertices = pg.getAdjList().size();
		int[] disc = new int[nVertices];
		int[] low = new int[nVertices];
		int[] parent = new int[nVertices];
		boolean[] visited = new boolean[nVertices];
		Arrays.fill(parent, -1);

		for (int i = 0; i < nVertices; i++) {
			if (!visited[i]) {
				performDFS(i, pg, disc, low, visited, parent);
			}
		}
	}

	public static void main(String[] args) {
		ParameterizedGraph<Integer> pg = new ParameterizedGraph<>();
		int nVertices = 5;
		IntStream.range(0, nVertices).forEach(item -> {
			pg.addVertex(item);
		});

		pg.addEdges(1, 0);
		pg.addEdges(0, 2);
		pg.addEdges(2, 1);
		pg.addEdges(0, 3);
		pg.addEdges(3, 4);

		time = 0;
		findBridges(pg);
	}

}
