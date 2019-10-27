package com.app.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import com.app.graph.WeightedGraph.Neighbor;

public class ShortestPathForDAG {
	private static void topsortUtil(Integer node, WeightedGraph<Integer> wg, Set<Integer> visited,
			Stack<Integer> stack) {
		visited.add(node);

		List<Neighbor<Integer>> neighbors = wg.getNeighbors(node);
		for (Neighbor<Integer> neighbor : neighbors) {
			if (!visited.contains(neighbor.getNode())) {
				topsortUtil(neighbor.getNode(), wg, visited, stack);
			}
		}
		stack.push(node);
	}

	private static Stack<Integer> topSort(WeightedGraph<Integer> wg) {
		Set<Integer> visited = new HashSet<>();
		Stack<Integer> stack = new Stack<>();
		Map<Integer, List<Neighbor<Integer>>> adjList = wg.getAdjList();

		for (Map.Entry<Integer, List<Neighbor<Integer>>> entry : adjList.entrySet()) {
			if (!visited.contains(entry.getKey())) {
				topsortUtil(entry.getKey(), wg, visited, stack);
			}
		}

		return stack;
	}

	private static Integer[] getShortestPath(Stack<Integer> stack, WeightedGraph<Integer> wg, Integer startId) {
		int nVertices = wg.getAdjList().size();
		Integer[] distance = new Integer[nVertices + 1];
		distance[startId] = 0;
		while (!stack.isEmpty()) {
			Integer nodeIndx = stack.pop();
			if (distance[nodeIndx] != null) {
				List<Neighbor<Integer>> neighbors = wg.getAdjList().get(nodeIndx);
				if (neighbors != null && !neighbors.isEmpty()) {
					for (Neighbor<Integer> n : neighbors) {
						int updatedWeight = distance[nodeIndx] + n.getWeight();
						if (distance[n.getNode()] == null) {
							distance[n.getNode()] = updatedWeight;
						} else {
							distance[n.getNode()] = Integer.min(distance[n.getNode()], updatedWeight);
						}
					}
				}
			}
		}

		return distance;
	}

	public static void main(String[] args) {
		WeightedGraph<Integer> wg = new WeightedGraph<>();
		int nVertices = 8;
		for (int i = 1; i <= nVertices; i++) {
			wg.addVertex(i);
		}

		wg.addEdge(1, 2, 3);
		wg.addEdge(1, 3, 6);
		wg.addEdge(2, 3, 4);
		wg.addEdge(2, 4, 4);
		wg.addEdge(2, 5, 11);
		wg.addEdge(3, 4, 8);
		wg.addEdge(3, 7, 11);
		wg.addEdge(4, 5, -4);
		wg.addEdge(4, 6, 5);
		wg.addEdge(4, 7, 2);
		wg.addEdge(5, 8, 9);
		wg.addEdge(6, 8, 1);
		wg.addEdge(7, 8, 2);

		Stack<Integer> stack = topSort(wg);
		System.out.println(stack);

		Integer[] distance = getShortestPath(stack, wg, 2);
		System.out.println(Arrays.toString(distance));

	}

}
