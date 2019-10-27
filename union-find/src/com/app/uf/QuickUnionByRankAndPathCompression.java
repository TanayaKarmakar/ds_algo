package com.app.uf;

import java.util.Arrays;

public class QuickUnionByRankAndPathCompression {
	int[] id;
	int[] rank;

	public QuickUnionByRankAndPathCompression(int n) {
		this.id = new int[n];
		this.rank = new int[n];

		for (int i = 0; i < n; i++) {
			id[i] = i;
			rank[i] = 0;
		}
	}

	public int root(int i) {
		while (i != id[i]) {
			id[i] = id[id[i]];
			i = id[i];
		}
		return i;
	}

	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		if (i == j)
			return;
		else {
			if(rank[i] >= rank[j]) {
				if(rank[i] == rank[j]) {
					rank[i]++;
				}
				id[j] = i;
			} else {
				id[i] = j;
			}
		}
	}
	
	public void display() {
		System.out.println("ID - " + Arrays.toString(id));
		System.out.println("Rank - " + Arrays.toString(rank));
		System.out.println();
	}

	public static void main(String[] args) {
		QuickUnionByRankAndPathCompression qu = new QuickUnionByRankAndPathCompression(10);
		qu.display();
		
		qu.union(1, 2);
		qu.display();
		
		qu.union(3, 4);
		qu.display();
		
		qu.union(5, 6);
		qu.display();
		
		qu.union(0, 5);
		qu.display();
		
		qu.union(7, 8);
		qu.display();
		
		qu.union(4, 9);
		qu.display();
		
		qu.union(3, 7);
		qu.display();
		
		qu.union(9, 1);
		qu.display();
		
		qu.union(4, 5);
		qu.display();
		
		System.out.println();
	}

}
