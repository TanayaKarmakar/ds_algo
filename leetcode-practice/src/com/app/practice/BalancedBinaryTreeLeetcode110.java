package com.app.practice;

import com.app.practice.BinaryTree.TreeNode;

public class BalancedBinaryTreeLeetcode110 {
	private static int checkBalance(TreeNode root) {
		if(root == null)
			return 0;
		int l = checkBalance(root.left);
		
		if(l == -1)
			return -1;
		int r = checkBalance(root.right);
		
		if(r == -1)
			return -1;
		
		if(Math.abs(r - l) > 1)
			return -1;
		return 1 + Integer.max(l, r);
	}
	
	private static boolean isBalanced(TreeNode root) {
		if(checkBalance(root) == -1)
			return false;
		return true;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		System.out.println(isBalanced(root));
		
		root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(3);
		root.left.left.left = new TreeNode(4);
		root.left.left.right = new TreeNode(4);
		
		System.out.println(isBalanced(root));
	}

}
