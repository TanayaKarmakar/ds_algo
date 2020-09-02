package com.app.practice.tree;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class ValidateBinarySearchTreeLeetcode98 {
	private static boolean checkBST(TreeNode root, int minVal, int maxVal) {
		if(root == null)
			return true;
		if(root.val <= minVal || root.val >= maxVal)
			return false;
		boolean left = checkBST(root.left, minVal, root.val);
		boolean right = checkBST(root.right, root.val, maxVal);
		return (left && right);
	}
	
	private static boolean isValidBST(TreeNode root) {
		if(root == null)
			return true;
		return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(2);
		bt.root.left = new TreeNode(1);
		bt.root.right = new TreeNode(3);
		
		System.out.println(isValidBST(bt.root));
		
		bt = new BinaryTree();
		bt.root = new TreeNode(5);
		bt.root.left = new TreeNode(1);
		bt.root.right = new TreeNode(4);
		bt.root.right.left = new TreeNode(3);
		bt.root.right.right = new TreeNode(6);
		
		System.out.println(isValidBST(bt.root));

	}

}
