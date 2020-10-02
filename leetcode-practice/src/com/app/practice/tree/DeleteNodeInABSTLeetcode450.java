package com.app.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class DeleteNodeInABSTLeetcode450 {
	private static TreeNode deleteNode(TreeNode root, int key) {
		if (root == null)
			return null;
		if (root.val < key)
			root.right = deleteNode(root.right, key);
		else if (root.val > key)
			root.left = deleteNode(root.left, key);
		else {
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			else {
				TreeNode start = root.right;
				while (start != null && start.left != null) {
					start = start.left;
				}
				root.val = start.val;
				root.right = deleteNode(root.right, start.val);
			}
		}
		return root;
	}

	private static void levelOrderTraversal(TreeNode root) {
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
		bt.root = new TreeNode(5);
		bt.root.left = new TreeNode(3);
		bt.root.right = new TreeNode(6);
		bt.root.left.left = new TreeNode(2);
		bt.root.left.right = new TreeNode(4);
		bt.root.right.right = new TreeNode(6);

		bt.root = deleteNode(bt.root, 3);

		levelOrderTraversal(bt.root);
	}

}
