package com.app.practice;

import com.app.practice.BinaryTree.TreeNode;

public class PathSumLeetcode112 {
	private static boolean isLeaf(TreeNode root) {
		return root.left == null && root.right == null;
	}
	
	private static boolean hasPathSum(TreeNode root, int sum, int currentSum) {
		if(root == null)
			return false;
		if(isLeaf(root)) {
			if(sum == currentSum + root.val)
				return true;
			else
				return false;
		}
		currentSum += root.val;
		boolean l = hasPathSum(root.left, sum, currentSum);
		boolean r = hasPathSum(root.right, sum, currentSum);
		return l || r;
	}
	
	private static boolean isPathSum(TreeNode root, int sum) {
		return hasPathSum(root, sum, 0);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);
		
		boolean isPathSum = isPathSum(root, 22);
		
		System.out.println(isPathSum);

	}

}
