package com.app.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.app.graph.WeightedNonDirectedGraph.Edge;
import com.app.graph.WeightedNonDirectedGraph.Vertex;

class EdgeComparator implements Comparator<Edge<?>> {

	@Override
	public int compare(Edge<?> edge1, Edge<?> edge2) {
		if (edge1.getWeight() == edge2.getWeight())
			return 0;
		else if (edge1.getWeight() < edge2.getWeight())
			return -1;
		else
			return 1;
	}
}

public class KruskalsMinimumSpanningTree {
	private static List<Edge<Integer>> findMST(WeightedNonDirectedGraph<Integer> wng) {
		List<Edge<Integer>> edges = wng.getAllEdges();
		Collections.sort(edges, new EdgeComparator());

		List<Vertex<Integer>> vertices = wng.getAllVertices();

		DisjointSet ds = new DisjointSet(vertices.size());

		for (Vertex<Integer> vert : vertices) {
			ds.makeSet(vert.getLabel());
		}

		List<Edge<Integer>> result = new ArrayList<>();
		for (Edge<Integer> edge : edges) {
			int from = edge.getFrom();
			int to = edge.getTo();
			if (!ds.connected(from, to)) {
				result.add(edge);
				ds.union(from, to);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		WeightedNonDirectedGraph<Integer> wng = new WeightedNonDirectedGraph<Integer>();
		wng.addEdge(0, 1, 3);
		wng.addEdge(0, 3, 1);
		wng.addEdge(1, 2, 1);
		wng.addEdge(1, 3, 3);
		wng.addEdge(2, 3, 1);
		wng.addEdge(2, 4, 5);
		wng.addEdge(2, 5, 4);
		wng.addEdge(3, 4, 6);
		wng.addEdge(4, 5, 2);

		List<Edge<Integer>> mstList = findMST(wng);
		for (Edge<Integer> edge : mstList) {
			System.out.println(edge);
		}

	}
}
