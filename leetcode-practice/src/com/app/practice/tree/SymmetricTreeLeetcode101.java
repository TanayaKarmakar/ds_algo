package com.app.practice.tree;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class SymmetricTreeLeetcode101 {
	private static boolean isEqual(TreeNode root1, TreeNode root2) {
		if(root1 == null && root2 == null)
			return true;
		if(root1 == null || root2 == null)
			return false;
		return (root1.val == root2.val) 
				&& isEqual(root1.left, root2.right)
				&& isEqual(root1.right, root2.left);
	}
	
	private static boolean isSymmetric(TreeNode root) {
		if(root == null)
			return true;
		TreeNode left = root.left;
		TreeNode right = root.right;
		return isEqual(left, right);
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
		
		boolean ans = isSymmetric(bt.root);
		
		System.out.println(ans);

	}

}
