package com.app.graph.classroom;

import java.util.ArrayList;
import java.util.List;

class Edge {
	private int node;
	private int weight;
	
	public Edge(int node, int weight) {
		this.node = node;
		this.weight = weight;
	}

	public int getNode() {
		return node;
	}

	public int getWeight() {
		return weight;
	}
}

public class WeightedDiGraph {
	private int nVertices;
	private List<List<Edge>> adjList;

	public WeightedDiGraph(int nVertices) {
		this.nVertices = nVertices;
		this.adjList = new ArrayList<>(nVertices);
		for (int i = 0; i < nVertices; i++) {
			this.adjList.add(new ArrayList<>());
		}
	}

	public void addEdge(int u, int v, int weight) {
		Edge edge = new Edge(v, weight);
		this.adjList.get(u).add(edge);
	}

	public List<Edge> getEdges(int vertex) {
		return this.adjList.get(vertex);
	}
	
	public int size() {
		return this.adjList.size();
	}
	
	public List<List<Edge>> getAdjList() {
		return this.adjList;
	}

	public void printGraph() {
		for (int i = 0; i < nVertices; i++) {
			List<Edge> nodeList = this.adjList.get(i);
			System.out.print(i + " -> ");
			for(Edge edge: nodeList) {
				System.out.print(edge.getNode() + " ");
			}
			System.out.println();
		}
	}
}
