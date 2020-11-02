package com.app.practice.tree;

import com.app.practice.BinaryTree.TreeNode;

public class BalancedBinaryTreeLeetcode110 {
	private static int checkBalance(TreeNode root) {
		if (root == null)
			return 0;
		int lHeight = checkBalance(root.left);
		if (lHeight == -1)
			return -1;
		int rHeight = checkBalance(root.right);
		if (rHeight == -1)
			return -1;
		if (Math.abs(lHeight - rHeight) <= 1)
			return 1 + Math.max(lHeight, rHeight);
		else
			return -1;
	}

	private static boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		if (checkBalance(root) == -1)
			return false;
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
