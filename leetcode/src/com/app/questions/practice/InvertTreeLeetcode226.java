package com.app.questions.practice;

import com.app.questions.practice.BinaryTree.TreeNode;

public class InvertTreeLeetcode226 {
	private static TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		root.left = invertTree(root.left);
		root.right = invertTree(root.right);
		return root;
	}
	
	private static void preorder(TreeNode root) {
		if(root != null) {
			System.out.print(root.data + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(4);
		bt.root.left = new TreeNode(2);
		bt.root.right = new TreeNode(7);
		bt.root.left.left = new TreeNode(1);
		bt.root.left.right = new TreeNode(3);
		bt.root.right.left = new TreeNode(6);
		bt.root.right.right = new TreeNode(9);
		
		bt.root = invertTree(bt.root);
		preorder(bt.root);
		System.out.println();
	}

}
