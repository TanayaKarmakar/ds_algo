package com.app.practice;

import com.app.practice.BinaryTree.TreeNode;

public class DeepestLeavesSumLeetcode1302Efficient {
	private static int sum = 0;
	private static int maxDepth = 0;
	
	private static void performSum(TreeNode root, int currentDepth) {
		if(root == null)
			return;
		boolean isLeaf = (root.left == null && root.right == null);
		if(isLeaf) {
			if(maxDepth < currentDepth) {
				maxDepth = currentDepth;
				sum = root.val;
			} else if(maxDepth == currentDepth) {
				sum += root.val;
			} else {
				return;
			}
		}
		performSum(root.left, currentDepth + 1);
		performSum(root.right, currentDepth + 1);
	}
	
	private static int deepestLeavesSum(TreeNode root) {
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return root.val;
		maxDepth = 0;
		sum = 0;
		performSum(root.left, 0);
		performSum(root.left, 0);
		return sum;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.left.left = new TreeNode(7);
		root.right.right = new TreeNode(6);
		root.right.right.right = new TreeNode(8);
		
		int sum = deepestLeavesSum(root);
		
		System.out.println(sum);

	}

}
