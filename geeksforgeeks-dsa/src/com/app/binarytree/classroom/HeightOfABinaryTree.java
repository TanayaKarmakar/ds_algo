package com.app.binarytree.classroom;

import com.app.binarytree.classroom.BinaryTree.Node;

public class HeightOfABinaryTree {
	private static int height(Node root) {
		if(root == null)
			return 0;
		else {
			int leftSubtreeHeight = height(root.left);
			int rightSubtreeHeight = height(root.right);
			
			return 1 + Integer.max(leftSubtreeHeight, rightSubtreeHeight);
		}
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(10);
		bt.root.left = new Node(20);
		bt.root.right = new Node(60);
		bt.root.left.left = new Node(40);
		bt.root.left.right = new Node(50);
		
		System.out.println("Height - " + height(bt.root));

	}

}
