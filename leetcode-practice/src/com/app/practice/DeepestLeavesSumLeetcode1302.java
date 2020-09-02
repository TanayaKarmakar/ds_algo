package com.app.practice;

import com.app.practice.BinaryTree.TreeNode;

public class DeepestLeavesSumLeetcode1302 {
	private static int sum = 0;
	
	private static int height(TreeNode root) {
		if(root == null)
			return 0;
		int lh = height(root.left);
		int rh = height(root.right);
		return 1 + Integer.max(lh, rh);
	}
	
	private static void getSum(TreeNode root, int currentHeight, int maxHeight) {
		if(root == null)
			return;
		if(currentHeight == maxHeight) {
			sum += root.val;
			return;
		}
		getSum(root.left, currentHeight + 1, maxHeight);
		getSum(root.right, currentHeight + 1, maxHeight);
	}
	
	private static int deepestLeavesSum(TreeNode root) {
		sum = 0;
		int maxHeight = height(root);
		getSum(root, 1, maxHeight);
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
