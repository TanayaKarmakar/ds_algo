package com.app.questions.dp;

import com.app.questions.practice.BinaryTree.TreeNode;

public class LargestIndependentSetGeeksForGeeks {
	private static int liss(TreeNode root, boolean include) {
		if(root == null)
			return 0;
		if(include) {
			return 1 + liss(root.left, !include) + liss(root.right, !include);
		} else {
			int part1 = Integer.max(liss(root.left, include), liss(root.left, !include));
			int part2 = Integer.max(liss(root.right, include), liss(root.right, !include));
			return part1 + part2;
		}
	}
	
	private static int liss(TreeNode root) {
		return Integer.max(liss(root, true), liss(root, false));
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(20);
		root.right = new TreeNode(30);
		root.left.left = new TreeNode(40);
		root.left.right = new TreeNode(50);
		root.left.right.left = new TreeNode(70);
		root.left.right.right = new TreeNode(80);
		root.right.right = new TreeNode(60);
		
		int liss = liss(root);
		
		System.out.println(liss);

	}

}
