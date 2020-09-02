package com.app.practice.tree;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class BalancedBinaryTreeLeetcode110 {
	private static int checkBalance(TreeNode root) {
		if (root == null)
			return 0;
		int lBalance = checkBalance(root.left);
		if (lBalance == -1)
			return -1;
		int rBalance = checkBalance(root.right);
		if (rBalance == -1)
			return -1;

		if (Math.abs(lBalance - rBalance) > 1)
			return -1;
		else
			return 1 + Integer.max(lBalance, rBalance);
	}

	private static boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		if (checkBalance(root) == -1)
			return false;
		else
			return true;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(3);
		bt.root.left = new TreeNode(9);
		bt.root.right = new TreeNode(20);
		bt.root.right.left = new TreeNode(15);
		bt.root.right.right = new TreeNode(7);

		boolean isBalanced = isBalanced(bt.root);

		System.out.println(isBalanced);

		bt = new BinaryTree();
		bt.root = new TreeNode(1);
		bt.root.left = new TreeNode(2);
		bt.root.right = new TreeNode(2);
		bt.root.left.left = new TreeNode(3);
		bt.root.left.right = new TreeNode(3);
		bt.root.left.left.left = new TreeNode(4);
		bt.root.left.left.right = new TreeNode(4);

		isBalanced = isBalanced(bt.root);

		System.out.println(isBalanced);
	}

}
