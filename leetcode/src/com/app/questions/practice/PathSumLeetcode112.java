package com.app.questions.practice;

import com.app.questions.practice.BinaryTree.TreeNode;

public class PathSumLeetcode112 {

	private static boolean isPathSum(TreeNode root, int currentSum, int sum) {
		
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(5);
		bt.root.left = new TreeNode(4);
		bt.root.right = new TreeNode(8);
		bt.root.left.left = new TreeNode(11);
		bt.root.left.left.left = new TreeNode(7);
		bt.root.left.left.right = new TreeNode(2);
		bt.root.right.left = new TreeNode(13);
		bt.root.right.right = new TreeNode(4);
		bt.root.right.right.right = new TreeNode(1);
		
		System.out.println(isPathSum(bt.root, 0, 22));

	}

}
