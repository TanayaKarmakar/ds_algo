package com.app.practice.tree;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class HouseRobber3Leetcode337 {
	private static int rob(TreeNode root, boolean robbed) {
		if(root == null)
			return 0;
		if(robbed) {
			return root.val + rob(root.left, !robbed) + rob(root.right, !robbed);
		} else {
			return Integer.max(rob(root.left, !robbed), rob(root.left, robbed)) 
					+ Integer.max(rob(root.right, !robbed), rob(root.right, robbed));
		}
	}
	
	private static int rob(TreeNode root) {
		return Integer.max(rob(root, true), rob(root, false));
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(3);
		bt.root.left = new TreeNode(2);
		bt.root.right = new TreeNode(3);
		bt.root.left.right = new TreeNode(3);
		bt.root.right.right = new TreeNode(1);
		
		int maxValue = rob(bt.root);
		
		System.out.println(maxValue);

	}

}
