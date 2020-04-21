package com.app.questions.practice;

import com.app.questions.practice.BinaryTree.TreeNode;

public class BalancedBinaryTreeLeetcode110 {
	private static int checkBalance(TreeNode root) {
		if(root == null)
			return 0;
		int l = checkBalance(root.left);
		int r = checkBalance(root.right);
		
		if(l == -1 || r == -1)
			return -1;
		if(Math.abs(l - r) > 1)
			return -1;
		return 1 + Integer.max(l, r);
	}
	
	private static boolean isBalanced(TreeNode root) {
		if(checkBalance(root) == -1)
			return false;
		return true;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(3);
		bt.root.left = new TreeNode(9);
		bt.root.right = new TreeNode(20);
		bt.root.right.left = new TreeNode(15);
		bt.root.right.right = new TreeNode(7);
		
		System.out.println(isBalanced(bt.root));
		
		bt = new BinaryTree();
		bt.root = new TreeNode(1);
		bt.root.left = new TreeNode(2);
		bt.root.right = new TreeNode(2);
		bt.root.left.left = new TreeNode(3);
		bt.root.left.right = new TreeNode(3);
		bt.root.left.left.left = new TreeNode(4);
		bt.root.left.left.right = new TreeNode(4);
		
		System.out.println(isBalanced(bt.root));
	}

}
