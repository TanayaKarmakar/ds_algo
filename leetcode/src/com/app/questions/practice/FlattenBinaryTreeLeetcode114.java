package com.app.questions.practice;

import com.app.questions.practice.BinaryTree.TreeNode;

public class FlattenBinaryTreeLeetcode114 {
	private static TreeNode findLast(TreeNode root) {
		TreeNode temp = root;
		while(temp.right != null) {
			temp = temp.right;
		}
		return temp;
	}
	
	private static TreeNode flatten(TreeNode root) {
		if(root == null)
			return null;
		TreeNode left = root.left;
		TreeNode right = root.right;
		left = flatten(left);
		right = flatten(right);
		TreeNode node = null;
		if(left != null) {
			node = left;
			left.left = null;
		}
		
		if(right != null) {
			if(node != null) {
				TreeNode last = findLast(node);
				last.right = right;
			} else {
				node = right;
			}
			right.left = null;
		}
		
		root.right = node;
		root.left = null;
		return root;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(1);
		bt.root.left = new TreeNode(2);
		bt.root.left.left = new TreeNode(3);
		bt.root.left.right = new TreeNode(4);
		bt.root.right = new TreeNode(5);
		bt.root.right.right = new TreeNode(6);
		
		bt.root = flatten(bt.root);
		
		TreeNode temp = bt.root;
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.right;
		}

	}

}
