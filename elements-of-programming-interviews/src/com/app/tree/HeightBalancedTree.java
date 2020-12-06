package com.app.tree;

import com.app.tree.BinaryTree.TreeNode;

//check if a tree is height balanced
public class HeightBalancedTree {
	private static int isBalancedRec(TreeNode root) {
		if (root == null)
			return 0;
		int lHeight = isBalancedRec(root.left);
		if (lHeight == -1)
			return -1;
		int rHeight = isBalancedRec(root.right);
		if (rHeight == -1)
			return -1;

		if (Math.abs(lHeight - rHeight) <= 1)
			return 1 + Math.abs(lHeight - rHeight);
		return -1;
	}

	private static boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		if (isBalancedRec(root) == -1)
			return false;
		return true;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(1);
		bt.root.left = new TreeNode(2);
		bt.root.right = new TreeNode(3);
		bt.root.left.left = new TreeNode(4);
		bt.root.left.left.left = new TreeNode(5);
		
		boolean ans = isBalanced(bt.root);
		
		System.out.println(ans);

	}

}
