package com.app.problems.spoj;

import java.util.Scanner;

public class CataPultTheBall {
	private static void buildTree(int[] tree, int[] nums, int start, int end, int treeIndx) {
		if (start == end) {
			tree[treeIndx] = nums[start];
			return;
		}

		int mid = (start + end) >> 1;
		buildTree(tree, nums, start, mid, 2 * treeIndx);
		buildTree(tree, nums, mid + 1, end, 2 * treeIndx + 1);
		tree[treeIndx] = Integer.max(tree[2 * treeIndx], tree[2 * treeIndx + 1]);
	}

	private static int query(int[] tree, int start, int end, int left, int right, int treeIndx) {
		if (end < left || start > right)
			return 0;
		if (start >= left && end <= right)
			return tree[treeIndx];

		int mid = (start + end) >> 1;
		int ans1 = query(tree, start, mid, left, right, 2 * treeIndx);
		int ans2 = query(tree, mid + 1, end, left, right, 2 * treeIndx + 1);
		return Integer.max(ans1, ans2);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int q = scanner.nextInt();

		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = scanner.nextInt();
		}

		int[] tree = new int[4 * n];
		buildTree(tree, nums, 0, n - 1, 1);
		int count = 0;
		while (q-- > 0) {
			int e1 = scanner.nextInt();
			int e2 = scanner.nextInt();

			int left = Integer.min(e1, e2);
			int right = Integer.max(e1, e2) - 1;
			
			int val = query(tree, 0, n - 1, left, right, 1);
			//System.out.println("Range("+left+","+right+") -> " + val);
			if(nums[e1] == val)
				count++;
		}
		
		System.out.println(count);

		scanner.close();
	}

}
