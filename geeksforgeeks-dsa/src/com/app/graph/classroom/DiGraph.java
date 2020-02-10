package com.app.graph.classroom;

import java.util.ArrayList;
import java.util.List;

public class DiGraph {
	private int nVertices;
	private List<List<Integer>> adjList;

	public DiGraph(int nVertices) {
		this.nVertices = nVertices;
		this.adjList = new ArrayList<>(nVertices);
		for (int i = 0; i < nVertices; i++) {
			this.adjList.add(new ArrayList<>());
		}
	}

	public void addEdge(int u, int v) {
		this.adjList.get(u).add(v);
	}

	public List<Integer> getEdges(int vertex) {
		return this.adjList.get(vertex);
	}
	
	public int size() {
		return this.adjList.size();
	}
	
	public List<List<Integer>> getAdjList() {
		return this.adjList;
	}

	public void printGraph() {
		for (int i = 0; i < nVertices; i++) {
			List<Integer> nodeList = this.adjList.get(i);
			System.out.print(i + " -> ");
			for(Integer node: nodeList) {
				System.out.print(node + " ");
			}
			System.out.println();
		}
	}
}
