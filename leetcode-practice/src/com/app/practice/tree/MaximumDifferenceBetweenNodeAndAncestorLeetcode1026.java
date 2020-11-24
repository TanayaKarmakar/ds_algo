package com.app.practice.tree;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class MaximumDifferenceBetweenNodeAndAncestorLeetcode1026 {
	private static int maxDiff = 0;
	
	private static void maxDiffRec(TreeNode parent, TreeNode root) {
		if (root == null)
			return;
		int diff = Math.abs(parent.val - root.val);
		maxDiff = Integer.max(maxDiff, diff);
		maxDiffRec(parent, root.left);
		maxDiffRec(parent, root.right);
	}

	private static void postOrder(TreeNode root) {
		if (root == null)
			return;
		
		postOrder(root.left);
		postOrder(root.right);

		maxDiffRec(root, root.left);
		maxDiffRec(root, root.right);
	}

	private static int maxAncestorDiff(TreeNode root) {
		if (root == null)
			return 0;
		postOrder(root);
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
