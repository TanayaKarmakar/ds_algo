package com.app.practice.tree;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class SameTreeLeetcode100 {
	private static boolean isSame(TreeNode root1, TreeNode root2) {
		if(root1 == null && root2 == null)
			return true;
		if(root1 == null || root2 == null)
			return false;
		return (root1.val == root2.val && isSame(root1.left, root2.left) 
				&& isSame(root1.right, root2.right));
	}

	public static void main(String[] args) {
		BinaryTree bt1 = new BinaryTree();
		bt1.root = new TreeNode(1);
		bt1.root.left = new TreeNode(2);
		bt1.root.right = new TreeNode(3);
		
		BinaryTree bt2 = new BinaryTree();
		bt2.root = new TreeNode(1);
		bt2.root.left = new TreeNode(2);
		bt2.root.right = new TreeNode(3);
		
		
		boolean isSame = isSame(bt1.root, bt2.root);
		
		System.out.println(isSame);

	}

}
