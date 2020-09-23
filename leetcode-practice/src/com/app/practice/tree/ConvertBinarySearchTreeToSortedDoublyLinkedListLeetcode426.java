package com.app.practice.tree;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class ConvertBinarySearchTreeToSortedDoublyLinkedListLeetcode426 {
	private static TreeNode head = null;
	private static TreeNode prev = null;

	private static void convertRec(TreeNode root) {
		if (root == null)
			return;
		convertRec(root.left);
		if (head == null)
			head = root;
		else {
			prev.right = root;
			root.left = prev;
		}
		prev = root;
		convertRec(root.right);
	}

	private static TreeNode treeToDoublyList(TreeNode root) {
		if (root == null)
			return null;
		head = null;
		prev = null;
		convertRec(root);

//		head.left = prev;
//		prev.right = head;
		return head;
	}

	private static void displayList(TreeNode root) {
		TreeNode tmp = root;
		while (tmp != null) {
			System.out.print(tmp.val + " ");
			tmp = tmp.right;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(4);
		bt.root.left = new TreeNode(2);
		bt.root.right = new TreeNode(5);
		bt.root.left.left = new TreeNode(1);
		bt.root.left.right = new TreeNode(3);

		bt.root = treeToDoublyList(bt.root);

		displayList(bt.root);
	}

}
