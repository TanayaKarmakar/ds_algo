package com.app.graph.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphPractice {
	Map<Vertex, List<Vertex>> adjList;
	
	public GraphPractice() {
		this.adjList = new HashMap<>();
	}
	
	public void addVertex(String label) {
		Vertex vert = new Vertex(label);
		adjList.putIfAbsent(vert, new ArrayList<>());
	}
	
	public void addEdge(String src, String dest) {
		Vertex v1 = new Vertex(src);
		Vertex v2 = new Vertex(dest);
		adjList.get(v1).add(v2);
		adjList.get(v2).add(v1);
	}
	
	public void displayGraph() {
		for(Map.Entry<Vertex, List<Vertex>> entry: adjList.entrySet()) {
			System.out.print(entry.getKey().getLabel());
			List<Vertex> neighbors = adjList.get(entry.getKey());
			for(Vertex vert: neighbors) {
				System.out.print(" --> " + vert.getLabel());
			}
			System.out.println();
		}
	}
	
	static class Vertex {
		final String label;
		
		public Vertex(String label) {
			this.label = label;
		}
		
		public String getLabel() {
			return this.label;
		}

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
	}
}
