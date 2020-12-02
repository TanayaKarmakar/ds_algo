package com.app.practice.tree;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class ValidateBinarySearchTreeLeetcode98 {
	private static boolean isValidBSTRec(TreeNode root, long min, long max) {
		if (root.val > min && root.val < max) {
			boolean l = true;
			boolean r = true;

			if (root.left != null) {
				l = isValidBSTRec(root.left, min, root.val);
			}

			if (root.right != null) {
				r = isValidBSTRec(root.right, root.val, max);
			}

			return (l && r);
		}
		return false;
	}

	private static boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		return isValidBSTRec(root, (long)2 * Integer.MIN_VALUE, (long)2 * Integer.MAX_VALUE);
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(2);
		bt.root.left = new TreeNode(1);
		bt.root.right = new TreeNode(3);

		boolean ans = isValidBST(bt.root);

		System.out.println(ans);

		bt = new BinaryTree();
		bt.root = new TreeNode(5);
		bt.root.left = new TreeNode(1);
		bt.root.right = new TreeNode(4);
		bt.root.right.left = new TreeNode(3);
		bt.root.right.right = new TreeNode(6);

		ans = isValidBST(bt.root);

		System.out.println(ans);

	}

}
