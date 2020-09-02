package com.app.practice.graphbfsdfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Edge {
	int node;
	int weight;

	public Edge(int node, int weight) {
		this.node = node;
		this.weight = weight;
	}
}

public class NetworkDelayTimeLeetcode743 {
	private static int networkDelayTime(int[][] times, int N, int K) {
		Map<Integer, List<Edge>> adjList = new HashMap<>();
		for (int i = 0; i < times.length; i++) {
			int[] item = times[i];
			Edge edge = new Edge(item[1], item[2]);
			if (!adjList.containsKey(item[0])) {
				List<Edge> edges = new ArrayList<>();
				edges.add(edge);
				adjList.put(item[0], edges);
			} else {
				adjList.get(item[0]).add(edge);
			}
		}

		Queue<Integer> q = new LinkedList<>();
		q.add(K);
		q.add(null);
		Set<Integer> visited = new HashSet<>();
		visited.add(K);

		int total = 0;
		int currCost = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			Integer curr = q.poll();
			if (curr == null) {
				if (currCost != Integer.MAX_VALUE)
					total += currCost;
				currCost = Integer.MAX_VALUE;
				if (q.peek() != null)
					q.add(null);
				continue;
			}
			List<Edge> edges = adjList.get(curr);
			if(edges != null) {
				for (Edge edge : edges) {
					if(!visited.contains(edge.node)) {
						q.add(edge.node);
						currCost = Integer.min(currCost, edge.weight);
						visited.add(edge.node);
					}
				}
			}
		}
		
		if(visited.size() != N)
			return -1;

		return total;
	}

	public static void main(String[] args) {
		int[][] times = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };

		int N = 4;
		int K = 2;

		System.out.println(networkDelayTime(times, N, K));
	}

}
