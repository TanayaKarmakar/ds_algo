package com.app.practice;

import com.app.practice.BinaryTree.TreeNode;

public class MinimumDepthLeetcode111 {
	private static int minDepth(TreeNode root) {
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return 1;
		if(root.left == null)
			return 1 + minDepth(root.right);
		if(root.right == null)
			return 1 + minDepth(root.left);
		
		return Integer.min(minDepth(root.left), minDepth(root.right)) + 1;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(3);
		bt.root.left = new TreeNode(9);
		bt.root.right = new TreeNode(20);
		bt.root.right.left = new TreeNode(15);
		bt.root.right.right = new TreeNode(7);
		
		int minDepth = minDepth(bt.root);
		
		System.out.println(minDepth);

	}

}
