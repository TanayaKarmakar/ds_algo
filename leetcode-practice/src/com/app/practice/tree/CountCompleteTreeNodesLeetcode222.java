package com.app.practice.tree;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class CountCompleteTreeNodesLeetcode222 {
	private static int countNodes(TreeNode root) {
		if(root == null)
			return 0;
		int lHeight = 0;
		TreeNode temp = root;
		while(temp != null) {
			temp = temp.left;
			lHeight++;
		}
		
		int rHeight = 0;
		temp = root;
		while(temp != null) {
			temp = temp.right;
			rHeight++;
		}
		
		if(lHeight == rHeight)
			return (int)Math.pow(2, lHeight) - 1;
		
		return 1 + countNodes(root.left) + countNodes(root.right);
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(1);
		bt.root.left = new TreeNode(2);
		bt.root.right = new TreeNode(3);
		bt.root.left.left = new TreeNode(4);
		bt.root.left.right = new TreeNode(5);
		bt.root.right.left = new TreeNode(6);
		
		int ans = countNodes(bt.root);
		
		System.out.println(ans);

	}

}
