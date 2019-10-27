package com.app.graph;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import com.app.graph.WeightedGraph.Neighbor;

public class BellmanFordAlgorithm {
	private static double[] findShortestDistances(WeightedGraph<Integer> wg, int startId) {
		int nVertices = wg.getAdjList().size();
		double[] distances = new double[nVertices];
		Arrays.fill(distances, Double.POSITIVE_INFINITY);

		distances[startId] = 0;

		Map<Integer, List<Neighbor<Integer>>> adjList = wg.getAdjList();

		for (int i = 0; i < nVertices - 1; i++) {
			for (Map.Entry<Integer, List<Neighbor<Integer>>> entry : adjList.entrySet()) {
				Integer nodeIndx = entry.getKey();
				List<Neighbor<Integer>> neighbors = entry.getValue();
				for (Neighbor<Integer> n : neighbors) {
					double newWeight = distances[nodeIndx] + n.getWeight();
					if (distances[n.getNode()] > newWeight) {
						distances[n.getNode()] = newWeight;
					}
				}
			}
		}

		for (int i = 0; i < nVertices - 1; i++) {
			for (Map.Entry<Integer, List<Neighbor<Integer>>> entry : adjList.entrySet()) {
				Integer nodeIndx = entry.getKey();
				List<Neighbor<Integer>> neighbors = entry.getValue();
				for (Neighbor<Integer> n : neighbors) {
					double newWeight = distances[nodeIndx] + n.getWeight();
					if (distances[n.getNode()] > newWeight) {
						distances[n.getNode()] = Double.NEGATIVE_INFINITY;
					}
				}
			}
		}

		return distances;
	}

	public static void main(String[] args) {
		WeightedGraph<Integer> wg = new WeightedGraph<>();
		int nVertices = 8;
		IntStream.rangeClosed(0, nVertices).forEach(item -> {
			wg.addVertex(item);
		});

		wg.addEdge(0, 1, 1);
		wg.addEdge(1, 2, 1);
		wg.addEdge(1, 5, 4);
		wg.addEdge(1, 6, 4);
		wg.addEdge(2, 4, 1);
		wg.addEdge(4, 3, -3);
		wg.addEdge(3, 2, 1);
		wg.addEdge(5, 7, 3);
		wg.addEdge(5, 6, 5);
		wg.addEdge(6, 7, 4);

		double[] distances = findShortestDistances(wg, 0);
		System.out.println(Arrays.toString(distances));

	}

}
