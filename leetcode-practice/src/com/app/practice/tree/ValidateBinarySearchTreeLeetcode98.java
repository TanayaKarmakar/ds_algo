package com.app.practice.tree;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class ValidateBinarySearchTreeLeetcode98 {
	private static boolean isValidBST(TreeNode root, long minValue, long maxValue) {
		if (root == null)
			return true;
		if (root.val > minValue && root.val < maxValue) {
			boolean l = true;
			boolean r = true;
			if (root.left != null)
				l = isValidBST(root.left, minValue, root.val);
			if (root.right != null)
				r = isValidBST(root.right, root.val, maxValue);
			return (l && r);
		}
		return false;
	}

	private static boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		return isValidBST(root, (long) (2 * Integer.MIN_VALUE), (long) (2 * Integer.MAX_VALUE));
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(5);
		bt.root.left = new TreeNode(1);
		bt.root.right = new TreeNode(4);
		bt.root.right.left = new TreeNode(3);
		bt.root.right.right = new TreeNode(6);
		
		boolean ans = isValidBST(bt.root);
		
		System.out.println(ans);
	}

}
