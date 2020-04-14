package com.app.segmenttree.problems;

import java.util.Arrays;
import java.util.Scanner;

public class RangeMinimumInSubarray {

	private static void buildTree(int[] nums, int[] tree, int start, int end, int treeIndx) {
		if (start == end) {
			tree[treeIndx] = nums[start];
			return;
		}
		int mid = start + (end - start) / 2;
		buildTree(nums, tree, start, mid, 2 * treeIndx);
		buildTree(nums, tree, mid + 1, end, 2 * treeIndx + 1);

		tree[treeIndx] = Integer.min(tree[2 * treeIndx], tree[2 * treeIndx + 1]);
	}

	private static void updateTree(int[] nums, int[] tree, int start, int end, int treeIndx, int indx, int value) {
		if (start == end) {
			nums[indx] = value;
			tree[treeIndx] = value;
			return;
		}
		int mid = start + (end - start) / 2;
		if (mid >= indx) {
			updateTree(nums, tree, start, mid, 2 * treeIndx, indx, value);
		} else {
			updateTree(nums, tree, mid + 1, end, 2 * treeIndx + 1, indx, value);
		}

		tree[treeIndx] = Integer.min(tree[2 * treeIndx], tree[2 * treeIndx + 1]);
	}

	private static int query(int[] tree, int start, int end, int treeIndx, int left, int right) {
		if (end < left || start > right)
			return Integer.MAX_VALUE;
		if (start >= left && end <= right)
			return tree[treeIndx];
		int mid = start + (end - start) / 2;
		int ans1 = query(tree, start, mid, 2 * treeIndx, left, right);
		int ans2 = query(tree, mid + 1, end, 2 * treeIndx + 1, left, right);
		System.out.println("ans1 - " + ans1 + " : ans2 - " + ans2);
		return Integer.min(ans1, ans2);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nDim = scanner.nextInt();
		int nQuery = scanner.nextInt();

		int[] nums = new int[nDim];

		for (int i = 0; i < nDim; i++) {
			nums[i] = scanner.nextInt();
		}

		int[] tree = new int[4 * nDim];
		buildTree(nums, tree, 0, nDim - 1, 1);

		while (nQuery > 0) {
			String queryType = scanner.next();
			int first = scanner.nextInt();
			int second = scanner.nextInt();
			if (queryType.equals("q")) {
				int ans = query(tree, 0, nDim - 1, 1, first - 1, second - 1);
				System.out.println(ans);
			} else {
				updateTree(nums, tree, 0, nDim - 1, 1, first - 1, second);
				System.out.println(Arrays.toString(nums));
				System.out.println(Arrays.toString(tree));
			}
			nQuery--;
		}
		scanner.close();
	}

}
