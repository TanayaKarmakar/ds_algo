package com.app.tree;

import com.app.tree.BinaryTree.TreeNode;

public class SumRootToLeafPathWithSpecifiedSum {
	private static boolean hasPathSumRec(TreeNode root, int currentSum, int sum) {
		if (root == null)
			return false;
		boolean isLeaf = (root.left == null && root.right == null);
		if (isLeaf) {
			if (currentSum + root.val == sum)
				return true;
			else
				return false;
		}
		currentSum += root.val;
		boolean lPath = hasPathSumRec(root.left, currentSum, sum);
		boolean rPath = hasPathSumRec(root.right, currentSum, sum);

		return (lPath || rPath);
	}

	private static boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		return hasPathSumRec(root, 0, sum);
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
		
		boolean hasPath = hasPathSum(bt.root, 22);
		
		System.out.println(hasPath);
	}

}
