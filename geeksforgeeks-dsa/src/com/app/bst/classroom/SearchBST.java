package com.app.bst.classroom;

import com.app.binarytree.classroom.BinaryTree;
import com.app.binarytree.classroom.BinaryTree.Node;

public class SearchBST {
	private static boolean searchIterative(Node root, int item) {
		while(root != null) {
			if(root.data == item)
				return true;
			else if(root.data > item)
				root = root.left;
			else
				root = root.right;
		}
		return false;
	}
	
	private static boolean search(Node root, int item) {
		if (root == null)
			return false;
		else if (root.data == item)
			return true;
		else if (root.data > item)
			return search(root.left, item);
		else
			return search(root.right, item);
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(15);
		bt.root.left = new Node(5);
		bt.root.right = new Node(20);
		bt.root.left.left = new Node(3);
		bt.root.right.left = new Node(18);
		bt.root.right.right = new Node(80);
		bt.root.right.left.left = new Node(16);

		System.out.println("Search(15) - " + search(bt.root, 15));
		System.out.println("SearchIterative(15) - " + searchIterative(bt.root, 15));
		System.out.println("Search(7) - " + search(bt.root, 7));
		System.out.println("SearchIterative(7) - " + searchIterative(bt.root, 7));
	}

}
