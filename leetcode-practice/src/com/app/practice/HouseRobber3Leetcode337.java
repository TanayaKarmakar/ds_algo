package com.app.practice;

import com.app.practice.BinaryTree.TreeNode;

public class HouseRobber3Leetcode337 {
	private static int findMax(TreeNode root, boolean rob) {
		if(root == null)
			return 0;
		if(rob) {
			return root.val + findMax(root.left, !rob)
			+ findMax(root.right, !rob);
		} else {
			int part1 = Integer.max(findMax(root.left, rob), findMax(root.left, !rob));
			int part2 = Integer.max(findMax(root.right, rob), findMax(root.right, !rob));
			return part1 + part2;
		}
	}
	
	private static int rob(TreeNode root) {
		int option1 = findMax(root, true);
		int option2 = findMax(root, false);
		return Integer.max(option1, option2);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(3);
		root.right.right = new TreeNode(1);
		
		int max = rob(root);
		
		System.out.println(max);

	}

}
