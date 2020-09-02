package com.app.practice;

import java.util.LinkedList;

public class GraphValidTreeLeetcode261 {
	private static void dfs(LinkedList<Integer>[] graph, int i, boolean[] visited, int n) {
		visited[i] = true;
		LinkedList<Integer> nei = graph[i];
		for (Integer el : nei) {
			if (!visited[el])
				dfs(graph, el, visited, n);
		}
	}

	private static int getParent(int[] parent, int v) {
		if (parent[v] == v)
			return v;
		v = parent[v];
		parent[v] = getParent(parent, v);
		return parent[v];
	}

	private static boolean hasCycle(int[][] edges, int n) {
		int[] parent = new int[n];
		int[] rank = new int[n];

		for (int i = 0; i < n; i++)
			parent[i] = i;

		for (int i = 0; i < edges.length; i++) {
			int v1 = edges[i][0];
			int v2 = edges[i][1];
			int v1Parent = getParent(parent, v1);
			int v2Parent = getParent(parent, v2);

			if (v1Parent == v2Parent)
				return true;
			if (rank[v1Parent] < rank[v2Parent])
				parent[v1Parent] = v2Parent;
			else if (rank[v1Parent] > rank[v2Parent])
				parent[v2Parent] = v1Parent;
			else {
				parent[v2Parent] = v1Parent;
				rank[v1Parent]++;
			}
		}
		return false;
	}

	private static boolean validTree(int n, int[][] edges) {
		LinkedList<Integer>[] graph = new LinkedList[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new LinkedList<Integer>();
		}

		for (int i = 0; i < edges.length; i++) {
			int v1 = edges[i][0];
			int v2 = edges[i][1];

			graph[v1].add(v2);
			graph[v2].add(v1);
		}

		boolean[] visited = new boolean[n];
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				dfs(graph, i, visited, n);
				count++;
			}
		}
		if (count != 1)
			return false;
		if (hasCycle(edges, n))
			return false;
		return true;
	}

	public static void main(String[] args) {
		int[][] edges = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } };

		int n = 5;

		System.out.println(validTree(n, edges));

		edges = new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 3 }, { 1, 4 } };

		n = 5;
		
		System.out.println(validTree(n, edges));
	
	}

}
