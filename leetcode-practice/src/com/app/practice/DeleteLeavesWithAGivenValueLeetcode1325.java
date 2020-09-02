package com.app.practice;

import java.util.Queue;
import java.util.LinkedList;

import com.app.practice.BinaryTree.TreeNode;

public class DeleteLeavesWithAGivenValueLeetcode1325 {
	private static boolean cleanNodes(TreeNode root, int x) {
		if(root == null)
			return false;
		boolean left = cleanNodes(root.left, x);
		boolean right = cleanNodes(root.right, x);
		if(left)
			root.left = null;
		if(right)
			root.right = null;
		if(root.val == x && root.left == null && root.right == null)
			return true;
		else
			return false;
	}
	
	private static TreeNode removeLeafNodes(TreeNode root, int target) {
		if(cleanNodes(root, target))
			return null;
		return root;
	}
	
	private static void traverse(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			TreeNode node = q.poll();
			System.out.print(node.val + " ");
			if(node.left != null)
				q.add(node.left);
			if(node.right != null)
				q.add(node.right);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(4);
		
		root = removeLeafNodes(root, 2);
		
		traverse(root);

	}

}
