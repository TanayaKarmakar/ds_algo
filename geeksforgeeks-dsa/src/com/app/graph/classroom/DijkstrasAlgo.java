package com.app.graph.classroom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

class Node implements Comparable<Node> {
	int path;
	int cost;

	public Node(int path, int cost) {
		this.path = path;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node that) {
		if (this.cost < that.cost)
			return -1;
		else if (this.cost > that.cost)
			return 1;
		else
			return 0;
	}
}

public class DijkstrasAlgo {
	static int[] dist;
	static Set<Integer> settled;
	static PriorityQueue<Node> pQ;
	static List<List<Node>> adjList;

	private static void initParams(int nVert, int src) {
		dist = new int[nVert];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[src] = 0;
		settled = new HashSet<>(nVert);
		settled.add(src);
		pQ = new PriorityQueue<>();
		pQ.add(new Node(src, 0));
		adjList = new ArrayList<>();
		for (int i = 0; i < nVert; i++) {
			adjList.add(new ArrayList<>());
		}
	}

	private static void addEdge(int source, int dest, int weight) {
		adjList.get(source).add(new Node(dest, weight));
		adjList.get(dest).add(new Node(source, weight));
	}

	private static void dijkstra(int src, int nVert) {

		while (settled.size() != nVert) {
			int u = pQ.remove().path;

			settled.add(u);

			addNeighbors(u);
		}

		printDistances();
	}

	private static void printDistances() {
		for (Integer el : dist) {
			System.out.print(el + " ");
		}
		System.out.println();
	}

	private static void addNeighbors(int u) {
		List<Node> nodes = adjList.get(u);
		for (Node node : nodes) {
			if (!settled.contains(node.path)) {
				int newDist = dist[u] + node.cost;
				if (dist[node.path] > newDist) {
					dist[node.path] = newDist;
				}
				pQ.add(new Node(node.path, dist[node.path]));
			}
		}
	}

	public static void main(String[] args) {
		int nVert = 9;
		int src = 0;
		initParams(nVert, src);
		addEdge(0, 1, 4);
		addEdge(0, 7, 8);
		addEdge(1, 2, 8);
		addEdge(1, 7, 11);
		addEdge(7, 8, 7);
		addEdge(7, 6, 1);
		addEdge(2, 3, 7);
		addEdge(2, 5, 4);
		addEdge(2, 8, 2);
		addEdge(8, 6, 6);
		addEdge(6, 5, 2);
		addEdge(3, 4, 9);
		addEdge(3, 5, 14);
		addEdge(4, 5, 10);

		dijkstra(src, nVert);
	}

}
