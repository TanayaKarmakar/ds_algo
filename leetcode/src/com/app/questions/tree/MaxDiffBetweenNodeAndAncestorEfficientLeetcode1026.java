package com.app.questions.tree;

import com.app.augustchallenge.BinaryTree;
import com.app.augustchallenge.BinaryTree.TreeNode;

public class MaxDiffBetweenNodeAndAncestorEfficientLeetcode1026 {
	private static int maxDiff = Integer.MIN_VALUE;

	private static int[] maxAncestorDiff(TreeNode root, int prev) {
		if (root == null)
			return new int[] { prev, prev };
		int[] left = maxAncestorDiff(root.left, root.val);
		int[] right = maxAncestorDiff(root.right, root.val);

		int min = Integer.min(left[0], right[0]);
		int max = Integer.max(left[1], right[1]);

		int diff = Integer.max(Math.abs(min - root.val), Math.abs(max - root.val));

		if (maxDiff < diff)
			maxDiff = diff;
		return new int[] { Integer.min(min, root.val), Integer.max(max, root.val) };
	}

	private static int maxAncestorDiff(TreeNode root) {
		maxDiff = Integer.MIN_VALUE;
		maxAncestorDiff(root, 0);
		return maxDiff;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(8);
		bt.root.left = new TreeNode(3);
		bt.root.right = new TreeNode(10);
		bt.root.left.left = new TreeNode(1);
		bt.root.left.right = new TreeNode(6);
		bt.root.left.right.left = new TreeNode(4);
		bt.root.left.right.right = new TreeNode(7);
		bt.root.right.right = new TreeNode(14);
		bt.root.right.right.left = new TreeNode(13);

		int ans = maxAncestorDiff(bt.root);

		System.out.println(ans);

	}

}
