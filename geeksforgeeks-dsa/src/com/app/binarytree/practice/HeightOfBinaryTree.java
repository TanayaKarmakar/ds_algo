package com.app.binarytree.practice;

import com.app.binarytree.classroom.BinaryTree;
import com.app.binarytree.classroom.BinaryTree.Node;

public class HeightOfBinaryTree {
	private static int calculateHeight(Node root) {
		if(root == null) {
			return 0;
		}
		return 1 + Integer.max(calculateHeight(root.left), 
				calculateHeight(root.right));
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left = new Node(4);
		bt.root.right.left = new Node(5);
		bt.root.right.left.right = new Node(7);
		
		
		System.out.println("Height - " + calculateHeight(bt.root));

	}

}
