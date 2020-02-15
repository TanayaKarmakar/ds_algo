package com.app.graph.classroom;

import java.util.ArrayList;

public class Graph {
	int nVertices;
	ArrayList<ArrayList<Integer>> adjList;

	public Graph(int nVertices) {
		this.nVertices = nVertices;
		this.adjList = new ArrayList<>(nVertices);

		for (int i = 0; i < nVertices; i++) {
			this.adjList.add(new ArrayList<>());
		}
	}

	public void addEdge(int u, int v) {
		adjList.get(u).add(v);
		adjList.get(v).add(u);
	}

	public void printGraph(ArrayList<ArrayList<Integer>> adjList) {
		for (int i = 0; i < adjList.size(); i++) {
			System.out.print(i + " -> ");
			for (Integer el : adjList.get(i)) {
				System.out.print(el + " ");
			}
			System.out.println();
		}
	}

	public ArrayList<Integer> getEdges(int nVertex) {
		return this.adjList.get(nVertex);
	}
	
	public ArrayList<ArrayList<Integer>> getAdjList() {
		return this.adjList;
	}
	
	public int getNumVertices() {
		return this.nVertices;
	}
}
