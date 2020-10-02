package com.app.practice.tree;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class HouseRobberIIILeetcode {
	private static int rob(TreeNode root, boolean rob) {
		if (root == null)
			return 0;
		if (rob) {
			return root.val + rob(root.left, !rob) + rob(root.right, !rob);
		} else {
			int part1 = Integer.max(rob(root.left, !rob), rob(root.left, rob));
			int part2 = Integer.max(rob(root.right, !rob), rob(root.right, rob));
			return part1 + part2;
		}
	}

	private static int rob(TreeNode root) {
		int option1 = rob(root, true);
		int option2 = rob(root, false);
		return Integer.max(option1, option2);
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(3);
		bt.root.left = new TreeNode(2);
		bt.root.right = new TreeNode(3);
		bt.root.left.right = new TreeNode(3);
		bt.root.right.right = new TreeNode(1);
		
		int ans = rob(bt.root);
		
		System.out.println(ans);
	}

}
