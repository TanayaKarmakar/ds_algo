package com.app.questions;

import java.util.LinkedList;

public class GraphValidTreeLeetcode261 {
	
	private static void dfs(LinkedList<Integer>[] list, int i, boolean[] visited, int n) {
		visited[i] = true;
		LinkedList<Integer> nodes = list[i];
		for(int node: nodes) {
			if(!visited[node]) {
				dfs(list, node, visited, n);
			}
		}
	}
	
	private static int getParent(int[] parent, int x) {
		if(parent[x] == x)
			return x;
		x = parent[x];
		return getParent(parent, x);
	}
	
	private static boolean hasCycle(int[][] edges, int n) {
		int[] parent = new int[n];
		for(int i =0; i < n; i++)
			parent[i] = i;
		
		for(int i = 0; i < edges.length; i++) {
			int[] edge = edges[i];
			int v1 = edge[0];
			int v2 = edge[1];
			int v1Parent = getParent(parent, v1);
			int v2Parent = getParent(parent, v2);
			if(v1Parent == v2Parent)
				return false;
			parent[v2Parent] = v1Parent;
			
		}
		return true;
	}

	public static boolean validTree(int n, int[][] edges) {
		// first number of connected components should be one
		LinkedList<Integer>[] list = new LinkedList[n];
		
		for(int i = 0; i < n; i++) {
			list[i] = new LinkedList<Integer>();
		}
		
		for(int i = 0; i < edges.length;i++) {
			int[] edge = edges[i];
			int v1 = edge[0];
			int v2 = edge[1];
			list[v1].add(v2);
			list[v2].add(v1);
		}
		
		boolean[] visited = new boolean[n];
		int count = 0;
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				dfs(list, i, visited, n);
				count++;
			}
		}
		
		if(count != 1)
			return false;
		
		// there should be no cycle
		return hasCycle(edges, n);
	}

	public static void main(String[] args) {
		int[][] edges = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } };

		System.out.println(validTree(5, edges));

		edges = new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 3 }, { 1, 4 } };

		System.out.println(validTree(5, edges));

		edges = new int[][] { { 0, 1 }, { 2, 3 }, { 1, 2 } };

		System.out.println(validTree(4, edges));
	}

}
