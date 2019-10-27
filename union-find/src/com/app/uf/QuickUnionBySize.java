package com.app.uf;

import java.util.Arrays;

public class QuickUnionBySize {
	int[] id;
	int[] size;

	public QuickUnionBySize(int n) {
		id = new int[n];
		size = new int[n];

		for (int i = 0; i < n; i++) {
			id[i] = i;
			size[i] = 1;
		}
	}
	
	private int root(int i) {
		while(i != id[i]) {
			i = id[i];
		}
		
		return i;
	}
	
	private boolean connected(int p, int q) {
		return root(p) == root(q);
	}
	
	//union by size -- always smaller tree gets appended to the larger tree
	private void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		
		if(i == j)
			return;
		else if(size[i] > size[j]) {
			size[i] = size[i] + size[j];
			id[j] = i;
		} else {
			size[j] = size[i] + size[j];
			id[i] = j;
		}
	}
	
	private void display() {
		System.out.println("ID array");
		System.out.println(Arrays.toString(id));
		
		System.out.println("Size array");
		System.out.println(Arrays.toString(size));
	}

	public static void main(String[] args) {
		QuickUnionBySize u = new QuickUnionBySize(10);
		
		u.union(3, 4);
		
		u.display();
		
		u.union(2, 1);
		
		u.display();
		
		u.union(5, 6);
		
		u.display();

	}

}
