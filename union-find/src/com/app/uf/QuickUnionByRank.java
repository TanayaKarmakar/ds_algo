package com.app.uf;

import java.util.Arrays;

public class QuickUnionByRank {
	int[] id;
	int[] rank;

	public QuickUnionByRank(int n) {
		id = new int[n];
		rank = new int[n];

		for (int i = 0; i < n; i++) {
			id[i] = i;
			rank[i] = 0;
		}
	}

	public int root(int i) {
		while (i != id[i]) {
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
		else if (rank[i] >= rank[j]) {
			if (rank[i] == rank[j]) {
				rank[i]++;
			}
			id[j] = i;
		} else {
			id[i] = j;
		}
	}

	public void display() {
		System.out.println("ID array - " + Arrays.toString(id));
		System.out.println("Rank array - " + Arrays.toString(rank));
		System.out.println("\n");
	}

	public static void main(String[] args) {
		QuickUnionByRank qur = new QuickUnionByRank(10);
		qur.display();

		qur.union(1, 2);
		qur.display();

		qur.union(3, 4);
		qur.display();

		qur.union(5, 6);
		qur.display();

		qur.union(0, 5);
		qur.display();

		qur.union(7, 8);
		qur.display();

		qur.union(4, 9);
		qur.display();

		qur.union(3, 7);
		qur.display();

		qur.union(9, 1);
		qur.display();

		qur.union(4, 5);
		qur.display();

		for (int i = 0; i < qur.id.length; i++) {
			System.out.println("Root of " + i + " is " + qur.root(i));
		}

		System.out.println("Is connected ");
		int n = qur.id.length;
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				System.out.println("connected(" + i + "," + (n - 1) + ") - " + qur.connected(i, n - 1));
			} else {
				if ((i + 1) < n) {
					System.out.println("connected(" + i + "," + (i + 1) + ") - " + qur.connected(i, i + 1));
				}
			}
		}
	}
}
