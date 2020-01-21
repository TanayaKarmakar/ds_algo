package com.app.binarytree.classroom;

import com.app.binarytree.classroom.BinaryTree.Node;

public class SizeOfATree {
	private static Integer count = 0;

	private static void size(Node root) {
		if (root != null) {
			++count;
			size(root.left);
			size(root.right);
		}
	}
	
	private static int getSize(Node root) {
		if(root == null)
			return 0;
		return 1 + getSize(root.left) + getSize(root.right);
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(10);
		bt.root.left = new Node(20);
		bt.root.right = new Node(30);
		bt.root.left.left = new Node(40);
		bt.root.right.left = new Node(50);
		bt.root.right.right = new Node(60);

		// Integer count = 0;
		size(bt.root);

		System.out.println("Size of a tree - " + count);
		
		System.out.println("Size of a tree1 - " + getSize(bt.root));
	}

}
