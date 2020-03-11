package com.app.bst.classroom;

import com.app.binarytree.classroom.BinaryTree;
import com.app.binarytree.classroom.BinaryTree.Node;

public class FloorBST {
	private static Node floor(Node root, int x) {
		Node res = null;
		while (root != null) {
			if (root.data == x)
				return root;
			else if (root.data > x)
				root = root.left;
			else {
				res = root;
				root = root.right;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(50);
		bt.root.left = new Node(30);
		bt.root.right = new Node(70);
		bt.root.left.left = new Node(20);
		bt.root.left.right = new Node(40);
		bt.root.right.left = new Node(60);
		bt.root.right.right = new Node(80);
		bt.root.right.left.left = new Node(55);
		bt.root.right.left.right = new Node(65);
		
		Node floor = floor(bt.root, 58);
		
		System.out.println("Data - " + floor.data);

	}

}
