package com.app.segmenttree.problems;

public class TwoDSegmentTree {
	private static int m;
	private static int n;
	private static int[][] tree;
	
	private static void build1D(int[] arr, int[] tree, int start, int end, int treeIndx) {
		if(start == end) {
			tree[treeIndx] = arr[start];
			return;
		}
		int mid = (start + end) >> 1;
		build1D(arr, tree, start, mid, 2 * treeIndx);
		build1D(arr, tree, mid + 1, end, 2 * treeIndx + 1);
		tree[treeIndx] = tree[2 * treeIndx] + tree[2 * treeIndx + 1];
	}
	
	private static void build2D(int[][] mat, int start, int end, int treeIndx) {
		if(start == end) {
			//build 1D segment tree
			build1D(mat[start], tree[treeIndx], 0, n - 1, 1);
			return;
		}
		int mid = (start + end) >> 1;
		build2D(mat, start, mid, 2 * treeIndx);
		build2D(mat, mid + 1, end, 2 * treeIndx + 1);
		for(int i = 0; i < tree[treeIndx].length; i++) {
			tree[treeIndx][i] = tree[2 * treeIndx][i] + tree[2 * treeIndx][i];
		}
	}
	
	private static int query1D(int[] tree, int start, int end, int l, int r, int treeIndx) {
		if(end < l || start > r)
			return 0;
		if(start >= l && end <= r)
			return tree[treeIndx];
		int mid = (start + end) >> 1;
		int left = query1D(tree, start, mid, l, r, 2 * treeIndx);
		int right = query1D(tree, mid + 1, left, l, r, 2 * treeIndx + 1);
		return left + right;
	}
	
	private static int query2D(int start, int end, 
			int x1, int y1, int x2, int y2, int treeIndx) {
		if(end < x1 || start > x2)
			return 0;
		if(start >= x1 && end <= x2)
			return query1D(tree[treeIndx], y1, y2, 0, n - 1, 1);
		int mid = (start + end) >> 1;
		int left = query2D(start, mid, x1, y1, x2, y2, 2 * treeIndx);
		int right = query2D(mid + 1, end, x1, y1, x2, y2, 2 * treeIndx + 1); 
		return (left + right);
	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		m = mat.length;
		n = mat[0].length;

		tree = new int[2 * m][2 * n];
		
		build2D(mat, 0, m - 1, 1);
		
		System.out.println("Final Tree");
		for(int i = 1; i < (2 * m); i++) {
			for(int j = 1; j < (2 * n); j++) {
				System.out.print(tree[i][j] + " ");
			}
			System.out.println();
		}
		
		int sum = query2D(0, m - 1, 1, 1, 2, 2, 1);
		
		System.out.println(sum);
	}

}
