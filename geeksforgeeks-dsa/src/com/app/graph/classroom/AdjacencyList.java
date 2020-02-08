package com.app.graph.classroom;

import java.util.ArrayList;

public class AdjacencyList {
	private static ArrayList<ArrayList<Integer>> createGraph(int nVertices) {
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(nVertices);
		for (int i = 0; i < nVertices; i++) {
			adjList.add(new ArrayList<>());
		}
		return adjList;
	}

	private static void addEdge(ArrayList<ArrayList<Integer>> adjList, int u, int v) {
		adjList.get(u).add(v);
		adjList.get(v).add(u);
	}

	private static void printGraph(ArrayList<ArrayList<Integer>> adjList) {
		for (int i = 0; i < adjList.size(); i++) {
			System.out.print(i + " -> ");
			for (Integer el : adjList.get(i)) {
				System.out.print(el + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int nVertices = 4;
		ArrayList<ArrayList<Integer>> adjList = createGraph(nVertices);
		addEdge(adjList, 0, 1);
		addEdge(adjList, 0, 2);
		addEdge(adjList, 1, 2);
		addEdge(adjList, 1, 3);

		printGraph(adjList);

	}

}
