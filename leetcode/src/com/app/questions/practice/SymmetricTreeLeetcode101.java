package com.app.questions.practice;

import com.app.questions.practice.BinaryTree.TreeNode;

public class SymmetricTreeLeetcode101 {
	private static boolean isSymmetric(TreeNode root1, TreeNode root2) {
		if(root1 == null && root2 == null)
			return true;
		if(root1 == null || root2 == null)
			return false;
		return (root1.data == root2.data) && isSymmetric(root1.left, root2.right)
				&& isSymmetric(root1.right, root2.left);
	}
	
	private static boolean isSymmetric(TreeNode root) {
		if(root == null)
			return true;
		TreeNode left = root.left;
		TreeNode right = root.right;
		
		return isSymmetric(left, right);
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(1);
		bt.root.left = new TreeNode(2);
		bt.root.right = new TreeNode(2);
		bt.root.left.left = new TreeNode(3);
		bt.root.left.right = new TreeNode(4);
		bt.root.right.left = new TreeNode(4);
		bt.root.right.right = new TreeNode(3);
		
		System.out.println(isSymmetric(bt.root));
		
		bt = new BinaryTree();
		bt.root = new TreeNode(1);
		bt.root.left = new TreeNode(2);
		bt.root.right = new TreeNode(2);
		bt.root.left.right = new TreeNode(3);
		bt.root.right.right = new TreeNode(3);
		
		System.out.println(isSymmetric(bt.root));
	}

}
