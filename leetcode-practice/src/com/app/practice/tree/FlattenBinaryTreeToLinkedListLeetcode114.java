package com.app.practice.tree;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class FlattenBinaryTreeToLinkedListLeetcode114 {
	private static void flatten(TreeNode root) {
		if(root == null)
			return;
		TreeNode left = root.left;
		TreeNode right = root.right;
		
		flatten(root.left);
		flatten(root.right);
		
		root.left = null;
		root.right = left;
		TreeNode tmp = root;
		while(tmp.right != null)
			tmp = tmp.right;
		tmp.right = right;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(1);
		bt.root.left = new TreeNode(2);
		bt.root.right = new TreeNode(5);
		bt.root.left.left = new TreeNode(3);
		bt.root.left.right = new TreeNode(4);
		bt.root.right.right = new TreeNode(6);
		
		flatten(bt.root);
		
		TreeNode tmp = bt.root;
		while(tmp != null) {
			System.out.print(tmp.val + " ");
			tmp = tmp.right;
		}
		System.out.println();
	}

}
