package com.app.practice.tree;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class PathSumLeetcode112 {
	private static boolean isLeaf(TreeNode root) {
		return (root.left == null && root.right == null);
	}
	
	private static boolean isPathSum(TreeNode root, int sum, int currentSum) {
		if(root == null)
			return false;
		if(isLeaf(root)) {
			if(currentSum + root.val == sum)
				return true;
			else
				return false;
		}
		currentSum += root.val;
		boolean lSum = isPathSum(root.left, sum, currentSum);
		boolean rSum = isPathSum(root.right, sum, currentSum);
		return (lSum || rSum);
	}
	
	private static boolean hasPathSum(TreeNode root, int sum) {
		if(root == null)
			return false;
		return isPathSum(root, sum, 0);
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
		
		int sum = 22;
		
		boolean ans = hasPathSum(bt.root, sum);
		
		System.out.println(ans);

	}

}
