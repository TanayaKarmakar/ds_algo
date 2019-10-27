package com.app.graph;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.stream.IntStream;

import com.app.graph.WeightedGraph.Neighbor;

public class DijkstraAlgorithm {
	private static EdgeWeightComparator comparator = new EdgeWeightComparator();

	//Lazy approach
	private static Stack<Integer> findShortestPath(WeightedGraph<Integer> wg, int startNode, int endNode) {
		int nVertices = wg.getAdjList().size();
		Integer[] distance = new Integer[nVertices];
		boolean[] visited = new boolean[nVertices];
		Integer[] previous = new Integer[nVertices];

		PriorityQueue<Neighbor<Integer>> queue = new PriorityQueue<>(comparator);
		visited[startNode] = true;
		distance[startNode] = 0;
		previous[startNode] = -1;
		queue.add(new Neighbor<Integer>(startNode, 0));

		while (!queue.isEmpty()) {
			Neighbor<Integer> neighbor = queue.poll();
			int nodeIndx = neighbor.getNode();
			if (distance[nodeIndx] != null && distance[nodeIndx] < neighbor.getWeight())
				continue;
			visited[nodeIndx] = true;
			List<Neighbor<Integer>> neighbors = wg.getNeighbors(nodeIndx);
			for (Neighbor<Integer> n : neighbors) {
				int newWeight = distance[nodeIndx] + n.getWeight();
				if (distance[n.getNode()] == null || distance[n.getNode()] > newWeight) {
					distance[n.getNode()] = newWeight;
					previous[n.getNode()] = nodeIndx;
					queue.add(new Neighbor<Integer>(n.getNode(), newWeight));
				}
			}
			//endNode condition check
		}
	
		//code to reconstruct the path
		Stack<Integer> stack = new Stack<Integer>();
		int indx = endNode;
		while(previous[indx] != -1) {
			stack.push(indx);
			indx = previous[indx];
		}
		stack.push(startNode);
		
		return stack;
	}

	// Lazy Dijkstra
	private static Integer[] findShortestDistances(WeightedGraph<Integer> wg, int startNode) {
		int nVertices = wg.getAdjList().size();

		Integer[] distance = new Integer[nVertices];
		boolean[] visited = new boolean[nVertices];

		distance[startNode] = 0;
		visited[startNode] = true;

		PriorityQueue<Neighbor<Integer>> queue = new PriorityQueue<>(comparator);
		queue.add(new Neighbor<>(startNode, 0));

		while (!queue.isEmpty()) {
			Neighbor<Integer> currentNode = queue.poll();
			int nodeIndx = currentNode.getNode();
			visited[nodeIndx] = true;
			if (distance[nodeIndx] != null && distance[nodeIndx] < currentNode.getWeight())
				continue;
			List<Neighbor<Integer>> neighbors = wg.getNeighbors(nodeIndx);
			for (Neighbor<Integer> n : neighbors) {
				int newDist = distance[nodeIndx] + n.getWeight();
				if (distance[n.getNode()] == null || distance[n.getNode()] > newDist) {
					distance[n.getNode()] = newDist;
					queue.add(new Neighbor<Integer>(n.getNode(), newDist));
				}
			}
		}

		return distance;
	}

	public static void main(String[] args) {
		WeightedGraph<Integer> wg = new WeightedGraph<Integer>();
		int nVertices = 5;
		IntStream.range(0, nVertices).forEach(item -> {
			wg.addVertex(item);
		});

		wg.addEdge(0, 1, 4);
		wg.addEdge(0, 2, 1);
		wg.addEdge(1, 3, 1);
		wg.addEdge(2, 1, 2);
		wg.addEdge(2, 3, 5);
		wg.addEdge(3, 4, 3);

		Integer[] distances = findShortestDistances(wg, 0);
		System.out.println(Arrays.toString(distances));
		
		Stack<Integer> shortestPath = findShortestPath(wg, 0, 3);
		
		while(!shortestPath.isEmpty()) {
			System.out.print(shortestPath.pop() + " -> ");
		}

	}

}
