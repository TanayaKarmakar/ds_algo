package com.app.questions.practice;

import com.app.questions.practice.BinaryTree.TreeNode;

public class ValidateBSTLeetcode98 {
	private static boolean isValidBSTRec(TreeNode root, long min, long max) {
		if(root.data > min && root.data < max) {
			boolean l = true;
			boolean r = true;
			
			if(root.left != null) {
				l = isValidBSTRec(root.left, min, root.data);
			}
			if(root.right != null) {
				r = isValidBSTRec(root.right, root.data, max);
			}
			return l & r;
		}
		return false;
	}
	
	public static  boolean isValidBST(TreeNode root) {
		if(root == null)
			return true;
		return isValidBSTRec(root, (long)2 * Integer.MIN_VALUE, (long)2 * Integer.MAX_VALUE);
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
