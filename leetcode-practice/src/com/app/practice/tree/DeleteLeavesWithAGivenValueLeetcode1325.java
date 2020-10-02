package com.app.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class DeleteLeavesWithAGivenValueLeetcode1325 {
	private static TreeNode removeLeafNodes(TreeNode root, int target) {
		if (root == null)
			return null;
		root.left = removeLeafNodes(root.left, target);
		root.right = removeLeafNodes(root.right, target);

		if (root.val == target && root.left == null && root.right == null)
			return null;
		return root;
	}

	private static void levelOrder(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			System.out.print(node.val + " ");
			if (node.left != null)
				q.add(node.left);
			if (node.right != null)
				q.add(node.right);
		}
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(1);
		bt.root.left = new TreeNode(2);
		bt.root.right = new TreeNode(3);
		bt.root.left.left = new TreeNode(2);
		bt.root.right.left = new TreeNode(2);
		bt.root.right.right = new TreeNode(4);

		int target = 2;
		bt.root = removeLeafNodes(bt.root, target);
		
		levelOrder(bt.root);
		
		System.out.println();

	}

}
