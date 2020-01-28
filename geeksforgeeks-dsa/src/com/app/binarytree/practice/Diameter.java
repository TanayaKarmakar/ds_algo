package com.app.binarytree.practice;

import com.app.binarytree.classroom.BinaryTree;
import com.app.binarytree.classroom.BinaryTree.Node;

public class Diameter {
	private static int height(Node root) {
		if(root == null)
			return 0;
		return 1 + Integer.max(height(root.left), height(root.right));
	}
	
	private static int diameter(Node root) {
		if(root == null)
			return 0;
		int opt1 = height(root.left) + height(root.right);
		int opt2 = diameter(root.left);
		int opt3 = diameter(root.right);
		
		return Integer.max(opt1, Integer.max(opt2, opt3));
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.right.right = new Node(5);
		
		System.out.println("Diameter - " + diameter(bt.root));

		bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.left.right = new Node(6);
		bt.root.left.left.left = new Node(8);
		bt.root.left.left.left.left = new Node(10);
		bt.root.left.right.right = new Node(9);
		bt.root.left.right.right.right = new Node(11);
		bt.root.left.right.right.right.right = new Node(12);
		bt.root.right.right = new Node(5);
		
		System.out.println("Diameter - " + diameter(bt.root));
		
	}

}
