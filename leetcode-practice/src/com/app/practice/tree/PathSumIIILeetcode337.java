package com.app.practice.tree;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class PathSumIIILeetcode337 {
	private static int rob(TreeNode root, boolean canRob) {
		if(root == null)
			return 0;
		if(canRob) {
			return root.val + rob(root.left, !canRob) + rob(root.right, !canRob);
		} else {
			int option1 = Integer.max(rob(root.left, canRob),
					rob(root.left, !canRob));
			int option2 = Integer.max(rob(root.right, canRob), 
					rob(root.right, !canRob));
			return option1 + option2;
		}
	}
	
	private static int rob(TreeNode root) {
		if(root == null)
			return 0;
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
		
		bt = new BinaryTree();
		bt.root = new TreeNode(3);
		bt.root.left = new TreeNode(4);
		bt.root.right = new TreeNode(5);
		bt.root.left.left = new TreeNode(1);
		bt.root.left.right = new TreeNode(3);
		bt.root.right.right = new TreeNode(1);
		
		ans = rob(bt.root);
		
		System.out.println(ans);

	}

}
