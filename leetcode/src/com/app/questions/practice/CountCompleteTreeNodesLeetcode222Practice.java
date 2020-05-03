package com.app.questions.practice;

import com.app.questions.practice.BinaryTree.TreeNode;

public class CountCompleteTreeNodesLeetcode222Practice {
	private static int countNodes(TreeNode node) {
		if(node == null)
			return 0;
		TreeNode temp = node;
		int lh = 0;
		while(temp != null) {
			temp = temp.left;
			lh++;
		}
		
		temp = node;
		int rh = 0;
		while(temp != null) {
			temp = temp.right;
			rh++;
		}
		
		if(lh == rh) {
			return (int)Math.pow(2, lh) - 1;
		}
		return 1 + countNodes(node.left) + countNodes(node.right);
	}
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(1);
		bt.root.left = new TreeNode(2);
		bt.root.right = new TreeNode(3);
		bt.root.left.left = new TreeNode(4);
		bt.root.left.right = new TreeNode(5);
		bt.root.right.left = new TreeNode(6);
		
		int count = countNodes(bt.root);
		
		System.out.println(count);
	}

}
