package com.app.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

import com.app.graph.ParameterizedGraph.Vertex;

public class ShortestPathUnweightedGraph {
	private static int[] getDistances(int src, ParameterizedGraph<Integer> graph) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(src);
		
		int[] distances = new int[graph.length()];
		
		Arrays.fill(distances, -1);
		
		distances[src] = 0;
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			List<Vertex<Integer>> neighbors = graph.getAdjVertices(node);
			for(Vertex<Integer> neighbor: neighbors) {
				int neighborIndex = neighbor.getLabel();
				if(distances[neighborIndex] == -1) {
					queue.add(neighborIndex);
					distances[neighborIndex] = distances[node] + 1;
				}
			}
		}
		
		return distances;
	}
	
	private static int getShortestDistanceBetween(int src, int dest, ParameterizedGraph<Integer> graph) {
		int[] distances = getDistances(src, graph);
//		System.out.println("Distances - ");
//		System.out.println(Arrays.toString(distances));
		return distances[dest];
	}

	public static void main(String[] args) {
		ParameterizedGraph<Integer> graph = new ParameterizedGraph<Integer>();
		int nVertices = 9;
		IntStream.range(0, nVertices).forEach(item -> {
			graph.addVertex(item);
		});
		
		graph.addEdges(1, 2);
		graph.addEdges(1, 3);
		graph.addEdges(3, 0);
		graph.addEdges(3, 4);
		graph.addEdges(3, 6);
		graph.addEdges(5, 0);
		graph.addEdges(5, 4);
		graph.addEdges(7, 8);
		
		graph.displayGraph();
		
		System.out.println(getShortestDistanceBetween(1,6,graph));

	}

}
