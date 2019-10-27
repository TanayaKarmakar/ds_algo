package com.app.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParameterizedGraph<T> {
	private Map<Vertex<T>, List<Vertex<T>>> adjList;

	public ParameterizedGraph() {
		this.adjList = new HashMap<>();
	}

	public void addVertex(T label) {
		Vertex<T> vert = new Vertex<T>(label);
		adjList.putIfAbsent(vert, new ArrayList<>());
	}

	public void addEdges(T src, T dest) {
		Vertex<T> vert1 = new Vertex<T>(src);
		Vertex<T> vert2 = new Vertex<T>(dest);
		adjList.get(vert1).add(vert2);
		adjList.get(vert2).add(vert1);
	}
	
	public Map<Vertex<T>, List<Vertex<T>>> getAdjList() {
		return this.adjList;
	}

	public void displayGraph() {
		for (Map.Entry<Vertex<T>, List<Vertex<T>>> entry : adjList.entrySet()) {
			System.out.print(entry.getKey().getLabel() + "\t");
			for (Vertex<T> vert : entry.getValue()) {
				System.out.print(vert.getLabel() + " -> ");
			}
			System.out.println();
		}
	}
	
	public int length() {
		return this.adjList.size();
	}
	
	public List<Vertex<T>> getAdjVertices(T label) {
		return this.adjList.get(new Vertex<T>(label));
	}

	static class Vertex<T> {
		private T label;

		public Vertex(T label) {
			this.label = label;
		}

		public T getLabel() {
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
