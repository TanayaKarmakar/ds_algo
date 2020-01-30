package com.app.questions;

import com.app.questions.BinaryTree1.TreeNode;

class BinaryTree1 {
	TreeNode root;

	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode next;

		public TreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
			this.next = null;
		}
	}
}

public class PopulateNextRightPointers {
	private static void connect(TreeNode root) {
		if (root == null)
			return;

		TreeNode left = root.left;
		TreeNode right = root.right;
		if (left != null) {
			left.next = right;
		}

		if (right != null) {
			right.next = (root.next != null ? root.next.left : null);
		}
		connect(left);
		connect(right);
	}

	private static void traverseTree(TreeNode root) {
		while (root != null) {
			TreeNode curr = root;
			while (curr != null) {
				System.out.print(curr.data + " ");
				curr = curr.next;
			}
			System.out.println();
			root = root.left;
		}
	}

	public static void main(String[] args) {
		BinaryTree1 cTree = new BinaryTree1();
		cTree.root = new TreeNode(1);
		cTree.root.left = new TreeNode(2);
		cTree.root.right = new TreeNode(3);
		cTree.root.left.left = new TreeNode(4);
		cTree.root.left.right = new TreeNode(5);
		cTree.root.right.left = new TreeNode(6);
		cTree.root.right.right = new TreeNode(7);

		connect(cTree.root);

		traverseTree(cTree.root);

	}

}
