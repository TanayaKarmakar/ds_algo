package com.app.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiGraph {
	private Map<Vertex, List<Vertex>> adjList;
	private int[] inDegree;
	
	public DiGraph(int nVertices) {
		this.adjList = new HashMap<>(nVertices);
		this.inDegree = new int[nVertices];
	}
	
	public Map<Vertex, List<Vertex>> getAdjList() {
		return this.adjList;
	}
	
	public void addVertex(int label) {
		adjList.putIfAbsent(new Vertex(label), new ArrayList<>());
	}
	
	public void addEdge(int src, int dest) {
		Vertex v1 = new Vertex(src);
		Vertex v2 = new Vertex(dest);
		adjList.get(v1).add(v2);
		inDegree[dest]++;
	}
	
	public void displayGraph() {
		for(Map.Entry<Vertex, List<Vertex>> entry: adjList.entrySet()) {
			System.out.print(entry.getKey().getLabel() + " -- ");
			for(Vertex vert: entry.getValue()) {
				System.out.print(vert.getLabel() + " -> ");
			}
			System.out.println();
		}
	}
	
	public int[] getInDegree() {
		return this.inDegree;
	}
	
	public List<Vertex> getAdjVertices(int label) {
		return adjList.get(new Vertex(label));
	}
	
	
	static class Vertex {
		final int label;
		
		public Vertex(int label) {
			this.label = label;
		}

		public int getLabel() {
			return label;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + label;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Vertex other = (Vertex) obj;
			if (label != other.label)
				return false;
			return true;
		}
		
		public String toString() {
			return String.valueOf(this.label);
		}
	}
}
