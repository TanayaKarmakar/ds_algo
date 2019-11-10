package com.app.graph;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {
	int[] id;
	int[] rank;
	
//	static class Node {
//		int data;
//		Node parent;
//		int rank;
//	}
//	
//	private Map<Integer, Node> map;

	public DisjointSet(int n) {
		this.id = new int[n];
		this.rank = new int[n];
		
		//this.map = new HashMap<>();
	}
	
	public void makeSet(int i) {
		id[i] = i;
		rank[i] = 0;
//		
//		Node node = new Node();
//		node.data = i;
//		node.rank = 0;
//		node.parent = node;
//		map.put(i, node);
	}

	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	public int root(int i) {
//		for(Map.Entry<Integer, Node> entry: map.entrySet()) {
//			Node node = entry.getValue();
//			if(i != node.parent.data) {
//				
//			}
//		}
		while (i != id[i]) {
			id[i] = id[id[i]];
			i = id[i];
		}
		return i;
	}
	
	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		if(i == j)
			return;
		else if(rank[i] >= rank[j]) {
			if(rank[i] == rank[j]) {
				rank[i]++;
			}
			id[j] = i;
		} else {
			id[i] = j;
		}
	}
}
