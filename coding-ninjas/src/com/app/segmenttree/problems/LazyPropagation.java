package com.app.segmenttree.problems;

public class LazyPropagation {
	private static void buildTree(int[] nums, int[] tree, int start, int end, int treeIndx) {
		if(start == end) {
			tree[treeIndx] = nums[start];
			return;
		}
		
		int mid = start + (end - start)/2;
		buildTree(nums, tree, start, mid, 2 * treeIndx);
		buildTree(nums, tree, mid + 1, end, 2 * treeIndx + 1);
		tree[treeIndx] = Integer.min(tree[2 * treeIndx], tree[2 * treeIndx + 1]);
	}
	
	private static void segmentTreeLazyUpdate(int[] tree, int[] lazy, int start, int end, int left, 
			int right, int treeIndx, int value) {
		
		if(end < start)
			return;
		if(lazy[treeIndx] != 0) {
			tree[treeIndx] += lazy[treeIndx];
			
			if(start != end) {
				lazy[2 * treeIndx] += lazy[treeIndx];
				lazy[2 * treeIndx + 1] += lazy[treeIndx];
			}
			lazy[treeIndx] = 0;
		}
		
		if(end < left || start > right)
			return;
		if(start >= left && end <= right) {
			tree[treeIndx] += value;
			
			if(start != end) {
				lazy[2 * treeIndx] += value;
				lazy[2 * treeIndx + 1] += value;
			}
			return;
		}
		
		int mid = start + (end - start)/2;
		segmentTreeLazyUpdate(tree, lazy, start, mid, left, right, 2 * treeIndx, value);
		segmentTreeLazyUpdate(tree, lazy, mid + 1, end, left, right, 2 * treeIndx + 1, value);
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, -2, 4 };
		int n = nums.length;
		
		int[] tree = new int[3 * n];
		int[] lazy = new int[3 * n];
		buildTree(nums, tree, 0, n - 1, 1);
		
		System.out.println("After Building tree");
		for(int i = 1; i < tree.length; i++) {
			System.out.print(tree[i] + " ");
		}
		
		System.out.println();
		
		segmentTreeLazyUpdate(tree, lazy, 0, n - 1, 0, n - 1, 1, 3);
		
		System.out.println("After Update");
		for(int i = 1; i < tree.length; i++) {
			System.out.print(tree[i] + " ");
		}
		System.out.println();
		System.out.println("Lazy Tree");
		for(int i = 1; i < lazy.length; i++) {
			System.out.print(lazy[i] + " ");
		}
		
		System.out.println();

	}

}
