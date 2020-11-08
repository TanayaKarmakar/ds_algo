package com.app.practice.graphbfsdfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class Parent {
	int node;
	int rank;

	public Parent(int node, int rank) {
		this.node = node;
		this.rank = rank;
	}
}

public class GraphValidTreeLeetcode261 {
	private static void dfs(LinkedList<Integer>[] edgeList, int start, Set<Integer> visited) {
		visited.add(start);
		LinkedList<Integer> neighbors = edgeList[start];
		for (Integer nei : neighbors) {
			if (!visited.contains(nei))
				dfs(edgeList, nei, visited);
		}
	}

	private static boolean isConnected(LinkedList<Integer>[] edgeList, int n) {
		int count = 0;
		Set<Integer> visited = new HashSet<>();

		for (int i = 0; i < n; i++) {
			if (!visited.contains(i)) {
				dfs(edgeList, i, visited);
				count++;
			}
		}

		return count == 1;
	}

	private static int getParent(Parent[] parents, int x) {
		if (parents[x].node == x)
			return x;
		return getParent(parents, parents[x].node);
	}

	private static boolean hasCycle(int n, int[][] edges) {
		Parent[] parents = new Parent[n];

		for (int i = 0; i < n; i++) {
			Parent parent = new Parent(i, 0);
			parents[i] = parent;
		}

		for (int i = 0; i < edges.length; i++) {
			int x = edges[i][0];
			int y = edges[i][1];

			int xParent = getParent(parents, x);
			int yParent = getParent(parents, y);

			if (xParent == yParent)
				return true;
			if (parents[xParent].rank > parents[yParent].rank) {
				parents[yParent].node = xParent;
			} else if (parents[xParent].rank < parents[yParent].rank) {
				parents[xParent].node = yParent;
			} else {
				parents[yParent].node = xParent;
				parents[xParent].rank++;
			}
		}
		return false;
	}

	private static boolean validTree(int n, int[][] edges) {
		LinkedList<Integer>[] edgeList = new LinkedList[n];

		for (int i = 0; i < n; i++) {
			edgeList[i] = new LinkedList<Integer>();
		}

		for (int i = 0; i < edges.length; i++) {
			int v1 = edges[i][0];
			int v2 = edges[i][1];
			edgeList[v1].add(v2);
			edgeList[v2].add(v1);
		}

		if (!isConnected(edgeList, n))
			return false;
		return hasCycle(n, edges) ? false : true;
	}

	public static void main(String[] args) {
		int[][] edges = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } };
		int n = 5;
		
		System.out.println(validTree(n, edges));

	}

}
