package com.app.questions.practice;

import com.app.questions.practice.BinaryTree.TreeNode;

public class MaximumDepthOfBinaryTreeLeetcode104 {
	private static int maxHeight(TreeNode root) {
		if(root == null)
			return 0;
		int lh = maxHeight(root.left);
		int rh = maxHeight(root.right);
		return 1 + Integer.max(lh, rh);
	}
	
	private static int maxDepth(TreeNode root) {
		return maxHeight(root);
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(3);
		bt.root.left = new TreeNode(9);
		bt.root.right = new TreeNode(20);
		bt.root.right.left = new TreeNode(15);
		bt.root.right.right = new TreeNode(7);
		
		int maxDepth = maxDepth(bt.root);
		
		System.out.println(maxDepth);

	}

}
