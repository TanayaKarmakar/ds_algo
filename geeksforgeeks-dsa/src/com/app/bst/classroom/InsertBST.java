package com.app.bst.classroom;

import com.app.binarytree.classroom.BinaryTree;
import com.app.binarytree.classroom.BinaryTree.Node;

public class InsertBST {
	private static Node insert(Node root, int data) {
		if (root == null)
			return new Node(data);
		else if (root.data > data)
			root.left = insert(root.left, data);
		else
			root.right = insert(root.right, data);
		return root;
	}

	private static void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}

	public static void main(String[] args) {
		int[] nums = { 10, 18, 8, 9, 24, 26, 15, 1 };
		BinaryTree bt = new BinaryTree();

		for (int i = 0; i < nums.length; i++) {
			bt.root = insert(bt.root, nums[i]);
		}
		
		System.out.println("Inorder traversal");
		inorder(bt.root);
		
		System.out.println();

	}

}
