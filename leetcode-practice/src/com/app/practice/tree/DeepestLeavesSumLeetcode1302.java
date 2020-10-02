package com.app.practice.tree;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class DeepestLeavesSumLeetcode1302 {
	private static int maxDepth = 0;
	private static int sum = 0;

	private static void deepestLeavesSum(TreeNode root, int currentDepth) {
		if (root == null)
			return;
		boolean isLeaf = (root.left == null && root.right == null);
		if (isLeaf) {
			if (maxDepth < currentDepth) {
				sum = root.val;
				maxDepth = currentDepth;
			} else if (currentDepth == maxDepth) {
				sum += root.val;
			} else {
				return;
			}
		}
		deepestLeavesSum(root.left, currentDepth + 1);
		deepestLeavesSum(root.right, currentDepth + 1);
	}

	private static int deepestLeavesSum(TreeNode root) {
		maxDepth = 0;
		sum = 0;
		deepestLeavesSum(root, 0);
		return sum;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(1);
		bt.root.left = new TreeNode(2);
		bt.root.right = new TreeNode(3);
		bt.root.left.left = new TreeNode(4);
		bt.root.left.right = new TreeNode(5);
		bt.root.left.left.left = new TreeNode(7);
		bt.root.right.right = new TreeNode(6);
		bt.root.right.right.right = new TreeNode(8);
		
		int sum = deepestLeavesSum(bt.root);
		
		System.out.println(sum);
		

	}

}
