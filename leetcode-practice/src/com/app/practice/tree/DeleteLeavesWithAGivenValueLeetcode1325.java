package com.app.practice.tree;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class DeleteLeavesWithAGivenValueLeetcode1325 {
	private static TreeNode removeLeafNodes(TreeNode root, int target) {
		if(root == null)
			return null;
		root.left = removeLeafNodes(root.left, target);
		root.right = removeLeafNodes(root.right, target);
		if(root.val == target) {
			boolean isLeaf = (root.left == null && root.right == null);
			if(isLeaf)
				return null;
		}
		return root;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(1);
		bt.root.left = new TreeNode(2);
		bt.root.right = new TreeNode(3);
		bt.root.left.left = new TreeNode(2);
		bt.root.right.left = new TreeNode(2);
		bt.root.right.right = new TreeNode(4);
		
		bt.root = removeLeafNodes(bt.root, 2);
		
		

	}

}
