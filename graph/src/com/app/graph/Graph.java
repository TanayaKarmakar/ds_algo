package com.app.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
	Map<Vertex, List<Vertex>> adjList;

	public Graph() {
		adjList = new HashMap<>();
	}

	public void addVertex(String label) {
		adjList.putIfAbsent(new Vertex(label), new ArrayList<>());
	}

	public void addEdges(String source, String dest) {
		Vertex v1 = new Vertex(source);
		Vertex v2 = new Vertex(dest);
		adjList.get(v1).add(v2);
		adjList.get(v2).add(v1);

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
	
	public List<Vertex> getAdjVertices(String label) {
		return adjList.get(new Vertex(label));
	}

	static class Vertex {
		private final String label;

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((label == null) ? 0 : label.hashCode());
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
			if (label == null) {
				if (other.label != null)
					return false;
			} else if (!label.equals(other.label))
				return false;
			return true;
		}

		public Vertex(String label) {
			this.label = label;
		}

		public String getLabel() {
			return this.label;
		}
	}
}
