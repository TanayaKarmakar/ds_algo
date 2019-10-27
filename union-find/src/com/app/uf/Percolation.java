package com.app.uf;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	private int[][] mat;
	private int n;
	private WeightedQuickUnionUF uf;
	
	private int sourceId = 0;
	private int sinkId;
	
	private int nOpenSites = 0;
	
	public Percolation(int n) {
		this.n = n;
		this.mat = new int[n][n];
		this.uf = new WeightedQuickUnionUF((n * n) + 2);
		this.sinkId = (n * n) + 1;
	}
	
	public void open(int i, int j) {
		mat[i - 1][j - 1] = 1;
		if(i == 1)
			uf.union(this.getFlatIndex(i, j), sourceId);
		if(i == n)
			uf.union(this.getFlatIndex(i, j), sinkId);
		if(i > 1 && this.isOpen(i - 1, j))
			uf.union(this.getFlatIndex(i, j), this.getFlatIndex(i - 1, j));
		if(i < n && this.isOpen(i + 1, j))
			uf.union(this.getFlatIndex(i, j), this.getFlatIndex(i + 1, j));
		if(j > 1 && this.isOpen(i, j - 1))
			uf.union(this.getFlatIndex(i, j), this.getFlatIndex(i, j - 1));
		if(j < n && this.isOpen(i, j + 1))
			uf.union(this.getFlatIndex(i, j), this.getFlatIndex(i, j + 1));
		nOpenSites++;
		
	}
	
	public boolean isOpen(int i, int j) {
		return mat[i - 1][j - 1] == 1;
	}
	
	public boolean isFull(int i, int j) {
		if(i > 0 && i <= n && j > 0 && j <= n)
			return uf.connected(sourceId, this.getFlatIndex(i, j));
		else
			throw new IndexOutOfBoundsException();
	}
	
	public int numberOfOpenSites() {
		return this.nOpenSites;
	}
	
	public boolean percolates() {
		return uf.connected(sourceId, sinkId);
	}
	
	private int getFlatIndex(int i, int j) {
		return ((i - 1) * n + j);
	}
}
