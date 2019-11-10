package com.app.graph;

import java.util.ArrayList;
import java.util.List;

public class WeightedNonDirectedGraph<T> {
	private List<Edge<T>> edges;
	private List<Vertex<T>> vertices;
	
	public WeightedNonDirectedGraph() {
		this.edges = new ArrayList<>();
		this.vertices = new ArrayList<>();
	}
	
	public List<Edge<T>> getAllEdges() {
		return this.edges;
	}
	
	public List<Vertex<T>> getAllVertices() {
		return this.vertices;
	}
	
	public void addEdge(T from, T to, int weight) {
		Edge<T> edge = new Edge<T>(from, to, weight);
		this.edges.add(edge);
		Vertex<T> vert1 = new Vertex<T>(from);
		Vertex<T> vert2 = new Vertex<T>(to);
		if(!this.vertices.contains(vert1)) {
			this.vertices.add(vert1);
		}
		if(!this.vertices.contains(vert2)) {
			this.vertices.add(vert2);
		}
	}
	
	static class Vertex<T> {
		private final T label;
		
		public Vertex(T label) {
			this.label = label;
		}

		public T getLabel() {
			return label;
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

	static class Edge<T> {
		private final T from;
		private final T to;
		private final int weight;
		
		public Edge(T from, T to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		public T getFrom() {
			return from;
		}

		public T getTo() {
			return to;
		}

		public int getWeight() {
			return weight;
		}
		
		public String toString() {
			return this.from + "" + this.to + " -> " + this.weight;
		}
	}
}
