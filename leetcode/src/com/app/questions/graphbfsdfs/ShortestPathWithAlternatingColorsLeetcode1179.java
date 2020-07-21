package com.app.questions.graphbfsdfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestPathWithAlternatingColorsLeetcode1179 {
	static class Edge {
		int v;
		String color;

		public Edge(int v, String color) {
			this.v = v;
			this.color = color;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((color == null) ? 0 : color.hashCode());
			result = prime * result + v;
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
			Edge other = (Edge) obj;
			if (color == null) {
				if (other.color != null)
					return false;
			} else if (!color.equals(other.color))
				return false;
			if (v != other.v)
				return false;
			return true;
		}

		public String toString() {
			return v + " - " + color;
		}
	}

	private static void bfs(LinkedList<Edge>[] edges, int[] res, int n) {
		Set<Edge> visited = new HashSet<>();
		Arrays.fill(res, -1);

		Queue<Edge> q = new LinkedList<>();
		q.add(new Edge(0, ""));
		//q.add(null);

		res[0] = 0;
		String prev = "";

		while (!q.isEmpty()) {
			Edge curr = q.poll();
			//String prev = curr.color;
			int node = curr.v;
			//visited.add(curr);

			LinkedList<Edge> edgeList = edges[node];
			for (Edge edge : edgeList) {
				if (!visited.contains(edge)) {
					String currColor = edge.color;
					int currNode = edge.v;

					if (!prev.equals(currColor)) {
						System.out.println(prev + " - " + currColor);
						if(res[currNode] == -1)
							res[currNode] = res[node] + 1;
						else
							res[currNode] = Integer.min(res[currNode], res[node] + 1);
						prev = currColor;
						visited.add(edge);
						q.add(edge);
					}	
				}
			}
		}
	}

	private static int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
		int[] res = new int[n];

		LinkedList<Edge>[] edges = new LinkedList[n];
		for (int i = 0; i < n; i++) {
			edges[i] = new LinkedList<Edge>();
		}

		for (int i = 0; i < red_edges.length; i++) {
			int[] edge = red_edges[i];
			int v1 = edge[0];
			int v2 = edge[1];

			edges[v1].add(new Edge(v2, "red"));
		}

		for (int i = 0; i < blue_edges.length; i++) {
			int[] edge = blue_edges[i];
			int v1 = edge[0];
			int v2 = edge[1];

			edges[v1].add(new Edge(v2, "blue"));
		}

		bfs(edges, res, n);

		return res;
	}

	public static void main(String[] args) {
		int n = 5;
		int[][] red_edges = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 4 } };
		int[][] blue_edges = { { 1, 2 }, { 2, 3 }, { 3, 1 } };

		int[] res = shortestAlternatingPaths(n, red_edges, blue_edges);

		System.out.println(Arrays.toString(res));

		n = 3;

		red_edges = new int[][] { { 0, 1 } };
		blue_edges = new int[][] { { 2, 1 } };

		res = shortestAlternatingPaths(n, red_edges, blue_edges);

		System.out.println(Arrays.toString(res));

		red_edges = new int[][] { { 1, 0 } };
		blue_edges = new int[][] { { 2, 1 } };

		res = shortestAlternatingPaths(n, red_edges, blue_edges);

		System.out.println(Arrays.toString(res));

		red_edges = new int[][] { { 0, 1 } };
		blue_edges = new int[][] { { 1, 2 } };

		res = shortestAlternatingPaths(n, red_edges, blue_edges);

		System.out.println(Arrays.toString(res));

		red_edges = new int[][] { { 0, 1 }, { 0, 2 } };
		blue_edges = new int[][] { { 1, 0 } };

		res = shortestAlternatingPaths(n, red_edges, blue_edges);

		System.out.println(Arrays.toString(res));

	}

}
