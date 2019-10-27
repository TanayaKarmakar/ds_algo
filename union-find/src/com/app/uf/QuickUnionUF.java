package com.app.uf;

import java.util.Arrays;

public class QuickUnionUF {
	int[] id;

	public QuickUnionUF(int n) {
		this.id = new int[n];
		for (int i = 0; i < n; i++) {
			this.id[i] = i;
		}
	}

	public int root(int i) {
		while (i != id[i]) {
			i = id[i];
		}
		return i;
	}

	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		id[i] = j;
	}
	
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}
	
	public void display() {
		System.out.println(Arrays.toString(id));
	}

	public static void main(String[] args) {
		QuickUnionUF uf = new QuickUnionUF(10);
		
		System.out.println("Before processing");
		uf.display();
		
		uf.union(4, 3);
		
		System.out.println("After modification(4,3)");
		uf.display();
		
		uf.union(3, 8);
		
		System.out.println("After modification(3,8)");
		uf.display();
		
		uf.union(6, 5);
		
		System.out.println("After modification(6,5)");
		uf.display();
		
		uf.union(9, 4);
		
		System.out.println("After modification(9,4)");
		uf.display();
		
		uf.union(2, 1);
		
		System.out.println("After modification(2,1)");
		uf.display();
		
		System.out.println("connected(8,9) " + uf.connected(8, 9));
		System.out.println("connected(5,4) " + uf.connected(5, 4));
		
		uf.union(5, 0);
		
		System.out.println("After modification(5,0)");
		uf.display();
		
		uf.union(7, 2);
		
		System.out.println("After modification(7,2)");
		uf.display();
		
		uf.union(6, 1);
		
		System.out.println("After modification(6,1)");
		uf.display();
		
		uf.union(7, 3);
		
		System.out.println("After modification(7,3)");
		uf.display();
		
		
	}

}
