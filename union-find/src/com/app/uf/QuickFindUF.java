package com.app.uf;

import java.util.Arrays;

public class QuickFindUF {
	int[] id;

	public QuickFindUF(int n) {
		this.id = new int[n];
		for (int i = 0; i < n; i++) {
			this.id[i] = i;
		}
	}

	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}

	public void union(int p, int q) {
		int pid = id[p];
		int qid = id[q];
		for (int i = 0; i < id.length; i++) {
			if(id[i] == pid) {
				id[i] = qid;
			}
		}
	}
	
	public void display() {
		System.out.println(Arrays.toString(id));
	}

	public static void main(String[] args) {
		QuickFindUF uf = new QuickFindUF(10);
		
		System.out.println("Before processing");
		uf.display();
		
		uf.union(1, 2);
		
		uf.display();
		
		System.out.println("1 and 2 connected - " + uf.connected(1, 2));
		
		System.out.println("3 and 4 are connected - " + uf.connected(3, 4));
		
		uf.union(3, 4);
		
		uf.display();
		
		uf.union(5, 6);
		
		uf.display();
		
		uf.union(7, 8);
		
		uf.union(7, 9);
		
		uf.display();
		
		uf.union(5, 0);
		
		uf.display();
		
		uf.union(2, 8);
		
		uf.display();
		
		uf.union(1, 9);
		
		uf.display();
	}

}
