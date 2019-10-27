package com.app.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedGraph<T> {
	private Map<T, List<Neighbor<T>>> adjList;

	public WeightedGraph() {
		this.adjList = new HashMap<>();
	}

	public void addVertex(T node) {
		adjList.putIfAbsent(node, new ArrayList<>());
	}

	public void addEdge(T src, T dest, int weight) {
		Neighbor<T> neighbor = new Neighbor<T>(dest, weight);
		adjList.get(src).add(neighbor);
	}

	public Map<T, List<Neighbor<T>>> getAdjList() {
		return this.adjList;
	}

	public List<Neighbor<T>> getNeighbors(T node) {
		return this.adjList.get(node);
	}

	public void displayGraph() {
		for (Map.Entry<T, List<Neighbor<T>>> entry : adjList.entrySet()) {
			System.out.print(entry.getKey() + " ");
			List<Neighbor<T>> neighbors = entry.getValue();
			for (Neighbor<T> neighbor : neighbors) {
				System.out.print(" -> " + "(" + neighbor.getNode() + ", " + neighbor.getWeight() + ")");
			}
		}
	}

	static class Neighbor<T>  {
		private T node;
		private int weight;
	
		public Neighbor(T node, int weight) {
			this.node = node;
			this.weight = weight;
		}

		public T getNode() {
			return node;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}
	}
}
