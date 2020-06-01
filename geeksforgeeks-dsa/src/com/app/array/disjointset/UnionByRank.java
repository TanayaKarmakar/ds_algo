package com.app.array.disjointset;

import java.util.Arrays;

public class UnionByRank {
	private int[] parent;
	private int[] rank;

	public UnionByRank(int n) {
		this.parent = new int[n];
		this.rank = new int[n];
		
		for(int i = 0; i < n; i++) {
			this.parent[i] = i;
		}
	}
	
	public int getParent(int v) {
		if(parent[v] == v)
			return v;
		//return getParent(v);
		
		//path compression
		v = parent[v];
		parent[v] = getParent(v);
		return parent[v];
	}
	
	public void union(int v1, int v2) {
		int v1Parent = getParent(v1);
		int v2Parent = getParent(v2);
		if(v1Parent == v2Parent)
			return;
		if(rank[v1Parent] < rank[v2Parent]) {
			parent[v1Parent] = v2Parent;
		} else if(rank[v1Parent] > rank[v2Parent]) {
			parent[v2Parent] = v1Parent;
		} else {
			parent[v2Parent] = v1Parent;
			rank[v1Parent]++;
		}
	}

	public void performUnion(int[][] edges) {
		for(int i = 0; i < edges.length; i++) {
			int[] edge = edges[i];
			int v1 = edge[0];
			int v2 = edge[1];
			
			union(v1, v2);
		}
	}
	
	public int[] getParent() {
		return this.parent;
	}
	
	public int[] getRank() {
		return this.rank;
	}

	public static void main(String[] args) {
		int n = 5;
		int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
		UnionByRank ur = new UnionByRank(n);
		ur.performUnion(edges);
		
		System.out.println("Parent - " + Arrays.toString(ur.getParent()));
		
		System.out.println("Rank - " + Arrays.toString(ur.getRank()));
		
	}

}
