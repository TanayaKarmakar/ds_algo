package com.app.practice.graphbfsdfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class Set1 {
	int rank;
	int parent;

	public Set1(int rank, int parent) {
		this.rank = rank;
		this.parent = parent;
	}
}

public class GraphValidTreeLeetcode261 {
	private static void dfs(LinkedList<Integer>[] edgeList, int v, Set<Integer> visited) {
		visited.add(v);
		LinkedList<Integer> edges = edgeList[v];

		for (Integer el : edges) {
			if (!visited.contains(el))
				dfs(edgeList, el, visited);
		}
	}

	private static boolean isDisconnected(int n, int[][] edges) {
		LinkedList<Integer>[] edgeList = new LinkedList[n];
		for (int i = 0; i < n; i++) {
			edgeList[i] = new LinkedList<>();
		}

		for (int i = 0; i < edges.length; i++) {
			int[] edge = edges[i];
			int v1 = edge[0];
			int v2 = edge[1];
			edgeList[v1].add(v2);
			edgeList[v2].add(v1);
		}

		int count = 0;
		Set<Integer> visited = new HashSet<>();
		for (int i = 0; i < n; i++) {
			if (!visited.contains(i)) {
				dfs(edgeList, i, visited);
				count++;
			}
		}

		if(count == 1)
			return false;
		else
			return true;
	}

	private static int find(int x, Set1[] sets) {
		if (sets[x].parent == x)
			return sets[x].parent;
		return find(sets[x].parent, sets);
	}

	private static void union(int xRoot, int yRoot, Set1[] sets) {
		if (sets[xRoot].rank < sets[yRoot].rank) {
			sets[xRoot].parent = yRoot;
		} else if (sets[xRoot].rank > sets[yRoot].rank) {
			sets[yRoot].parent = xRoot;
		} else {
			sets[yRoot].parent = xRoot;
			sets[xRoot].rank++;
		}
	}

	private static boolean validTree(int n, int[][] edges) {
		if (isDisconnected(n, edges))
			return false;
		Set1[] sets = new Set1[n];
		for (int i = 0; i < n; i++) {
			sets[i] = new Set1(0, i);
		}

		for (int i = 0; i < edges.length; i++) {
			int[] edge = edges[i];
			int x = edge[0];
			int y = edge[1];
			int xRoot = find(x, sets);
			int yRoot = find(y, sets);
			if (xRoot == yRoot)
				return false;
			union(xRoot, yRoot, sets);
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] edges = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } };
		int n = 5;
		boolean ans = validTree(n, edges);
		
		System.out.println(ans);	
	}

}
