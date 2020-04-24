package com.app.questions.read;

import com.app.questions.practice.BinaryTree;
import com.app.questions.practice.BinaryTree.TreeNode;

public class HouseRobber3Leetcode337 {
	private static int findMax(TreeNode root, boolean rob) {
		if(root == null)
			return 0;
		if(rob) {
			return root.data + findMax(root.left, !rob) 
			+ findMax(root.right, !rob);
		} else {
			int left = Integer.max(findMax(root.left, !rob), findMax(root.left, rob));
			int right = Integer.max(findMax(root.right, !rob), findMax(root.right, rob));
			return left + right;
		}
	}
	
	public static int rob(TreeNode root) {
		int option1 = findMax(root, false);
		int option2 = findMax(root, true);
		return Integer.max(option1, option2);
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(3);
		bt.root.left = new TreeNode(2);
		bt.root.right = new TreeNode(3);
		bt.root.left.right = new TreeNode(3);
		bt.root.right.right = new TreeNode(1);
		
		int maxMoney = rob(bt.root);
		System.out.println(maxMoney);

	}

}
