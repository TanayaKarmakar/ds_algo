package com.app.segmenttree.problems;

import java.util.Arrays;

public class SegmentTreeCreation {
	private static void buildTree(int[] arr, int[] tree, int start, 
			int end, int treeIndx) {
		if (start == end) {
			tree[treeIndx] = arr[start];
			return;
		}

		int mid = start + (end - start) / 2;
		buildTree(arr, tree, start, mid, 2 * treeIndx);
		buildTree(arr, tree, mid + 1, end, 2 * treeIndx + 1);
		tree[treeIndx] = tree[2 * treeIndx] + tree[2 * treeIndx + 1];
	}

	private static void updateTree(int[] arr, int[] tree, int start, int end, 
			int treeIndx, int indx, int value) {
		if (start == end) {
			arr[indx] = value;
			tree[treeIndx] = value;
			return;
		}

		int mid = start + (end - start) / 2;
		if (mid >= indx) {
			updateTree(arr, tree, start, mid, 2 * treeIndx, indx, value);
		} else {
			updateTree(arr, tree, mid + 1, end, 2 * treeIndx + 1, indx, value);
		}

		tree[treeIndx] = tree[2 * treeIndx] + tree[2 * treeIndx + 1];

	}

	private static int rangeQuery(int[] tree, int start, int end, int treeIndx, 
			int left, int right) {
		if (end < left || start > right)
			return 0;
		if (start >= left && end <= right) {
			return tree[treeIndx];
		}

		int mid = start + (end - start) / 2;
		int ans1 = rangeQuery(tree, start, mid, 2 * treeIndx, left, right);
		int ans2 = rangeQuery(tree, mid + 1, end, 2 * treeIndx + 1, left, right);
		return ans1 + ans2;
	}

	private static void printTree(int[] tree, int n) {
		for (int i = 1; i < n; i++) {
			System.out.print(tree[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		int n = arr.length;
		int[] tree = new int[2 * n];

		buildTree(arr, tree, 0, n - 1, 1);
		System.out.println("The tree is - ");
		printTree(tree, tree.length);

		updateTree(arr, tree, 0, n - 1, 1, 3, 10);
		System.out.println("After updation");

		System.out.println("Array - " + Arrays.toString(arr));

		System.out.println("Tree - ");
		printTree(tree, tree.length);

		int ans = rangeQuery(tree, 0, n - 1, 1, 2, 4);
		System.out.println(ans);
	}
}
